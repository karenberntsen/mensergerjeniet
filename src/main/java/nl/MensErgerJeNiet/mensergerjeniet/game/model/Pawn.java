package nl.MensErgerJeNiet.mensergerjeniet.game.model;

/**
 * Deze klasse representeert een pion. De locatie geeft aan of de pion zich in het huis, in het hok of op het bord bevindt. Het pionnummer (pawnNumber) is een nummer tussen de 1 en 4. Hiermee kan onderscheid gemaakt worden tussen de verschillende pionnen van een speler (player).
 */

public class Pawn {

	private Location location;
	private Player player;
	private int pawnNumber;

	@Override
	public String toString() {
		return ("Pion "+pawnNumber);
	}

	public int getPawnNumber() {
		return(pawnNumber);
	}

	public Pawn(Player player,int number) {
		this.player=player;
		this.location=Location.HOME;
		this.pawnNumber=number;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location=location;
	}

	public Player getPlayer() {
		return this.player;
	}

	public int indexOfHome() {
		return player.indexOfHome(this);
	}

	public int indexOfFinish() {
		return player.indexOfFinish(this);
	}

	public int indexOfBoard() {
		return player.getGameBoard().getLocation(this);
	}
}

