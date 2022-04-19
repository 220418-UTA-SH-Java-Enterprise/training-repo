package com.revature;

import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		//1. instantiate a new array of int with a size of 20
		//indexing 0 - 19 
		int[] numbers = new int[20];
		int[] numbers2 = new int[20];
		
		
		Random rand = new Random(50); //0 - 50 inclusive
		
		//example of breadcrumb statement
		System.out.println(numbers[0]); //0
		//default value of an int is 0
		//therefore every element in our array has a value of 0 at start
		
		//2. iterate through our array and assign each element a random number
		//length = 20
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = rand.nextInt(50) + 1;
			numbers2[i] = (int) (Math.random() * 50); //using Math class
		}
		
		//System.out.println(numbers[0]);
		//3. print our array to the console
		for(int element : numbers) {
			System.out.print(element + " ");
		}
		
		System.out.println("\n-----------------");
		
		for(int e : numbers2) {
			System.out.print(e + " ");
		}
	}

}
