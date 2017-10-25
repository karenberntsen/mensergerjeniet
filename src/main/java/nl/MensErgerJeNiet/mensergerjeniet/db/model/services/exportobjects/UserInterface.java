package nl.MensErgerJeNiet.mensergerjeniet.db.model.services.exportobjects;

import lombok.Data;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.Enabled;

@Data
public class UserInterface {
	private Long id;
	private String userName;
	private Enabled enabled;
	public UserInterface() {}
	public UserInterface( Long id, String userName, Enabled enabled) {
		this.id = id;
		this.userName = userName;
		this.enabled = enabled;
	}
}
