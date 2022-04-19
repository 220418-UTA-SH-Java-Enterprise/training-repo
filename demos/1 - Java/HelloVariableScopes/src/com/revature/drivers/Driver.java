package com.revature.drivers;

import com.revature.Saiyan;

public class Driver {
	//variable scope = can java see this variable and use it
	//3 scopes:
	// 1. static/class scope = only visible within the class
	// 2. method scope = visible inside of given method
	// 3. block scope = visible within a block of code (ex. for loop, int i) 
	//int id = 10000; //static scope
	
	
	public static void main(String[] args) {
		//instantiate a new object
//		Saiyan goku = new Saiyan("goku", "spirit bomb", 100000, 500000);
//		
//		System.out.println(goku);
		
		variableScopeExample();
	}
	
	public static void variableScopeExample() {
		//int id = 2000; //method scope
		//shadowing = when there are two variables of same name, the one is closely proximity takes over
		
		// static loves static
		// static keyword is a non-access modifier that signals to java that this variable/method/class/import
		//only applies to its current class
		//non-access modifiers: static, abstract, final, volatile, synchronized, transient
		//in summary, a modifier lets us fine-tune access to our code depending on where you use it
		
		//id is now in block scope
		for(int id = 1502; id < 1503; id++) {
			System.out.println(id);
		}
		
		//System.out.println(id); //if all other scopes are commented out except for block, id no longer exist
	}

}
