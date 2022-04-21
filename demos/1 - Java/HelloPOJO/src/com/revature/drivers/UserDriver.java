package com.revature.drivers;

import java.util.Scanner;

import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

/* What is POJO Design Pattern?
 * - POJO = using either abstract classes or interfaces to modularize our applications to better manage our business logic
 * 
 */
public class UserDriver {

	//this instance will be used to make service calls to our lower layers of our app
	//aka handling our business logic of our app
	public static UserService userService = new UserServiceImpl();
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Welcome User! Please register for our app!!");
		
		User target = registerUser();
		
		char answer = in.next().toLowerCase().charAt(0);
		
		do {
			if(answer == 'y') {
				userService.addUser(target);
			}else {
				target = registerUser(); //recursion
				answer = in.next().charAt(0);
			}
		} while(answer != 'y');
		
		
		in.close();
		
		System.out.println("--------");
		
		System.out.println(userService.getUserById(2));
	}
	
	public static User registerUser() {
		System.out.print("Please provide a id number: ");
		int id = in.nextInt();
		
		System.out.print("Please provide a username: ");
		String username = in.next();
		
		System.out.print("Please provide a first name: ");
		String firstName = in.next();
		
		System.out.print("Please provide a last name: ");
		String lastName = in.next();
		
		System.out.print("Please provide an email address: ");
		String email = in.next();
		
		System.out.print("Please provide a password: ");
		String password = in.next();
		
		System.out.print(String.format("\nID: %d\nUsername: %s\nFirst Name: %s\nLast Name: %s\nEmail: %s\nPassword: %s\nIs this information correct: ",
				id,
				username,
				firstName,
				lastName,
				email,
				password));
		
		return new User(id, username, password, firstName, lastName, email);
	}

}
