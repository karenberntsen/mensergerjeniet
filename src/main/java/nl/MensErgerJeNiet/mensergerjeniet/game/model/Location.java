package nl.MensErgerJeNiet.mensergerjeniet.game.model;
/**
 * Deze enum geeft de mogelijke locaties van een pion weer: huis (HOME), bord (BOARD) en hok (FINISH).
 */

public enum Location {
	HOME,BOARD,FINISH;
	@Override
	public String toString() {
		switch (this) {
			case HOME:
				return "huis";
			case BOARD:
				return "bord";
			case FINISH:
				return "hok";
			default:
				return "Onbekende locatie";
		}
	}
}
