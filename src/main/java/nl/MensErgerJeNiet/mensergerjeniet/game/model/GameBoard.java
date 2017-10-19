package nl.MensErgerJeNiet.mensergerjeniet.game.model;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Deze klasse representeert het circulaire deel van het spelbord (alle witte vakjes en de startvakjes). Omdat de meeste vakjes vaak leeg zijn, worden ze gerepresenteert door twee HashMaps die bijhouden welke pion op welk vakje staat. De vakjes (fields) worden gerepresenteerd met een nummer tussen de 0 en 40, aangezien dit een bord is voor vier spelers. Lege vakjes worden dus niet opgeslagen. Het blauwe startvakje heeft index 0 en die index loopt op met de klok mee.
 */
public class GameBoard {
	private TreeMap<Integer,Pawn> gameBoard= new TreeMap<Integer,Pawn>();
	private HashMap<Pawn,Integer> pawnLocations=new HashMap<Pawn,Integer>();
	private static final int boardLength = 40;

	/**
	 * Deze functie print de status van het 'bord'. Per regel representeert het eerste nummer het nummer van het vakje waarop een pion staat, gevolgd door het spelernummer en het pionnummer. Deze regels worden geprint op volgorde van de vakjes. Pionnen die in het hok of huis staan worden niet door deze functie geprint.
 	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Pawn pawn;
		for (int field:gameBoard.keySet()) {
			pawn=getPawn(field);
			sb.append(field+": "+pawn.getPlayer().toString()+ " " + pawn.toString()+"\n");
		}
		return sb.toString();
	}

	/**
	 * Deze functie pakt een pion van het (ciruclaire deel van het) bord af.
 	 */
	public Pawn takePawn(int field) {
		field%=boardLength;
		if (hasPawn(field)) {
			Pawn pawn = getPawn(field);
			gameBoard.remove(field);
			pawnLocations.remove(pawn);
			pawn.setLocation(null);
			return pawn;
		} else {
			System.out.println("Dit vakje bevat geen pion");
			return null;
		}
	}

	/**
	 * Deze functie pakt een pion van het (ciruclaire deel van het) bord af.
 	 */
	public void takePawn(Pawn pawn) {
		if (pawnLocations.containsKey(pawn)) {
			pawn.setLocation(null);
			gameBoard.remove(pawnLocations.remove(pawn));
		} else {
			System.out.println("Deze pion staat niet op het bord");
		}
	}

	/**
	 * Deze functie zet een pion op het bord.
 	 */
	private void putPawn(Pawn pawn, int newField) {
		newField%=boardLength;
		gameBoard.put(newField,pawn);
		pawnLocations.put(pawn,newField);
		pawn.setLocation(Location.BOARD);
	}

	/**
	 * Deze functie verplaatst een pion op het bord.
 	 */
	public void movePawn(Pawn pawn,int newField) {
		if (hasPawn(newField)) {
			Pawn otherPawn = takePawn(newField);
			System.out.println(pawn.getPlayer().toString() + " stuurt " + otherPawn.getPlayer().toString() + " naar huis.");
			otherPawn.getPlayer().toHome(otherPawn);
		}
		if (pawn.getLocation()==Location.BOARD) {
			takePawn(pawn);
		} 
		putPawn(pawn,newField);
	}

	/**
	 * Deze functie checkt of een vakje een pion bevat.
 	 */
	public boolean hasPawn(int field) {
		return gameBoard.containsKey(field%boardLength);
	}

	/**
	 * Deze functie laat zien welke pion er op het gegeven vakje staat.
 	 */
	public Pawn getPawn(int field) {
		return gameBoard.get(field%boardLength);
	}

	/**
	 * Deze functie laat zien op welk vakje de gegeven pion staat.
 	 */
	public int getLocation(Pawn pawn) {
		return pawnLocations.get(pawn);
	}
}
