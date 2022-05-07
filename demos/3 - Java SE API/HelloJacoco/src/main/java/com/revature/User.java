package com.revature;

public class User {
	
	public String addUser(String username) {
		if(username == null || username.trim().length() == 0) {
			return "Please provide a username";
		}else if(username.equalsIgnoreCase("Admin")) {
			return "Sorry boss. This portal is for regular users only";
		}else {
			return "User " + username + " is added successfully";
		}
	}

}
