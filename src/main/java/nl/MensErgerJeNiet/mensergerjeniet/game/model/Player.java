package nl.MensErgerJeNiet.mensergerjeniet.game.model;

import java.util.ArrayList;

/**
 * Deze klasse representeert een speler. De speler bevat een lijst met zijn pionnen (pawns), de index van het startvakje (start), zijn naam, een lijst die zijn huis representeert (home), een lijst die zijn hok representeert (finish) en het bord waarop zijn pionnen zich gaan verplaatsen. 
 */

public abstract class Player {

	private ArrayList<Pawn> pawns = new ArrayList<Pawn>();
	private int start;
	private String name;
	private ArrayList<Pawn> home = new ArrayList<Pawn>();
	private ArrayList<Pawn> finish = new ArrayList<Pawn>();
	private static GameBoard board;

	/**
	 * Constructor. Hij maakt voor deze speler vier pionnen aan en zet ze in zijn huis.
 	 */
	public Player(String name,int start,GameBoard board) {
		this.name=name;
		this.start=start;
		this.board=board;
		for (int i=0;i<4;i++) {
			finish.add(null);
			pawns.add(new Pawn(this,i+1));
		}
		home.addAll(pawns);
		System.out.println(name + " is aangemaakt");
	}

	/**
	 * Deze functie kiest uit de gegeven opties een pion om te verplaatsen.
 	 */
	public abstract Pawn chooseOption(ArrayList<Pawn> playOptions);

	public int indexOfHome(Pawn pawn) {
		return home.indexOf(pawn);
	}

	public int indexOfFinish(Pawn pawn) {
		return finish.indexOf(pawn);
	}

	/**
	 * Deze functie zet een pion in het huis van de speler
 	 */
	public void toHome(Pawn pawn) {
		if (pawn.getPlayer()==this) {
			home.add(pawn);
			pawn.setLocation(Location.HOME);
		} else {
			System.out.println("Deze pion is niet van deze speler");
		}
	}

	/**
	 * Als alle pionnen in het hok staan, is deze speler de winnaar.
 	 */
	public boolean isWinner() {
		for (Pawn pawn:pawns) {
			if (pawn.getLocation()!=Location.FINISH) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return name;
	}

	/**
	 * Deze functie kijkt of een van zijn pionnen kan staan op het meegegeven vakje. Als er al een pion van deze speler staat kan dat niet.
 	 */
	private boolean fitsOnField(int newField) {
		Pawn pawn = board.getPawn(newField);
		return (pawn==null || pawn.getPlayer()!=this);
	}

	/**
	 * Deze functie kijkt of een van zijn pionnen kan staan op het meegegeven vakje. Als er al een pion van deze speler staat kan dat niet. In dat geval wordt er gekeken of de pion die in de weg staat gezet kan worden.
 	 */
	private Pawn fitsOnField(Pawn pawn, int newField, int dice) {
		if (fitsOnField(newField)) {
			return pawn;
		} else {
			return fitsOnField(board.getPawn(newField),newField+dice,dice);
		}
	}


	/**
	 * Deze functie kijkt of er plek is op het gegeven hokvakje.
 	 */
	private boolean spaceInFinish(int newFinishField) {
		return (newFinishField <4 && finish.get(newFinishField)==null);
	}

	/**
	 * Deze functie representeert de beurt van de speler na het gooien van de dobbelsteen. De opties worden verzameld en vervolgens wordt daaruit gekozen. Als de speler iets verplaatst heeft wordt er een 'TRUE' teruggegeven, en als de speler niets verplaatst heeft een 'FALSE'.
 	 */
	public boolean doTurn(int dice) {
		ArrayList<Pawn> playOptions=getPlayOptions(dice);
		if (playOptions.size()==0) {
			return false;
		} else {
			Pawn pawn = chooseOption(playOptions);
			movePawn(pawn,dice);
			return true;
		}

	}

	/**
	 * Deze functie zet een pion van deze speler in het hok van deze speler.
 	 */
	private void putInFinish(int newFinishField,Pawn pawn) {
		board.takePawn(pawn);
		finish.set(newFinishField,pawn);
		pawn.setLocation(Location.FINISH);
	}

	/**
	 * Deze functie verplaatst een pion het aantal vakjes van de dobbelsteen (dice) en print wat hij doet. Aangezien de 'doTurn' alleen pionnen meegeeft die gezet kunnen worden, hoeft dat hier niet opnieuw gecheckt te worden.
 	 */
	private void movePawn(Pawn pawn, int dice)  {
		switch (pawn.getLocation()) {
			case HOME:
				System.out.println(this.toString() + " zet een nieuwe pion op het bord");
				board.movePawn(pawn,start); //zet een pion op het startvakje
				home.remove(pawn);
				break;
			case FINISH:
				System.out.println(this.toString() + " verplaatst een pion binnen het hok");
				int oldFinishField=finish.indexOf(pawn);
				finish.set(oldFinishField,null);
				finish.set(oldFinishField+dice,pawn);
				printFinish(); //print status van het hok
				break;
			case BOARD:
				int oldField=board.getLocation(pawn);
				int newField=oldField+dice;
				if (newField>=start && oldField<start) { //kijkt of pion zijn startvakje passeert. Indien ja, dan wordt de pion in het hok gezet
					int newFinishField=newField-start;
					System.out.println(this.toString() + " zet een pion in het hok");
					putInFinish(newFinishField,pawn);

				} else {
					System.out.println(this.toString() + " verplaatst een pion op het bord");
					board.movePawn(pawn,newField);
				}
				break;
		}
	}

	/**
	 * Deze functie print de status van het hok van deze speler.
 	 */
	private void printFinish() {
		for (Pawn p : finish) {
			if (p==null) {
				System.out.println("hok: "+finish.indexOf(p) + " leeg");
			} else {
				System.out.println("hok: "+finish.indexOf(p) + " " + p.toString());
			}
		}
	}

	/**
	 * Deze functie kijkt welke pionnen gezet kunnen worden n.a.v. het getal van de dobbelsteen (dice). Als er een pion op het startvakje staat en er staat ook minimaal 1 pion in het huis, dan moet, indien mogelijk, deze gezet worden. Als er zes wordt gegooid, moet er indien mogelijk, een nieuwe pion worden geplaatst. Er wordt dan maar 1 optie teruggegeven. In de andere gevallen wordt er voor iedere pion gekeken of deze gezet kan worden. Deze functie geeft een lijst met verplaatsbare pionnen terug.
 	 */
	private ArrayList<Pawn> getPlayOptions (int dice) {
		ArrayList<Pawn> playOptions=new ArrayList<Pawn>();
		if (home.size()>0 && board.hasPawn(start) && board.getPawn(start).getPlayer()==this) { //staat er een pion op het startvakje?
			playOptions.add(fitsOnField(board.getPawn(start),start+dice,dice));
		} else if (dice==6 && home.size()>0) { //wordt er zes gegooid en zijn er nog pionnen in het huis?
			playOptions.add(home.get(0));
		} else {
			Pawn otherPawn;
			for (Pawn pawn:pawns) {
				if (pawn==null) {
					System.out.println("pion is null");
				}
				if (pawn.getLocation()==null) {
					System.out.println("locatie van pion "+pawn.toString()+" is null");
				}
				switch (pawn.getLocation()) {
					case HOME:
						break; //er is geen zes gegooid, dus deze pion kan niet gezet worden.
					case FINISH:
						if (spaceInFinish(finish.indexOf(pawn)+dice)) { //check of pion in het hok nog kan verplaatsen
							playOptions.add(pawn);
						}
						break;
					case BOARD:
						int oldField=board.getLocation(pawn);
						int newField=oldField+dice;
						if (newField>=start && oldField<start) { //check of pion zijn/haar startvakje passeert. Indien ja, check of de pion in het hok past.
							int newFinishField=newField-start;
							if (newFinishField<4) {
								if (finish.get(newFinishField)==null) {
									playOptions.add(pawn);
								} else {
									printFinish();
								}
							}
						} else if (fitsOnField(newField)) { //check of pion op het nieuwe bordvakje past.
							playOptions.add(pawn);
						}
						break;
				}
			}
		}
		return playOptions;
	}

	public GameBoard getGameBoard() {
		return board;
	}

	public ArrayList<Pawn> getPawns() {
		return pawns;
	}

	public int getStart() {
		return start;
	}

}
