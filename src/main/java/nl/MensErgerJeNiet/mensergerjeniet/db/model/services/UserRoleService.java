package nl.MensErgerJeNiet.mensergerjeniet.db.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.UserRole;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.UserRolesRepository;

@Service
public class UserRoleService {

	@Autowired
	UserRolesRepository userRepository;
	
	public UserRole save(UserRole role) {
		return userRepository.save(role);
	}
}
