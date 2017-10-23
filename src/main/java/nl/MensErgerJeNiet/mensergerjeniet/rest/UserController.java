package nl.MensErgerJeNiet.mensergerjeniet.rest;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.Enabled;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.User;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.UserRole;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.services.UserRoleService;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.services.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	UserRoleService userRolesService;
	@Autowired
	PasswordEncoder encoder;
	
	@GetMapping("/logout")
	public String logout() {
		return "ok";
	}
	
	@PostMapping("/registeruser")
	public String register(@RequestBody User user) throws NoSuchAlgorithmException {
		System.out.println(user);
		user.setEmail(user.getEmail().toLowerCase());
		String returnMessage = addUser(user);
		if(returnMessage != null) {
			return returnMessage;
		} else {
			addUserRoleToUser(user);
		}
		return "ok";
	}

	private String addUser(User user) {
		if (!user.getEmail().matches(
				"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
			return "Email bevat vage tekens!(geen email)";
		}
		if (user.getPassword().length() < 8) {
			return "Wachtwoord moet minimaal 8 characters lang zijn";
		}
		user.setEnabled(Enabled.ENABLED);//TODO enabled -> disabled en na een mail + code invoeren enabled zetten
		user.setPassword(encoder.encode(user.getPassword()));
		try {
			user = userService.save(user);
		} catch (Exception cve) {
			return "Gebruikersnaam bestaat al";
		}
		return null;
	}

	private void addUserRoleToUser(User user) {
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole("ROLE_USER");
		userRolesService.save(userRole);
	}
}