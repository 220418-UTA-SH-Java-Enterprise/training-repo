package com.revature.multithreaded_challenge;

import java.math.BigInteger;

/*
 * ===========================================================
 * =============== MultiThreaded Calculation =================
 * ===========================================================
 * In this DIY coding exercise we will apply all the knowledge from the 
 * previous lectures.Before taking the exercise make sure you review
 * the following topics in particular:
 * 
 * 1. Thread Creation - how to create and start a thread using the Thread class and the start() method.
 *
 * 2. Thread Join - how to wait for another thread using the Thread.join() method.
 * 	                Remember: Remember that .join() tells the calling program to wait until the thread
					          object upon which the join method has been called has finished its work.
 * 
 * In this exercise we will efficiently calculate the following result = base1 ^ power1 + base2 ^ power2
 * Where a^b means: a raised to the power of b.
 *
 * For example 10^2 = 100
 * 
 * We know that raising a number to a power is a complex computation, so we we like to execute:
 * 
 * 			result1 = x1 ^ y1 
 * 
 * 			result2 = x2 ^ y2
 * 
 * In parallel, and combine the result in the end : result = result1 + result2
 * This way we can speed up the entire calculation.
 * 
 * NOTE: base1 >= 0, base2 >= 0, power1 >= 0, power2 >= 0
 * ===========================================================
 * ===========================================================
 */

/*
 * =================================
 * ========== Challenge ============
 * =================================
 * 1) Provide implementation to the custom thread PowerCalculatingThread below.
 * 2) Provide logic for the calculateResult method below.
 * 
 * Trainer will provide solution after Monday's quiz (5/9/2022).
 * 
 */
public class MultiThreadedCalculationChallenge {
	public static void main(String[] args) {
		//DO NOT TOUCH THIS LINE!
		calculateResult(new BigInteger("321456"), new BigInteger("321456"), new BigInteger("321456"), new BigInteger("321456"));
	}
	
	public static BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
		//write your code here
		//modify line below if needed
		return BigInteger.ZERO;
	}
	
	private static class PowerCalculatingThread extends Thread {
		//write your code here
	}

}
