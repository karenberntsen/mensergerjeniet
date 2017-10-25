package nl.MensErgerJeNiet.mensergerjeniet.rest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.Enabled;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.User;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.UserEnabler;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.UserRole;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.services.UserEnablerService;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.services.UserRoleService;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.services.UserService;
import nl.MensErgerJeNiet.mensergerjeniet.mail.EmailServiceImpl;

@RestController
public class UserRest {
	@Autowired
	UserService userService;
	
	@Autowired
	UserEnablerService userEnablerService;
	
	
	@Autowired
	UserRoleService userRolesService;
	@Autowired
	PasswordEncoder encoder;
	

	@Autowired
	EmailServiceImpl emailService;
	
	@GetMapping("/logout")
	public String logout() {
		return "ok";
	}
	
	@GetMapping("/user/{username}/{secret}")
	public void activateAccount(@PathVariable String username, @PathVariable String secret, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String redirectUrl = request.getContextPath()+"/login?";
		if(userEnablerService.enable(username, secret)){
			redirectUrl += "activated";
		} else {
			redirectUrl+= "activationfail";
		}
		response.sendRedirect(redirectUrl);
	}
	
	@PostMapping("/registeruser")
	public String register(@RequestBody User user, HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		System.out.println(user);
		String url = request.getScheme();
		url += "://" + request.getServerName();
		url += ":"+ request.getServerPort();
		url += request.getContextPath();
		user.setEmail(user.getEmail().toLowerCase());
		String returnMessage = addUser(user, url);
		if(returnMessage != null) {
			return returnMessage;
		} else {
			addUserRoleToUser(user);
		}
		return "ok";
	}

	private String addUser(User user, String url) throws UnsupportedEncodingException {
		if (!user.getEmail().matches(
				"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
			return "Email bevat vage tekens!(geen email)";
		}
		if (user.getPassword().length() < 8) {
			return "Wachtwoord moet minimaal 8 characters lang zijn";
		}
		user.setEnabled(Enabled.DISABLED);
		user.setPassword(encoder.encode(user.getPassword()));
		try {
			user = userService.save(user);
		} catch (Exception cve) {
			return "Gebruikersnaam bestaat al";
		}
		UserEnabler userEnabler = new UserEnabler();
		userEnabler.setUser(user);
		Random random = new Random();
		int secret  = random.ints(1).findFirst().getAsInt();
		userEnabler.setSecret(""+secret);
		userEnablerService.save(userEnabler);
		emailService.sendSimpleMessage(user.getEmail(), user.getUserName(), userEnabler.getSecret(), url);
		return null;
	}

	private void addUserRoleToUser(User user) {
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole("ROLE_USER");
		userRolesService.save(userRole);
	}
}