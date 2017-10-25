package nl.MensErgerJeNiet.mensergerjeniet.db.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.Enabled;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.User;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.GameRepository;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.StatisticsRepository;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.UserEnablerRepository;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.UserRepository;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.UserRolesRepository;

@Service
public class UserDeleteService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	StatisticsRepository statRepository;
	
	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	UserRolesRepository roleRepository;
	
	@Autowired
	UserEnablerRepository enablerRepository;
	
	public void hardDeleteUserWithId(long userId) {
		User user = userRepository.findOne(userId);
		System.out.println(user.getUserName());
		enablerRepository.deleteByUser(user);
		System.out.println("enabler");
		statRepository.deleteByUser(user);
		System.out.println("stats");
		gameRepository.deleteByWinner(user);
		System.out.println("games");
		roleRepository.deleteByUser(user);
		System.out.println("roles");
		userRepository.delete(user);
	}

	public void softDeleteUserWithId(Long id) {
		User user = userRepository.findOne(id);
		user.setEnabled(Enabled.DELETED);
		userRepository.save(user);
	}
}
