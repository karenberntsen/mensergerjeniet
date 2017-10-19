package nl.MensErgerJeNiet.mensergerjeniet.db.model.services;

import lombok.Data;

@Data
public class StatisticsInterface {
	private Long id;
	private String userName;
	private int win;
	private int loss;
	public StatisticsInterface() {}
	public StatisticsInterface( Long id, String userName, int win, int loss) {
		this.id = id;
		this.userName = userName;
		this.win = win;
		this.loss = loss;
	}
}
