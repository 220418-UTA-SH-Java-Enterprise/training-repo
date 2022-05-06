package com.revature.producerconsumer;

public class Driver {

	public static void main(String[] args) {
		// Producer - Consumer Problem

		/*
		 * (* Producer/Consumer problem (also called a bounded buffer)
		 * 
		 * 
		 */
		Holder data = new Holder();
		int numValuesToGenerate = 10;

		// Create Threads
		Thread producerThread = new Thread(new Producer(data, numValuesToGenerate));
		Thread consumerThread = new Thread(new Consumer(data, numValuesToGenerate));

		// Start threads
		System.out.println("Starting threads......");

		producerThread.start();
		consumerThread.start();

		try {
			producerThread.join();
			consumerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
