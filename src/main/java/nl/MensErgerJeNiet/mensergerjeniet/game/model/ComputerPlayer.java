package nl.MensErgerJeNiet.mensergerjeniet.game.model;


import java.util.ArrayList;

/**
 * Deze klasse representeert een computerspeler
 */

public class ComputerPlayer extends Player {

	public ComputerPlayer(String name,int start,GameBoard board) {
		super(name,start,board);
	}

	/**
	 * Deze functie kiest een random pion uit alle opties.
 	 */
	public Pawn chooseOption(ArrayList<Pawn> playOptions) {
		return playOptions.get((int) Math.random()*playOptions.size());
	}

}
