package com.streams.drivers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.streams.models.Employee;

public class StreamsDriver {

	/*
	 * Streams - Streams API was introduced in Java 8. It is used to process a collection of objects.
	 * 
	 *  A stream is NOT a collection! It is a sequence of object references that support various methods that can
	 *  be pipelined to produce the desired result/outcome.
	 *  
	 *  We use Streams to take input from Collections, Arrays, or I/O channels.
	 *  
	 *  
	 *  Real-life example of a stream:
	 *  - think of a sap tap on a maple tree
	 *  we use that tap in the tree to extract what we want (sap) and transform to something that we desire (maple syrup)
	 * 
	 */
	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(
				new Employee("Bob", 25), 
				new Employee("Amy", 35),
				new Employee("Joe", 28),
				new Employee("Mike", 47),
				new Employee("Bert", 33)
		);
		
		//print all the employees whose names start with B
		//this is the traditional way we've been operating with collections
		list.forEach(e -> {
			if(e.getName().startsWith("B")) {
				System.out.println(e);
			}
		});
		
		System.out.println("--------------------------");

		//this is the stream way of doing the same thing
		list.stream()
			.filter(s -> s.getName().startsWith("B")) //only finds the employees with B names
			.sorted() //puts the names in ABC order
			
			//here we are referencing the method from its specific class that we want to perform on each element
			//basic syntax:
			//Method referencing Class::Method
			.forEach(System.out::println); //for each of those elements, print the object.toString()
		
		System.out.println("--------------------------");
		
		List<String> names = Arrays.asList("Bunny", "Tony", "Fido", "Nic", "Thomas");
		
		names.stream()
			.map(String::toUpperCase) //map applies a given function to each element within the data structure
			.forEach(System.out::println);
		
		//once you tap into a stream, the transformation that you do in that stream do not associate with the object itself
		//names.forEach(System.out::println); //returns names in titleCase instead of uppercase
	}

}
