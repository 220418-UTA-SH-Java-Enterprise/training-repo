package com.revature;

public class Driver {

	/**
	 * Topics: Strings - An array is a sequence of elements of a similar datatype -
	 * A string is an array of characters
	 * 
	 * - In Java, strings & arrays are immutable (cannot be changed after creation)
	 * 
	 * 
	 * 
	 * - This is a example of javadoc in use:
	 * 
	 * @author Azhya Knox
	 **/

	/**
	 * Topics: String API - API = application programming interface - In this case
	 * the String API consist of built-in methods that help us develop complex
	 * strings in our program and allows us to do string manipulation.
	 **/
	public static void main(String[] args) {
		// indexing with strings starts at 0

		String greetings1 = "Hello, my name is Azhya. ";
		String greetings2 = "Welcome to Revature. ";

		// concat = joins strings together
		// System.out.println(greetings1.concat(greetings2));

		// algorithm for just getting my name to be printed
		// 1. find out how big my string is
		int size = greetings1.length();
		// format = allows us to make our own custom strings
		// System.out.println(String.format("The size of this string is: %s", size));

		// 2. find out at what point does my name appear in the string
		// indexOf = allows us to get the index number of a specific character
		// note: is case-sensitive and will grab the earliest index if multiple of the
		// same character
		// System.out.println(String.format("My name starts at index: %s.",
		// greetings1.indexOf('A')));
//		char[] arr = greetings1.toCharArray();
//		for(int i = 0; i < size; i++) {
//			System.out.println(i + " " + arr[i]);
//		}

		// 3. divide the string at that intersection point
		// substring = splits our string at a beginning index and ending index
		String name = greetings1.substring(18, 23);

		// 4. print my name
		System.out.println("My name is " + name);

		System.out.println("------------------------------");

		// algorithm for changing "welcome to revature" to "welcome to walmart"
		// 1. break down my string into a array of more strings (words)
		String[] words = greetings2.split(" ");

		String newGreetings2 = "";

		// 2. iterate thru that array and find revature
		for (String word : words) {
			//System.out.println(word);

		}
		// 3. at that point where revature is, replace it with walmart
		words[2] = words[2].replace("Revature", "Walmart");

		//4. put string back together
		for (String w : words) {
			newGreetings2 = newGreetings2.concat(w + " ");
		}

		//5. print
		System.out.println(newGreetings2);
		
		System.out.println("--------------------");
		
		System.out.println(fancyString("Spongebob Squarepants"));
	}
	
	
	/**
	 * StringBuilder vs. StringBuffer vs. String
	 * - Sbuild, Sbuff extend from the Object class (the parent class of all objects in java)
	 * - So in comparsion to each other:
	 * 
	 *	                STRING          STRINGBUFFER       STRINGBUILDER
	 *	----------------------------------------------------------------------
	 * 	Storage      |   String Pool     Heap                Heap
	 * 	Modifiable   |   Immutable   	Mutable           	Mutable
	 *	Thread Safe  |   YES             YES                 NO
	 *	Performance  |   FAST            VERY SLOW           FAST
	 * 
	 * - Sbuild, Sbuff has access to some object class methods like equals(), clone(), and toString() 
	 **/
	
	public static String fancyString(String s) {
		StringBuilder sbuilder = new StringBuilder(s);
		
		return sbuilder.append("-string").toString();
	}
	
}
