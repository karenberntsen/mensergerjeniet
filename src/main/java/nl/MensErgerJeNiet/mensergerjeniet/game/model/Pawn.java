package nl.MensErgerJeNiet.mensergerjeniet.game.model;

import lombok.Data;

/**
 * Deze klasse representeert een pion. De locatie geeft aan of de pion zich in
 * het huis, in het hok of op het bord bevindt. Het pionnummer (pawnNumber) is
 * een nummer tussen de 1 en 4. Hiermee kan onderscheid gemaakt worden tussen de
 * verschillende pionnen van een speler (player).
 */
@Data
public class Pawn {

	private Location location;
	private Player player;
	private int pawnNumber;

	@Override
	public String toString() {
		return ("Pion " + pawnNumber);
	}

	public Pawn(Player player, int number) {
		this.player = player;
		this.location = Location.HOME;
		this.pawnNumber = number;
	}

	public int getIndex() {
		switch (location) {
		case HOME:
			return indexOfHome();
		case FINISH:
			return indexOfFinish();

		case BOARD:
			return indexOfBoard();
		}
		return -1;
	}

	public int indexOfHome() {
		return player.indexOfHome(this);
	}

	public int indexOfFinish() {
		return player.indexOfFinish(this);
	}

	public int indexOfBoard() {
		return player.getBoard().getLocation(this);
	}
}
