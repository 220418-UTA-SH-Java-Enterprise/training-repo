package com.revature;

public class ThreadCreation {

	public static void main(String[] args) {
		/*
		 * What is a thread?
		 * - A thread is a execution of tasks/calls within your program that run concurrently (aka back to back)
		 * 
		 * How do I create my own threads?
		 * - 2 ways:
		 * 
		 * 1) Implement Runnable interface and pass it to a new Thread object's constructor
		 * 
		 * 2) Extend Thread class, and create an object of that class
		 * 
		 * 
		 */
		
		Thread t1 = new NewThread();
		
		//replaces the default name of the thread
		t1.setName("Bob the Threader");
		
		//tells the JVM to begin execution and start our run() method
		t1.start();
		
		//changes priority of execution for the given thread
		t1.setPriority(Thread.MAX_PRIORITY);
		
		//deprecated = it's a old method/class/interface that is not longer getting support from Oracle
		//meaning that there is a new way to doing the same process that the old technique offers
		//t1.checkAccess(); //same as getPriority()
		
		System.out.println("Priority for t1: " + t1.getPriority());
		
		try {
			//the sleep method causes the current thread (main) to pause execution by x amount of milliseconds
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//this belongs to the main thread
		System.out.println("Hello from the Main thread! Its name is " + Thread.currentThread().getName());
		
		//approach #1
		//creating a thread using an anonymous class called a "lambda" to provide functionality of the run() method
		
		//anonymous classes are classes that enable you to make your code more concise 
		//aka inner classes or local classes
		
		//a lambda expression is short block of code that takes in parameters and returns a value without the typical signature
		//or name of that method/class/interface
		//no name needed and can implement right in the body of the given entity
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				//the run method is called if the thread was constructed using a separate Runnable object
				//the thread's start() calls the inner run method
				System.out.println("Hiya! We are now in thread " + Thread.currentThread().getName());
			}
		}
				
		);
		
		t2.start();
		
		//this is how we create a thread from a lambda expression
		/* Basic syntax for a lambda expression:
		 * (NOTE: lambdas are a feature that was added in Java 8)
		 * 
		 * //expression body = code or logic here
		 * parameter -> expression body 
		 * 
		 * this is the same as:
		 * public methodName (params) {
		 * 	//some code
		 * } 
		 */
		Thread t3 = new Thread(() -> System.out.println("Running from a lambda thread."));
		
		t3.setName("Revature Thread");
		t3.start();
		System.out.println("t3 name is " + t3.getName());
	}
	
	/* The states of threads:
	 * 
	 * 1) New = when it is created
	 * 2) Runnable = its run() method has been implemented
	 * 3) Running = its start() method has been called
	 * 4) Non-Runnable = the thread's execution is being blocked by deadlock
	 * (deadlock means when two threads are trying to access the same resource, causing both to be put in a waiting state)
	 * 5) Terminated = the thread stops execution by either the stop() method or interrupt() method or program closes 
	 */
	
	//approach #2
	private static class NewThread extends Thread{
		public void run() {
			System.out.println("Hello from " + this.getName());
		}
	}

}
