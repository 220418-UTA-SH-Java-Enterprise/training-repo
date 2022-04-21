package com.revature;

//Recursion = a method calls itself continuously, making our code more compact and makes our code more readable
//warning: if not done/handled properly, you can StackOverflowError!!!
//you will likely use recursion with menu creations in your project. also fibbonacci series
public class Recursion {

	public static void main(String[] args) {
		System.out.println(factorial(0));
	}
	
	//5! = 5 * 4 * 3 * 2 * 1
	public static long factorial(int n) {
		if(n == 1) {
			return 1;
		}else if(n <= 0) {
			return 1;
		}else if (n <= 65){
			return n * factorial(n - 1);
		}else {
			return 0;
		}
	}

}
