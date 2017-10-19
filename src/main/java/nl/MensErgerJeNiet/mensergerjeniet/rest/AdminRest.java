package nl.MensErgerJeNiet.mensergerjeniet.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.services.UserInterface;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.services.UserService;

@RestController
@RequestMapping("/admin")
public class AdminRest {
	@Autowired
	UserService userService;
	
	@GetMapping("/userlist")
	public List<UserInterface> getAllUsers2() {
		return userService.findAll2();
	}
	
	@GetMapping("/enabledUsers")
	public List<UserInterface> getEnabledUsers() {
		return userService.findEnabledUsers();
	}
	
	@GetMapping("/disabledUsers")
	public List<UserInterface> getDisabledUsers() {
		return userService.findDisabledUsers();
	}
	
	@GetMapping("/deletedUsers")
	public List<UserInterface> getDeletedUsers() {
		return userService.findDeletedUsers();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		System.out.println(id);
		userService.deleteUserWithId(id);
	}

	@PutMapping("/users/{id}/enable")
	public void enableUser(@PathVariable Long id) {
		System.out.println(id);
		userService.enable(id);
	}
}
