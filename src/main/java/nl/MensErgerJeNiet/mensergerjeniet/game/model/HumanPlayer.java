package nl.MensErgerJeNiet.mensergerjeniet.game.model;

/**
 * Deze klasse representeert een menselijke speler. De optie 'playFast' zorgt ervoor dat als de speler maar 1 pion kan zetten, dit automatisch gebeurt.
 */

public class HumanPlayer extends Player {

	public HumanPlayer(String name,int start,GameBoard board) {
		super(name,start,board);
	}
}
