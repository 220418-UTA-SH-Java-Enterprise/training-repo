package com.revature;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.revature.dao.UserDAOImpl;
import com.revature.models.User;
import com.revature.services.UserServiceImpl;

public class UserServiceTest {

	private UserDAOImpl mockdao;
	private UserServiceImpl userv;
	private User u1, u2;
	List<User> dummyDb;

	@Before
	public void setUp() {
		//arrange your tests with needed dependencies
		/**
		  * We are declaring the dependency of the object within the class
		  * via the constructor injection we defined in the UserServiceImpl.java class
		  */
		
		/*Mockito setup*/
		//1. mock the depending classes
		mockdao = Mockito.mock(UserDAOImpl.class);
		
		//2. inject your service with mocked classes
		userv = new UserServiceImpl(mockdao);
		
		/*Dummy DB setup*/
		//we need to create a "fake database" of user objects
		u1 = new User(1, "realuser", "passw0rd", "Real", "User");
		u2 = new User(2, "anotheruser", "password", "Another", "Tester");
		
		dummyDb = new ArrayList<User>();
		dummyDb.add(u1);
		dummyDb.add(u2);
	}

	/*For this example, these set of tests will be for the login functionality in this app*/
	//happy path scenerio
	@Test
	public void testLogin_success() throws Exception{
		//arrange conditions with Mockito on how mocks are supposed to act in certain cases
		/**
		 * WHAT are we expecting when WHAT happens?
		 * 
		 * WHEN the service layer ACTUALLY calls login() with username "anotheruser" and password "password"
		 * and THEN calls the DAO layer to return data, the mocked dao will intercept
		 * the call with our hard-coded dummyDb ArrayList,
		 * THEN we are EXPECTING to return anotheruser (based on the logic of our Service method).
		 */
		when(mockdao.selectAll()).thenReturn(dummyDb);
		
		//3. call targeted test method and perform assertions 
		// expected, actual
		assertEquals(u2, userv.login("anotheruser", "password"));
	}
	
	//not so happy path scenerio
	@Test
	public void testLoginFail_returnNull() throws Exception{
		
		when(mockdao.selectAll()).thenReturn(dummyDb);
		
		// expected, actual
		assertNull(userv.login("Hawkeye", "swords")); // this is the wrong password!
		
	}
	
	@Test
	public void testLoginEmpty_returnNull() throws Exception{
		
		when(mockdao.selectAll()).thenReturn(dummyDb);
		
		// expected, actual
		assertNull(userv.login("", "")); // no credentials entered!
	}
	
	
	//TODO: Will be doing more test cases during lecture on Monday!
	//register unit tests
	@Test
	public void testRegister_returnsUser() {
		//arrange step
		User u3 = new User(3, "test", "test", "Tester", "Test");
		
		//here we will tell mockito what type of behavior to expect from calling certain methods from our dao
		when(mockdao.insert(u3)).thenReturn(1);
		
		//act + assert step
		assertEquals(1, userv.register(u3));
	}
	
	@Test
	public void testRegisterNullUser_returnsNullUser() {
		//arrange step
		User u3 = new User(3, "", "", "", "");
		
		//here we will tell mockito what type of behavior to expect from calling certain methods from our dao
		when(mockdao.insert(u3)).thenReturn(1);
		
		//act + assert step
		assertEquals(1, userv.register(u3));
	}

}
