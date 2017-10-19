package nl.MensErgerJeNiet.mensergerjeniet.db.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.Enabled;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.User;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	public User save(User user) {
		return userRepository.save(user);
	}
	
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}
	public List<UserInterface> findAll2() {
		return  userRepository.findAll2();
	}

	public void deleteUserWithId(Long id) {
		User user = userRepository.findOne(id);
		user.setEnabled(Enabled.DELETED);
		userRepository.save(user);
	}

	public List<UserInterface> findEnabledUsers() {
		return userRepository.findByEnabledOrderByUserName(Enabled.ENABLED);
	}
	
	public List<UserInterface> findDisabledUsers() {
		return userRepository.findByEnabledOrderByUserName(Enabled.DISABLED);
	}
	
	public List<UserInterface> findDeletedUsers() {
		return userRepository.findByEnabledOrderByUserName(Enabled.DELETED);
	}

	public void enable(Long id) {
		User user = userRepository.findOne(id);
		user.setEnabled(Enabled.ENABLED);
		userRepository.save(user);
	}
}
