package com.revature.overload;

//method overloading = methods having the same name and different signatures by datatype or number
//parameters must be different, method name same, return type doesn't matter
//this is an example of polymorphism
public class MethodOverloadingExample {

	public static void main(String[] args) {
		System.out.println("Calling add()...");
		System.out.println(add(4.3, 6.4, 9.1));
	}
	
	
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static int add(int a, int b, int c) {
		return a + b + c;
	}
	
	public static int add(double a, double b) {
		//casting prevent type coercion from happening
		return (int) (a + b);
	}
	
	public static double add(double a, double b, double c) {
		return a + b + c;
	}
}
