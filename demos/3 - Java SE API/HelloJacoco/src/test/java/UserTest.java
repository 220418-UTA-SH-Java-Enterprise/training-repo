import org.junit.Test;
import org.junit.Assert;

import com.revature.User;

public class UserTest {
	
	User user = new User();
	
	//this is a positive test case
	@Test
	public void testUserWithName() {
		Assert.assertEquals("User Bob is added successfully", user.addUser("Bob"));
	}
	
	//here are my negative test cases
	@Test
	public void testUserWithNull() {
		Assert.assertEquals("Please provide a username", user.addUser(null));
	}
	
	@Test
	public void testUserWithEmptyName() {
		Assert.assertEquals("Please provide a username", user.addUser(""));
	}
	
	@Test
	public void testUserWithAdminName() {
		Assert.assertEquals("Sorry boss. This portal is for regular users only", user.addUser("Admin"));
	}
}
