package nl.MensErgerJeNiet.mensergerjeniet.game.model;

import java.util.ArrayList;

/**
 * Deze klasse representeert het Mens Erger Je Niet spel. Het bestaat uit het
 * bord (board), de spelers (players) en een playerIndex, waarmee bijgehouden
 * wordt welke speler aan de beurt is. Er kunnen zowel computerspelers als
 * menselijke spelers meedoen.
 */

public class MensErgerJeNiet {

	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Pawn> pawns = new ArrayList<Pawn>();
	private int playerIndex = 0;
	private static GameBoard board = new GameBoard();
	private int dice;
	private boolean hasThrown;
	private boolean gameStarted;
	private boolean finished;
	
	/**
	 * Constructor. Het aantal computerspelers en het aantal menselijke spelers is
	 * nodig als input.
	 */
	public void addUser(String name) {
		addPlayer(new HumanPlayer(name, (players.size() + 1) * 10, board));
	}

	public void addBot(String name) {
		addPlayer(new ComputerPlayer(name, (players.size() + 1) * 10, board));
	}

	private void addPlayer(Player player) {
		if (gameStarted) return;
		if (players.size() > 3) return;
		players.add(player);
		pawns.addAll(player.getPawns());
	}

	public void startGame() {
		if (players.size() < 2)
			return;
		gameStarted = true;
	}

	/**
	 * Met deze functie wordt de beurt doorgegeven aan de volgende speler.
	 */
	public void nextPlayer() {
		playerIndex = ++playerIndex % players.size();
	}

	public Player getCurrentPlayer() {
		return players.get(playerIndex);
	}

	public int throwDice() {
//		if (!hasThrown && !isFinished()) {
			dice = (int) (Math.random() * 6 + 1);
			hasThrown = true;
//		}
		return dice;
	}
	
	public int[] getPlayOptions() {
		if(finished || !gameStarted) return new int[0];
		ArrayList<Pawn> playOptions =getCurrentPlayer().getPlayOptions(dice);
		int[] options = new int[playOptions.size()];
		for(int i = 0; i < playOptions.size(); ++i) {
			options[i] = pawns.indexOf(playOptions.get(i));
		}
		return options;
	}

	public void doOption(int  indexPawn) {
		if(!gameStarted || finished) return;
		if(!hasThrown) return;
		Pawn pawn = pawns.get(indexPawn);
		if(getCurrentPlayer().getPlayOptions(dice).contains(pawn)) {
			getCurrentPlayer().movePawn(pawn,dice);
			nextTurn();
		}
	}

	private void nextTurn() {
		finished = getCurrentPlayer().isWinner();
		if(finished) return;
		hasThrown = false;
		if(dice != 6) {
			nextPlayer();
		}
	}
	
	public ArrayList<Pawn> getPawns() {
		return pawns;
	}
	
	public boolean isFinished() {
		return finished;
	}
 }
