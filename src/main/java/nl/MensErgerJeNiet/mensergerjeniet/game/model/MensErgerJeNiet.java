package nl.MensErgerJeNiet.mensergerjeniet.game.model;

import java.util.ArrayList;

/**
 * Deze klasse representeert het Mens Erger Je Niet spel. Het bestaat uit het bord (board), de spelers (players) en een playerIndex, waarmee bijgehouden wordt welke speler aan de beurt is. Er kunnen zowel computerspelers als menselijke spelers meedoen.
 */

public class MensErgerJeNiet {

	private Player[] players;
	private int playerIndex=0;
	private static GameBoard board;

	/**
	 * Constructor. Het aantal computerspelers en het aantal menselijke spelers is nodig als input.
 	 */
	public MensErgerJeNiet(int numberOfComputers, int numberOfPeople) {
		this.board = new GameBoard(numberOfComputers+numberOfPeople);
		makePlayers(numberOfComputers,numberOfPeople);
	}

	/**
	 * Deze functie maakt de spelers aan. Speler 1 is de groene speler rechts onderin.
 	 */
	private void makePlayers(int numberOfComputers,int numberOfPeople) {
		int totalNumber=numberOfComputers+numberOfPeople;
		if (totalNumber>4 || totalNumber<2) {
			throw new IllegalArgumentException("Minimaal 2 en maximaal 4 spelers toegestaan");
		}
		this.players = new Player[totalNumber];
		for (int i = 0; i < numberOfComputers; i++) {
			players[i] = new ComputerPlayer("Speler "+(i+1),10*(i+1),board);
		}
		for (int i = numberOfComputers; i < totalNumber; i++) {
			players[i] = new HumanPlayer("Speler "+(i+1),10*(i+1),board);
		}
	}

	/**
	 * Met deze functie wordt de beurt doorgegeven aan de volgende speler.
 	 */
	public void nextPlayer() {
		playerIndex= ++playerIndex % players.length;
	}

	/**
	 * Deze functie representeert het gooien met de dobbelsteen en geeft een random waarde tussen 1 en 6.
 	 */
	public int dice() {
		return (int) (Math.random()*6+1);
	}

	/**
	 * Deze functie pauzeert het spel, opdat de menselijke spelers en toeschouwers het spel kunnen volgen.
 	 */
	public void sleep(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}

	public Player getCurrentPlayer() {
		return players[playerIndex];
	}

	public ArrayList<Pawn> getPawns() {
		ArrayList<Pawn> pawns=new ArrayList<Pawn>();
		for (Player player:players) {
			pawns.addAll(player.getPawns());
		}
		return(pawns);
	}

	public String getBoardString() {
		return(board.toString());
	}

}
