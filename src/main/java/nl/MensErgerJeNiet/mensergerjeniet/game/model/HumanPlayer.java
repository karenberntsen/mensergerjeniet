package nl.MensErgerJeNiet.mensergerjeniet.game.model;

import java.util.ArrayList;
import java.util.HashMap;

import nl.MensErgerJeNiet.mensergerjeniet.game.controller.InputRegulator;

/**
 * Deze klasse representeert een menselijke speler. De optie 'playFast' zorgt ervoor dat als de speler maar 1 pion kan zetten, dit automatisch gebeurt.
 */

public class HumanPlayer extends Player {

	private boolean playFast=false;

	public HumanPlayer(String name,int start,GameBoard board) {
		super(name,start,board);
		String answer = InputRegulator.askPerson("Wil je de optie 'snel spelen' aanzetten?",new String[] {"Ja","Nee"});
		if ("Ja".equalsIgnoreCase(answer)) {
			this.playFast=true;
		}
	}

	/**
	 * Deze functie vraagt de speler welke pion hij/zij wil zetten. De mogelijke pionnen worden aangegeven met het pionnummer.
 	 */
	public Pawn chooseOption(ArrayList<Pawn> playOptions) {
		HashMap<String,Pawn> options=new HashMap<String,Pawn>();
		for (Pawn pawn:playOptions) {
			options.put(Integer.toString(pawn.getPawnNumber()),pawn);
		}
		if (!playFast || playOptions.size()>1) {
			return options.get(InputRegulator.askPerson("Welke pion wil je zetten?",options.keySet().toArray(new String[playOptions.size()])));
		} else {	
			return playOptions.get(0);
		}
	}

}
