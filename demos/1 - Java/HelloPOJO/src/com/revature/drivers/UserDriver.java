package com.revature.drivers;

import java.util.Scanner;

import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

public class UserDriver {

	//this instance will be used to make service calls to our lower layers of our app
	//aka handling our business logic of our app
	public static UserService userService = new UserServiceImpl();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome User! Please register for our app!!");
		
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
		
		char answer = in.next().charAt(0);
		
		if(answer == 'y') {
			userService.addUser(new User(id, username, password, firstName, lastName, email));
		}
	}

}
