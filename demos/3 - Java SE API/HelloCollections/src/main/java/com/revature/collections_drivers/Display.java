package com.revature.collections_drivers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.models.User;

public class Display {

	private static Logger log = Logger.getLogger(Display.class);
	// Define color constants
	public static final String TEXT_RESET = "\u001B[0m";
	public static final String TEXT_BLACK = "\u001B[30m";
	public static final String TEXT_RED = "\u001B[31m";
	public static final String TEXT_GREEN = "\u001B[32m";
	public static final String TEXT_YELLOW = "\u001B[33m";
	public static final String TEXT_BLUE = "\u001B[34m";
	public static final String TEXT_PURPLE = "\u001B[35m";
	public static final String TEXT_CYAN = "\u001B[36m";
	public static final String TEXT_WHITE = "\u001B[37m";
	
	public void menu() {
    	System.out.println("Welcome to my custom exceptions demo!");
    	System.out.println("Please select an option from below:");
    	System.out.println("1 - ArrayList");
    	System.out.println("2 - ArrayDeque");
    	System.out.println("3 - LinkedList");
    	System.out.println("4 - HashSet");
    	System.out.println("5 - HashMap");
    	System.out.println("6 - Exit app");
    	System.out.println("");
    	System.out.println("Your selection: ");
    }
	
    public void menuSelection(int selection) {
    	String readString = "";
    	switch (selection) {
		case 1:
			//arraylist usage example
			log.debug("DEBUG: Option 1 was selected by user.");
			Scanner al_scan = new Scanner(System.in);
			ArrayList<User> list = new ArrayList<>();
			
			list.add(new User(1, "George", "fishing"));
			list.add(new User(2, "Thomas", "cooking"));
			list.add(new User(3, "Harold", "hiking"));
			list.add(new User(4, "Susie", "gardening"));
			list.add(new User(5, "April", "gaming"));
			
			System.out.println("\nBEFORE:");
			for(User user : list) {
				System.out.println(
					String.format("ID: %d, Name: %s, Hobby: %s", user.getId(), user.getName(), user.getHobby())
				);
			}
			System.out.println("\n----------");
			User target = list.get(3);
			
			list.forEach((User user) -> { 
				if(user.equals(target)) {
					System.out.println(String.format("Target user found on index 3 is %s (ID: %d).", user.getName(), user.getId()));
				}
			});
			
			for(int i = 0; i < list.size(); i++) {
				User t = list.get(i);
				
				if(t.getName().equalsIgnoreCase("Susie")) {
					list.remove(list.get(i));
				}
			}
			
			System.out.println("----------");
			System.out.println("\nAFTER: ");
			for(User user : list) {
				System.out.println(
					String.format("ID: %d, Name: %s, Hobby: %s", user.getId(), user.getName(), user.getHobby())
				);
			}
			
			System.out.println(TEXT_GREEN + "Demo complete! Press 'Enter' to go back to the main menu" + TEXT_RESET);
	        
	        readString = al_scan.nextLine();
	        if (readString.isEmpty()) {
                log.debug("Read Enter Key. Returning to menu...");
                menu();
            }
			break;
		case 2:
			//arraydeque usage example
			log.debug("DEBUG: Option 2 was selected by user.");
			Scanner dq_scan = new Scanner(System.in);
			// Creating and initializing deque
			// Declaring object of integer type
			Deque<User> de_que = new ArrayDeque<User>(10);

			// Operations 1
			// add() method

			// Adding custom elements
			// using add() method to insert
			de_que.add(new User(10, "Bob", "sleeping"));
			de_que.add(new User(20, "Bobby", "sleeping"));
			de_que.add(new User(30, "Robert", "sleeping"));
			de_que.add(new User(40, "Robbie", "sleeping"));
			de_que.add(new User(50, "Bobbert", "sleeping"));

			// Returns an iterator over the elements in this deque
	        Iterator<User> it = de_que.iterator();
	        System.out.println("BEFORE:");
	        while (it.hasNext()) {
	            System.out.println(it.next());
	        }
	        System.out.println("----------");
			// Operation 2
			// clear() method
			System.out.println("Using clear()...");

			// Clearing all elements using clear() method
			de_que.clear();
			
			// Display message
			System.out.println("Above elements are removed now");

			// Operations 3
			// addFirst() method

			// Inserting at the start
			de_que.addFirst(new User(564, "Suzanne", "eating"));
			de_que.addFirst(new User(291, "Oscar", "surfing"));

			// Operation 4
			// addLast() method
			// Inserting at end
			de_que.addLast(new User(24, "Bill", "playing guitar"));
			de_que.addLast(new User(14, "Kat", "watching tv"));

			// Returns an iterator over the elements in this deque
	        Iterator<User> it2 = de_que.iterator();
	        System.out.println("----------");
			System.out.println("AFTER: ");
	        while (it2.hasNext()) {
	            System.out.println(it2.next());
	        }
	        
	        System.out.println(TEXT_GREEN + "Demo complete! Press 'Enter' to go back to the main menu" + TEXT_RESET);
	        
	        readString = dq_scan.nextLine();
	        if (readString.isEmpty()) {
                log.debug("Read Enter Key. Returning to menu...");
                menu();
            }
			break;
		case 3:
			//linkedlist usage example
			log.debug("DEBUG: Option 3 was selected by user.");
			Scanner ll_scan = new Scanner(System.in);
			// Creating object of the
	        // class linked list
	        LinkedList<User> userList = new LinkedList<>();
	 
	        // Adding elements to the linked list
	        userList.add(new User(1, "Leon", "golfing"));
	        userList.add(new User(2, "Larry", "singing"));
	        userList.addLast(new User(3, "Marz", "dancing"));
	        userList.addFirst(new User(4, "Ruth", "skiiing"));
	        userList.add(2, new User(5, "Luke", "kayaking"));
	 
	        System.out.println("BEFORE:");
	        System.out.println(userList);
	        System.out.println("--------------");
	        userList.remove(3);
	        userList.removeFirst();
	        userList.removeLast();
	        System.out.println("AFTER:");
	        System.out.println(userList);
	        
	        System.out.println(TEXT_GREEN + "Demo complete! Press 'Enter' to go back to the main menu" + TEXT_RESET);
	        
	        readString = ll_scan.nextLine();
	        if (readString.isEmpty()) {
                log.debug("Read Enter Key. Returning to menu...");
                menu();
            }
			break;
		case 4:
			//hashset usage example
			log.debug("DEBUG: Option 4 was selected by user.");
			Scanner hs_scan = new Scanner(System.in);
			
			HashSet<String> continents = new HashSet<String>();
			  
	        // Adding elements into HashSet usind add()
			continents.add("India");
			continents.add("Australia");
			continents.add("South Africa");
			continents.add("India"); // adding duplicate elements
	  
	        // Displaying the HashSet
	        System.out.println(continents);
	        System.out.println("List contains India or not:"
	                           + continents.contains("India"));
	  
	        // Removing items from HashSet using remove()
	        continents.remove("Australia");
	        System.out.println("List after removing Australia:"
	                           + continents);
	  
	        // Iterating over hash set items
	        System.out.println("Iterating over list:");
	        Iterator<String> i = continents.iterator();
	        while (i.hasNext())
	            System.out.println(i.next());
			
			System.out.println(TEXT_GREEN + "Demo complete! Press 'Enter' to go back to the main menu" + TEXT_RESET);
	        
	        readString = hs_scan.nextLine();
	        if (readString.isEmpty()) {
                log.debug("Read Enter Key. Returning to menu...");
                menu();
            }
			break;
		case 5:
			//hashmap usage example
			log.debug("DEBUG: Option 5 was selected by user.");
			Scanner hm_scan = new Scanner(System.in);
			// Create a HashMap object called citiesVisited
		    HashMap<String, User> citiesVisited = new HashMap<String, User>();
			
		    // Add keys and values (City, User)
		    citiesVisited.put("London", new User(1, "Mary", "travelling"));
		    citiesVisited.put("Berlin", new User(2, "Mark", "watching sports"));
		    citiesVisited.put("Toyko", new User(3, "Marty", "eating"));
		    citiesVisited.put("Los Angeles", new User(4, "Mattie", "shopping"));
		    citiesVisited.put("Paris", null);
		    
		    System.out.println("Who Travelled Where?");
		    System.out.println("--------------------");
	    	System.out.println(citiesVisited);
	    	
	    	System.out.println("NOTE:");
	    	System.out.println(String.format("The person who has visited Berlin, Germany is %s.", citiesVisited.get("Berlin")));
			
			System.out.println(TEXT_GREEN + "Demo complete! Press 'Enter' to go back to the main menu" + TEXT_RESET);
	        
	        readString = hm_scan.nextLine();
	        if (readString.isEmpty()) {
                log.debug("Read Enter Key. Returning to menu...");
                menu();
            }
			break;
		case 6:
			//exit app
			log.debug("DEBUG: Option 6 was selected by user.");
			System.out.println(TEXT_BLUE + "\nThank you for using the Collections demo. Goodbye!" + TEXT_RESET);
			break;
		default:
			break;
		}
    }
}
