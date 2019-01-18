import static org.junit.Assert.*;

import org.junit.Test;

public class RegisterTest {
	Register register = new Register();

	@Test
	public void testEmptyUserName() {
		assertEquals(register.logIn("", "12345"), false);
	}
	
	@Test
	public void testEmptyPassword() {
		assertEquals(register.logIn("ddunig2", ""), false);
	}
	
	@Test
	public void testEmptyUserNameAndPassword() {
		assertEquals(register.logIn("", ""), false);
	}
	
	@Test
	public void testInvalidLogIn() {
		assertEquals(register.logIn("ddunig2", "Password"), false);
	}

	@Test
	public void testValidLogIn() {
		assertEquals(register.logIn("ddunig2", "665219"), true);
	}
	@Test
	public void testValidLogIn2() {
		assertEquals(register.logIn("admin", "Password"), true);
	}

}
