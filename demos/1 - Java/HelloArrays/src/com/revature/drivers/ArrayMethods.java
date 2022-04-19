package com.revature.drivers;

public class ArrayMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = {"Bob", "Sue", "John", "Robert", "Fred"};
		String[] names2 = {"Tom", "Jerry", "Garfield", "Robert", "Odie"};
		//you can add elements this way after instantiation
		//String[] names = new String[5];
		//names = new String[]{"Bob", "Sue", "John", "Robert", "Fred"};
		
		System.out.println(names.length);
		
		//names = new String[10];
		//names[6] = "Tom"; //returns arrayoutofbounds exception
		
		//you cannot change of an array once its declared 
		//you will have to make a new instance of your array with a different size
		//System.out.println(names[0]); //null
		//System.out.println(names.equals(names2)); //.equals method compares objects with each other
		
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i].equals(names2[i]));
		}
	}

}
