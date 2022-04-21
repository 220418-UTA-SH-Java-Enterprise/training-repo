package com.revature.arraylist;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		ArrayList<String> food = new ArrayList();
		
		//add to your arraylist
		//add inserts a single item of the same type as the list
		food.add("apple");
		food.add("banana");
		food.add("kiwi");
		food.add("watermelon");
		food.add("soap");
		food.add("tomato");
		food.add("potato");
		food.add("orange");
		food.add("rock");
		food.add("ice cream");
		
		ArrayList<String> groceryList = new ArrayList();
		//addAll requires a collection of the same type to insert elements into its list
		groceryList.addAll(food);
		groceryList.add("water");
		
		System.out.println((groceryList.get(4)));
		
		System.out.println("Before removal:");
		for(String item : groceryList) {
			System.out.println(item);
			
		}
		System.out.println(groceryList.size());
		groceryList.ensureCapacity(30); //not guarantee to increase our capacity because JVM automatically sets a default of 10 and double capacity as element count goes past 10
		System.out.println(groceryList.size());
		
		//groceryList.remove(4);
		groceryList.clear();
		
		System.out.println("\nAfter removal:");
		for(String item : groceryList) {
			System.out.println(item);
		}
	}

}
