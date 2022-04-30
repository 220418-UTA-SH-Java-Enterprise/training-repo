package com.revature.final_package;

/* Final keyword
 * 
 * 		- is a non-access modifer applicable only to a:
 * 			+ variable
 * 			+ method
 * 			+ class
 */
public class FinalVariableClass {

	/*
	 * Naming conventions for final variables are typically in all-caps.
	 * 
	 * - final variables are considered constants in Java
	 * - Rules with final variables:
	 * 		- we must initialize a final variable, otherwise the compiler will throw
	 * 			a compile-time error
	 * 		- a final variable can only be initialized once, either by initializer or assignment
	 */
	final int THRESHOLD = 5;
	final int CAPACITY;
	static final int MINIMUM;
	
	//in order to perform any operations while assigning values to an instance member, we can use initializer blocks
	// to declare/initialize that data
	//this concept can also be known as "class loading"
	{
		CAPACITY = 6;
	}
	
	static{
		MINIMUM = 5;
	}
	
	public static void main(String[] args) {
		// this one was complaining because it was never assigned a value during initialization
		// RULE: once a final variable is initialized, it cannot be assigned another value
		//MINIMUM = 5; --this gave a compile-time error
		//MINIMUM++; -- also compile-time error
		//-------------------------------------------
		
		//created a sb object of StringBuilder class
		//StringBuilder is a mutable String object
		//its size does not matter even when its final Stringbuilder
		final StringBuilder sb = new StringBuilder("Azhya was here");
		
		System.out.println("Before: " + sb);
		
		//I changed the internal state of the object reference 
		//because of stringbuilder's non-transitivity property, this object doesn't follow the typical rules of no-changes
		//with the final keyword is applied to the variable
		sb.append("!");
		
		System.out.println("After: " + sb);
	}

}
