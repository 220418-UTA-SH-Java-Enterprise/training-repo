package com.revature.final_package;

public class FinalMethodClassImpl extends FinalMethodClass{
	//final methods cannot be overridden, otherwise you get a compile error
	void finalMethod() {
		System.out.println("This is the implementation of the final method.");
		
		//you would use final methods if you don't want something to be overridden
		//ex. the Object class -- a number of its methods are final
		Object obj = new Object();
	}
}
