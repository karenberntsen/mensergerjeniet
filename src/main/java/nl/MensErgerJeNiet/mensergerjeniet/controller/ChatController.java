package nl.MensErgerJeNiet.mensergerjeniet.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import nl.MensErgerJeNiet.mensergerjeniet.config.security.CustomUserDetails;
import nl.MensErgerJeNiet.mensergerjeniet.controller.ChatMessage.MessageType;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.Game;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.Statistics;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.GameRepository;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.StatisticsRepository;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.UserRepository;
import nl.MensErgerJeNiet.mensergerjeniet.game.model.MensErgerJeNiet;
import nl.MensErgerJeNiet.mensergerjeniet.game.model.Pawn;


/**
 * Created by rajeevkumarsingh on 24/07/17.
 */
@Controller
public class ChatController {

	private MensErgerJeNiet mejn = new MensErgerJeNiet();

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	GameRepository gameRepository;
	
	
//	@Autowired
//	StatisticsRepository statisticsRepository;
	
	public void botReplys(ChatMessage message) {
		if (!message.getType().equals(ChatMessage.MessageType.GAME))
			return;
		if(mejn.isFinished()) {
			Game game = new Game();
			game.setTurns(mejn.getRounds());
			game.setWinner(userRepository.findByUserName(mejn.getCurrentPlayer().getName()));
			gameRepository.save(game);
			List<String> usernames = mejn.getPlayerNames();
			for(String name : usernames) {
//				Statistics s = statisticsRepository.findStatisticsByUsername(name);
//				if(s== null) {
//					s = new Statistics();
//					s.setUser(userRepository.findByUserName(name));
//					if(game.getWinner().getUserName().equals(name)) {
//						s.setWin(s.getWin()+1);
//					} else {
//						s.setLoss(s.getLoss()+1);
//					}
//					statisticsRepository.save(s);
//				}
			}
			//TODO Statistics +1 aantal spellen alle meespelende spelers & +1 wins voor winnende speler (nieuwe statistics aanmaken voor nieuwe spelers)
			//nieuwe game met aantal beurten + winnende speler
			
			mejn = new MensErgerJeNiet();//reset spel
			return;
		}
		
		message.setSender(SecurityContextHolder.getContext().getAuthentication().getName());
		if (message.getContent().equals("start")) { // iedereen kan het spel starten
			mejn.startGame();
			sendDataMessage(message, "start");
		}else if (SecurityContextHolder.getContext().getAuthentication().getName().equals(mejn.getCurrentPlayer().getName())) { // alleen de speler die aan de beurt is mag acties uitvoeren
			String lastAction = "";
			if (message.getContent().equals("throw")) {
				mejn.throwDice();
				lastAction = "throw";
			} else if (message.getContent().startsWith("pion")) {
				mejn.doOption(Integer.parseInt(message.getContent().split("pion")[1].trim()));
				lastAction = "move";
			}
			sendDataMessage(message, lastAction);
		}
	}
		
	
	private void sendDataMessage(ChatMessage message, String lastAction) {
		int dice = mejn.getDice();
		int playerIndex = mejn.getPlayerIndex();
		int[] options = mejn.getPlayOptions();
		message.setType(MessageType.GAME_OPTIONS);
		message.setContent(getContentString(dice, playerIndex, options, lastAction));
		
	}

	private String pawnPosContent() {
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

	private String getContentString(int dice, int playerIndex, int[] options, String lastAction) {
		StringBuilder builder = new StringBuilder();
		builder.append("{ \"dice\":").append(dice).
		append(", \"pid\": ").append(playerIndex).
		append(", \"action\": \"").append(lastAction).
		append("\", \"pawns\": ").append(pawnPosContent()).
		append(", \"players\": ").append(playerNameList()).
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

	private String playerNameList() {
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


	@MessageMapping("/chat.sendMessage")
	@SendTo("/channel/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		botReplys(chatMessage);
		return chatMessage;
	}

	@MessageMapping("/chat.addUser")
	@SendTo("/channel/public")
	public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		chatMessage.setSender(SecurityContextHolder.getContext().getAuthentication().getName());
		mejn.addUser(chatMessage.getSender());
		return chatMessage;
	}

	@RequestMapping("/chat")
	public String chatPage(ModelMap model) {
		CustomUserDetails details = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		model.addAttribute("username", details.getUsername());
		return "chat";
	}

	public static HttpSession session() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getSession(true); // true == allow create
	}

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

}
