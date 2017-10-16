package nl.MensErgerJeNiet.mensergerjeniet.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.User;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.UserRole;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.UserRepository;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.UserRolesRepository;

@Controller
public class UserController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserRolesRepository userRolesRepository;
	@Autowired
	PasswordEncoder encoder;

	public ModelAndView user() {
		return new ModelAndView("user", "command", new User());
	}

	@PostMapping("/addUser")
	public ModelAndView adduser(@ModelAttribute("SSO") User user, ModelMap model) throws NoSuchAlgorithmException {
		user.setEmail(user.getEmail().toLowerCase());
		if (!user.getEmail().matches(
				"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
			return getIndexWithMessage("Email bevat vage tekens!(geen email)", model);
		}
		model.addAttribute("email", user.getEmail());
		if (user.getPassword().length() < 8) {
			return getIndexWithMessage("Wachtwoord moet minimaal 8 characters lang zijn", model);
		}
		user.setEnabled(1);
		user.setPassword(encoder.encode(user.getPassword()));
		try {
			user = userRepository.save(user);
		} catch (Exception cve) {
			return getIndexWithMessage("Gebruikersnaam bestaat al", model);
		}
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole("ROLE_USER");
		userRolesRepository.save(userRole);
		return new ModelAndView("home");
	}

	public ModelAndView getIndexWithMessage(String message, ModelMap model) {
		model.addAttribute("message", message);
		return index();
	}

	@GetMapping("/register")
	public ModelAndView index() {
		return new ModelAndView("user", "command", new User());
	}
	@GetMapping("/result")
	public String result() {
		return "result";
	}

}