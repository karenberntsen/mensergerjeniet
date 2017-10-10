package nl.MensErgerJeNiet.mensergerjeniet.game.controller;

import nl.MensErgerJeNiet.mensergerjeniet.game.model.MensErgerJeNiet;
import nl.MensErgerJeNiet.mensergerjeniet.game.model.Player;

/**
 * Deze klasse is de main klasse en start het Mens Erger Je Niet spel. Zolang we geen winnaar hebben, wordt er doorgespeeld. Deze klasse initieert ook de update van de animatie als de situatie in het spel verandert.
 */

public class StartMensErgerJeNiet {
	
	public static void main (String[] args) {
		System.out.println("Welkom bij Mens Erger Je Niet");
		int numberOfComputers=askForPlayers(0,4, "computerspelers");
		int numberOfPeople=0;
		if (numberOfComputers!=4) {
			numberOfPeople=askForPlayers(Math.max(0,2-numberOfComputers),4-numberOfComputers, "mensspelers");
		}
		MensErgerJeNiet mensErgerJeNiet = new MensErgerJeNiet(numberOfComputers,numberOfPeople);
		//BoardAnimation boardAnimation;
       	//	if (args.length==1) {
        //		int frameSize = (int) Integer.parseInt(args[0]);
		//	boardAnimation = new BoardAnimation(mensErgerJeNiet.getPawns(),frameSize);
	    //    } else {
		//	boardAnimation = new BoardAnimation(mensErgerJeNiet.getPawns());
		//}
		boolean weHaveAWinner = false;
		System.out.println("Mens Erger Je Niet is begonnen!");
		Player currentPlayer;
		boolean updateBoard;
		int dice;
		while (!weHaveAWinner) {
			currentPlayer=mensErgerJeNiet.getCurrentPlayer();
			dice = mensErgerJeNiet.dice();
			//boardAnimation.updateWindow(dice);
			System.out.println(currentPlayer.toString() + " gooit "+dice);
			mensErgerJeNiet.sleep(1000);
			updateBoard=currentPlayer.doTurn(dice);
			if (currentPlayer.isWinner()) {
				weHaveAWinner=true;
				System.out.println(currentPlayer.toString() + " heeft gewonnen!");
			}
			if (dice!=6) {
				mensErgerJeNiet.nextPlayer();	
			}
			if (updateBoard) {
				System.out.println(mensErgerJeNiet.getBoardString());
				//boardAnimation.updateWindow(dice);
			}
			mensErgerJeNiet.sleep(1000);
		}
	}

	/**
	 * Deze functie vraagt hoeveel spelers er mee gaan doen. Type geeft aan of het gaat om menselijke spelers of computerspelers. Min en max geven het minimale en het maximale aantal dat nog mogelijk is weer.
 	 */
	private static int askForPlayers(int min, int max, String type) {
		int numberOfOptions=1+max-min;
		String[] options= new String[numberOfOptions];
		for (int i=0;i<numberOfOptions;i++) {
			options[i]=Integer.toString(min+i);
		}
		return (int) Integer.parseInt(InputRegulator.askPerson("Hoeveel "+type+" wil je toevoegen?",options));		
	}
}
