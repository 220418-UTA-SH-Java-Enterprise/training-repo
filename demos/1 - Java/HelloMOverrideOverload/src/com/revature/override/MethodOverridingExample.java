package com.revature.override;

public class MethodOverridingExample {

	public static void main(String[] args) {
		Wolf howler = new Wolf();
		
		Animal cat = new Animal();
		
		howler.speak();
		cat.speak();
		
		//this speak() of animal class is being overridden by base class (aka Wolf) speak()
		//runtime polymorphism
		Animal werewolf = new Wolf();
		werewolf.speak();
	}

}
