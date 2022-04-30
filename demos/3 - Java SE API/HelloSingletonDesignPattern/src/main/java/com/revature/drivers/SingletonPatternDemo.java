package com.revature.drivers;

import com.revature.models.MySingleObject;

public class SingletonPatternDemo {

	public static void main(String[] args) {
		// illegal construct
		// Compile Time Error: The constructor MySingleObject() is not visible
		// MySingleObject object = new MySingleObject();

		// Get the only object available
		MySingleObject object = MySingleObject.getInstance();

		// say the greeting
		object.sayGreetings(); // prints Azhya

		// what if I want to change the name?
		// we would have to add a getter and setter to MySingleObject class
		// object.setName("Bob");
		// object.sayGreetings(); //prints Bob
	}

}
