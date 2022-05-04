package com.revature.functional_interfaces;

import java.util.function.Function;

public class FunctionalInterfaceDemo{
	
	@FunctionalInterface
	interface Playable {
		public void doSomePlay(String word);
	}

	public static void main(String[] args) {
		// using a functional interface to solve a math problem
		Function<Integer, Integer> square = n -> n * n;
		
		//use of the apply method
		System.out.println(square.apply(7)); //should print 49
		
		/* This is the same as doing this:
		 * @FunctionalInterface
			interface square{
				public int apply(int x);
			}
		 * */

		//use of our custom functional interfaces and their methods
		Playable play = (String word) -> System.out.println("Hello " + word);
		
		play.doSomePlay("Chucky");
		
		Workable w = () -> System.out.println("I am working on my project.");
		w.doFirstWork();
	}

}
