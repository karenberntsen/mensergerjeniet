package nl.MensErgerJeNiet.mensergerjeniet.config.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Session;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import nl.MensErgerJeNiet.mensergerjeniet.db.model.Enabled;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.User;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.UserRole;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.UserRepository;
import nl.MensErgerJeNiet.mensergerjeniet.db.model.repositories.UserRolesRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private final UserRepository userRepository;
	private final UserRolesRepository userRolesRepository;

	@Autowired
	public CustomUserDetailsService(UserRepository userRepository, UserRolesRepository userRolesRepository) {
		this.userRepository = userRepository;
		this.userRolesRepository = userRolesRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		User user = userRepository.findByUserNameAndEnabled(username, Enabled.ENABLED);
		System.out.println(user);
		if (null == user) {
			throw new UsernameNotFoundException("No user present with username: " + username);
		} else {
			ServletRequestAttributes s= (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			s.setAttribute("name", user.getUserName(), ServletRequestAttributes.SCOPE_SESSION);
			UserRole role = new UserRole();
			role.setUser(user);
			List<String> userRoles = userRolesRepository.findByUserId(user.getUserId());
			return new CustomUserDetails(user, userRoles);
		}
	}

}
