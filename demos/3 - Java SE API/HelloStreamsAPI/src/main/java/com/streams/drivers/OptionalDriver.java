package com.streams.drivers;

import java.util.Optional;

import com.streams.models.Employee;

public class OptionalDriver {

	/* Optional class
	 * 
	 * Introduced in Java 8, Optional is a container object used to contain not-null objects.
	 * Optional object is used to represent null with absent value. 
	 * This class has various utility methods to facilitate code to handle 
	 * values as ‘available’ or ‘not available’ instead of checking null values.
	 * 
	 * These objects are commonly used with generics.
	 * Learn more at: https://www.geeksforgeeks.org/java-8-optional-class/
	 */
	public static void main(String[] args) {
		//demoWithoutOptionals();
		demoWithOptionals();
	}
	
	public static void demoWithoutOptionals() {
		Employee[] employees = new Employee[10]; //this Employee array contains 10 null Employee objects
        String employeeName = employees[5].getName().toLowerCase(); //employeeName = null.toLowerCase = NULL!
        System.out.print(employeeName); //results in a NullPointerExcetion
	}

	public static void demoWithOptionals() {
		Employee[] employees = new Employee[10];
        Optional<Employee> checkNull = Optional.ofNullable(employees[5]);
        if (checkNull.isPresent()) {
            String employeeName = employees[5].getName().toLowerCase();
            System.out.print(employeeName);
        }
        else
            System.out.println("employee name is null");
	}
}
