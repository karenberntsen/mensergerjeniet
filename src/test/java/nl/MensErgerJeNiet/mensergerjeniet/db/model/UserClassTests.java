package nl.MensErgerJeNiet.mensergerjeniet.db.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserClassTests {
	private User user;
	private Long id = 0L;
	private String username = "Yasper";
	private String password = "password";
	private String email = "yasper_katgert@hotmail.com";
	private int enabled = 1;
	@Before
	public void b4() {
		user = new User();
		user.setUserId(id);
		user.setUserName(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setEnabled(enabled);
		
	}
	@Test
	public void userSetGetUserIdTest() {
		assertEquals(user.getUserId(), id);
	}
	@Test
	public void userSetGetUserNameTest() {
		assertEquals(user.getUserName(), username);
	}
	@Test
	public void userSetGetPasswordTest() {
		assertEquals(user.getPassword(), password);
	}
	@Test
	public void userSetGetEmailTest() {
		assertEquals(user.getEmail(), email);
	}
	
	@Test
	public void userSetGetEnabledTest() {
		assertEquals(user.getEnabled(), enabled);
	}
	
	
	
	@After
	public void after() {
		user = null;
	}

}
