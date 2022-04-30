package com.revature.models;

public class MySingleObject {
	//because this instance will be the only object used, this is the only spot where we can change the name
	//(unless we added a getter and setter for the name)
	private String name = "Azhya";
	
	// create an object of MySingleObject
	private static MySingleObject instance = new MySingleObject();

	// make the constructor private so that this class cannot be instantiated
	private MySingleObject(){}

	// Get the only object available
	public static MySingleObject getInstance() {
		return instance;
	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

	public void sayGreetings() {
		System.out.println("Hello! My name is " + instance.name + ".");
	}
}
