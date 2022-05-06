package com.revature;

import java.math.BigInteger;

public class Interruption {
	public static void main(String[] args) {
		// Here I will instnatitate a thread by passing a runnable object to its
		// constructor
		Thread compThread = new Thread(
				new LongComputationTask(new BigInteger("400000000000000000"), new BigInteger("20000000000000")));

		//			try {
		//				Thread.currentThread().wait();
		//			} catch (InterruptedException e) {
		//
		//				e.printStackTrace();
		//			}

		/**
		 * A daemon thread is a thread that does not prevent the JVM from exiting when
		 * the program finishes but the thread is still running.
		 * 
		 */
		compThread.setDaemon(true);
		compThread.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		compThread.interrupt();

	}

	// calcualte a number to a given power
	private static class LongComputationTask implements Runnable {

		private BigInteger base;
		private BigInteger power;

		// create a constructor
		public LongComputationTask(BigInteger base, BigInteger power) {
			super();
			this.base = base;
			this.power = power;
		}

		@Override
		public void run() {
			// we will print (sysout) the result of a pow() method
			System.out.println(base + "^" + power + " = " + pow(base, power));

		}

		// method to calcualte a num to a given power
		private BigInteger pow(BigInteger base, BigInteger power) {

			BigInteger result = BigInteger.ONE;

			/**
			 * The compareTo() method is just checking that we don't raise the base to a
			 * number > power because a return value of 0 will indicate "equal to"
			 */
			for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {

				if (Thread.currentThread().isInterrupted()) {

					System.out.println("Thread prematurely interrupted");
					return BigInteger.ZERO;

				}

				result = result.multiply(base);

			}
			return result;

		}

	}
}
