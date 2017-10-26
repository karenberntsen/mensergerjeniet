package nl.MensErgerJeNiet.mensergerjeniet.db.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.Enabled;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.User;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.UserEnabler;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.UserEnablerRepository;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.UserRepository;

@Service
public class UserEnablerService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserEnablerRepository userEnablerRepository;
	
	public UserEnabler save(UserEnabler user) {
		return userEnablerRepository.save(user);
	}
	
	public boolean enable(String username, String secret) {
		UserEnabler userEnabler = userEnablerRepository.findBySecret(secret);
		if(userEnabler == null) return false;
		
		User user = userEnabler.getUser();
		if(user.getUserName().equals(username)) {
			user.setEnabled(Enabled.ENABLED);
			userRepository.save(user);
			userEnablerRepository.delete(userEnabler);
			return true;
		}
		return false;
	}

	public void enableByUserId(Long id) {
		User user = userRepository.findOne(id);
		user.setEnabled(Enabled.ENABLED);
		userEnablerRepository.deleteByUser(user);
		userRepository.save(user);
	}
}
