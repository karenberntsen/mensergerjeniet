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
	private int playerIndex = 0;
	private static GameBoard board = new GameBoard();
	private int dice;
	private boolean hasThrown;
	private boolean gameStarted;
	private boolean isFinished;

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

	/**
	 * Deze functie pauzeert het spel, opdat de menselijke spelers en toeschouwers
	 * het spel kunnen volgen.
	 */
	public void sleep(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public Player getCurrentPlayer() {
		return players.get(playerIndex);
	}

	public ArrayList<Pawn> getPawns() {
		ArrayList<Pawn> pawns = new ArrayList<Pawn>();
		for (Player player : players) {
			pawns.addAll(player.getPawns());
		}
		return (pawns);
	}

	public String getBoardString() {
		return (board.toString());
	}

	public int throwDice() {
		if (!hasThrown) {
			dice = (int) (Math.random() * 6 + 1);
			hasThrown = true;
		}
		return dice;
	}
	
	public int[] getPlayOptions() {
		ArrayList<Pawn> playOptions =getCurrentPlayer().getPlayOptions(dice);
		int[] options = new int[playOptions.size()];
		for(int i = 0; i < playOptions.size(); ++i) {
			options[i] = playOptions.get(i).getPawnNumber();
		}
		return options;
			
	}

	public void doOption(int  pawnNumber) {
		if(!hasThrown) return;
		Pawn pawn = getCurrentPlayer().getOptionPawn(pawnNumber,dice);
		if (pawn!=null) {
			getCurrentPlayer().movePawn(pawn,dice);
			nextTurn();
		}
	}

	private void nextTurn() {
		isFinished = getCurrentPlayer().isWinner();
		hasThrown = false;
		if(dice != 6) {
			nextPlayer();
		}
	}
 }
