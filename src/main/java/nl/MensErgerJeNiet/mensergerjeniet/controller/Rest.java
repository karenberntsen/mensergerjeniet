package nl.MensErgerJeNiet.mensergerjeniet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.User;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.UserRole;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.UserRepository;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.UserRolesRepository;

@RestController
public class Rest {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserRolesRepository userRolesRepository;
	@Autowired
	PasswordEncoder encoder;
	@GetMapping("/testt")
	public String mapp() {
		return "tasdasdasest";
	}
	
	@DeleteMapping("/del/{id}")
	public void del(@PathVariable int id) {
		System.out.println(id);
	}
//	@PostMapping("/registerUser")
//	public String register(@RequestBody User user) {
//		System.out.println("new user?");
//		user.setEmail(user.getEmail().toLowerCase());
//		if (!user.getEmail().matches(
//				"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
//			return( "Email bevat vage tekens!");
//		}
//		if (user.getPassword().length() < 8) {
//			return ("Wachtwoord moet minimaal 8 characters lang zijn");
//
//		}
//		user.setEnabled(1);
//		user.setPassword(encoder.encode(user.getPassword()));
//		try {
//		user = userRepository.save(user);
//		} catch(Exception cve) {
//			return ("Gebruikersnaam bestaat al");
//		}
//		UserRole userRole = new UserRole();
//		userRole.setUser(user);
//		userRole.setRole("ROLE_USER");
//		userRolesRepository.save(userRole);
//		return "GRATS";
//	}
}
