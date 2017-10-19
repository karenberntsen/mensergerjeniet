package nl.MensErgerJeNiet.mensergerjeniet.db.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRoleClassTests {
	private User user;
	private Long id = 0L;
	private String username = "Yasper";
	private String password = "password";
	private String email = "yasper_katgert@hotmail.com";
	private Enabled enabled = Enabled.ENABLED;
	
	
	private UserRole role;
	private Long userroleid = 0L;
	private String roleName = "ROLE_USER";
	@Before
	public void b4() {
		user = new User();
		user.setUserId(id);
		user.setUserName(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setEnabled(enabled);
		
		
		role = new UserRole();
		role.setUser(user);
		role.setUserroleid(userroleid);
		role.setRole(roleName);
	}
	@Test
	public void userSetGetUserTest() {
		assertEquals(role.getUser(), user);
	}
	@Test
	public void userSetGetUserRoleIdTest() {
		assertEquals(role.getUserroleid(), role.getUserroleid());
	}
	@Test
	public void userSetGetRoleTest() {
		assertEquals(role.getRole(), roleName);
	}
	
	@After
	public void after() {
		user = null;
		role = null;
	}

}
