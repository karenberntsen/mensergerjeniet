package nl.MensErgerJeNiet.mensergerjeniet.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.Game;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.Statistics;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.services.GameService;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.services.StatisticsService;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.services.UserService;
import nl.MensErgerJeNiet.mensergerjeniet.game.model.MensErgerJeNiet;
import nl.MensErgerJeNiet.mensergerjeniet.game.model.Pawn;
import nl.MensErgerJeNiet.mensergerjeniet.rest.ChatMessage.MessageType;


/**
 * Created by rajeevkumarsingh on 24/07/17.
 */
@RestController
public class MultiGameController {

	private HashMap<String, MensErgerJeNiet> mejnlist = new HashMap<>();
	@Autowired
	UserService userService;
	
	@Autowired
	GameService gameService;
	
	@Autowired
	StatisticsService statService;
	
	@Autowired
	 private SimpMessagingTemplate messageSender;

	@GetMapping("/gameslist")
	public ArrayList<GameInfo> getGamesList() {
		ArrayList<GameInfo> gameInfos = new ArrayList<GameInfo>();
		for(String id: mejnlist.keySet()) {
			GameInfo gameInfo = new GameInfo();
			gameInfo.setId(id);
			gameInfo.setPlayerNames(mejnlist.get(id).getPlayerNames());
			gameInfos.add(gameInfo);
		}
		gameInfos.sort(new Comparator<GameInfo>() {
			@Override
			public int compare(GameInfo o1, GameInfo o2) {
				return o1.getId().compareTo(o2.getId());
			}
		});
		return gameInfos;
	}

	@MessageMapping("/chat.sendMessage/{id}")
	@SendTo("/channel/public/{id}")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage, @DestinationVariable String id) {
		System.out.println("User "+SecurityContextHolder.getContext().getAuthentication().getName() + " has send a message on channel " + id);
		gameReplys(chatMessage, id);
		return chatMessage;
	}

	@MessageMapping("/chat.addUser/{id}")
	@SendTo("/channel/public/{id}")
	public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor, @DestinationVariable  String id) {
		chatMessage.setSender(SecurityContextHolder.getContext().getAuthentication().getName());
		System.out.println("User "+SecurityContextHolder.getContext().getAuthentication().getName() + " has joined the channel " + id);
		if(mejnlist.containsKey(id)) {
			sendGameData(id, mejnlist.get(id));
		}
		return chatMessage;
	}
	
	@PostMapping("/game/{id}/join")
	public String joinGame(@PathVariable String id) {
		MensErgerJeNiet mejn = mejnlist.get(id);
		if(mejn == null) {
			mejn = new MensErgerJeNiet();
			mejnlist.put(id, mejn);
		}
		mejn.addUser(SecurityContextHolder.getContext().getAuthentication().getName());
		System.out.println("User "+SecurityContextHolder.getContext().getAuthentication().getName()+ " has joined the game "+ id);
		sendGameData(id, mejn);
		return "ok";
	}
	
	@PostMapping("/game/{id}/hax/{nr}")
	public void throwHax(@PathVariable String id, @PathVariable int nr) {
		MensErgerJeNiet mejn = mejnlist.get(id);
		mejn.setDice(nr);
		mejn.setHasThrown(true);
		sendGameData(id, mejn);
	}

	private void sendGameData(String id, MensErgerJeNiet mejn) {
		ChatMessage m = new ChatMessage();
		m.setSender(SecurityContextHolder.getContext().getAuthentication().getName());
		m.setContent(getJSONGameDataBuilder(mejn.getDice(), mejn.getPlayerIndex(), mejn.getPlayOptions(), "join", mejn));
		m.setType(MessageType.GAME_OPTIONS);
		messageSender.convertAndSend("/channel/public/"+ id, m);
	}

	public void gameReplys(ChatMessage message, String id) {
		MensErgerJeNiet mejn = mejnlist.get(id);
		if (!message.getType().equals(ChatMessage.MessageType.GAME))
			return;
		if(mejn.isFinished()) {
			saveGameData(mejn);
			mejnlist.remove(id);
			return;
		}
		System.out.println("game stuff");
		message.setSender(SecurityContextHolder.getContext().getAuthentication().getName());
		if (message.getContent().equals("start")) { // iedereen kan het spel starten
			if(mejn.getPlayerNames().contains(SecurityContextHolder.getContext().getAuthentication().getName())) {
				mejn.startGame();
				sendDataMessage(message, "start", mejn);
			}
		}else if (SecurityContextHolder.getContext().getAuthentication().getName().equals(mejn.getCurrentPlayer().getName())) { // alleen de speler die aan de beurt is mag acties uitvoeren
			String lastAction = "";
			if (message.getContent().equals("throw")) {
				mejn.throwDice();
				lastAction = "throw";
				System.out.println("throw action");
			} else if (message.getContent().startsWith("pion")) {
				mejn.doOption(Integer.parseInt(message.getContent().split("pion")[1].trim()));
				lastAction = "move";
				System.out.println("move action");
				if(mejn.isFinished()) {
					saveGameData(mejn);
					mejnlist.remove(id);
				}
			}
			sendDataMessage(message, lastAction, mejn);
		}
	}

	private void saveGameData(MensErgerJeNiet mejn) {
		Game game = new Game();
		game.setTurns(mejn.getRounds());
		game.setWinner(userService.findByUserName(mejn.getCurrentPlayer().getName()));
		gameService.save(game);
		List<String> usernames = mejn.getPlayerNames();
		for(String name : usernames) {
			saveUserStatistics(game, name);
		}
		mejn = new MensErgerJeNiet();//reset spel
	}

	private void saveUserStatistics(Game game, String name) {
		Statistics statistics = statService.getStatisticsByUsername(name);
		if( statistics == null ) {
			statistics = new Statistics();
			statistics.setUser(userService.findByUserName(name));
		}
		if(game.getWinner().getUserName().equals(name)) {
			statistics.setWin(statistics.getWin()+1);
		} else {
			statistics.setLoss(statistics.getLoss()+1);
		}
		statService.save(statistics);
	}
	
	private void sendDataMessage(ChatMessage message, String lastAction, MensErgerJeNiet mejn) {
		int dice = mejn.getDice();
		int playerIndex = mejn.getPlayerIndex();
		int[] options = mejn.getPlayOptions();
		message.setType(MessageType.GAME_OPTIONS);
		message.setContent(getJSONGameDataBuilder(dice, playerIndex, options, lastAction, mejn));
	}

	private String getJSONGameDataBuilder(int dice, int playerIndex, int[] options, String lastAction, MensErgerJeNiet mejn) {
		StringBuilder builder = new StringBuilder();
		builder.append("{ \"dice\":").append(dice).
		append(", \"pid\": ").append(playerIndex).
		append(", \"action\": \"").append(lastAction).
		append("\", \"pawns\": ").append(pawnPosJSONBuilder(mejn)).
		append(", \"players\": ").append(playerNameListBuilder(mejn)).
		append(" , \"options\": [");
		for(int i = 0; i < options.length; ++i) {
			builder.append(options[i]);
			if(i < options.length-1) {
				builder.append(",");
			}
		}
		builder.append("]}");
		return builder.toString();
	}
	
	private String pawnPosJSONBuilder(MensErgerJeNiet mejn) {
		StringBuilder builder = new StringBuilder();
		builder.append("[ ");
		ArrayList<Pawn> pawns = mejn.getPawns();
		for(int i = 0; i < pawns.size(); ++i) {
			builder.append("{");
			builder.append(" \"id\":").append(i).
			append(" , \"location\": \"").append(pawns.get(i).getLocation()).append("\"").
			append(", \"index\": ").append(pawns.get(i).getIndex()) .append("}");
			if(i < pawns.size()-1) {
				builder.append(", ");
			}
		}
		builder.append("]");
		return builder.toString();
	}

	private String playerNameListBuilder(MensErgerJeNiet mejn) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		ArrayList<String> list = mejn.getPlayerNames();
		for(int i =0; i < list.size(); ++i) {
			builder.append("\"").append(list.get(i)).append("\"");
			if(i < list.size()-1) {
				builder.append(", ");
			}
		}
		builder.append("]");
		
		return builder.toString();
	}

	public static HttpSession session() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getSession(true); // true == allow create
	}
}
