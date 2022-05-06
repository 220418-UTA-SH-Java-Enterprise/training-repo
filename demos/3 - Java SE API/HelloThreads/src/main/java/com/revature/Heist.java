package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Heist {
	public static final int MAX_PASSWORD = 9999;

	public static void main(String[] args) {

		Random random = new Random();

		Vault vault = new Vault(random.nextInt(MAX_PASSWORD));
		System.out.println("The password is " + vault.password);

		List<Thread> threads = new ArrayList<>();

		threads.add(new AscendingHackerThread(vault));
		threads.add(new DescendingHackerThread(vault));
		threads.add(new PoliceThread());

		// iterate over each one and trigger the start() method
		threads.forEach(t -> t.start());

	}

	// Why static and nested? So it can't access instances of the enclosing class
	private static class Vault {

		private int password;

		public Vault(int password) {
			this.password = password;
		}

		// the hacker threads will be calling this method constantly
		public boolean isCorrectPassword(int guess) {

			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			return this.password == guess;

		}

	}

	// Thread is our parent class, so we're borrowing some methods
	private static abstract class HackerThread extends Thread {

		protected Vault vault;

		public HackerThread(Vault vault) {
//			super(); // this doesn't do anything really important because it's already here implicitly
			this.vault = vault;
			this.setName(this.getClass().getSimpleName());
			this.setPriority(Thread.MAX_PRIORITY); // this is a static variable that I'm fetching from the class itself
		}

		@Override
		public void start() {
			System.out.println("Starting thread " + this.getName());
			super.start();
		}

	}

	private static class AscendingHackerThread extends HackerThread {

		public AscendingHackerThread(Vault vault) {
			super(vault);
		}

		@Override
		public void run() {

			// iterate from 0 to MAX_PASSWord and check the vault's isCorrectPassword method
			for (int guess = 0; guess < MAX_PASSWORD; guess++) {

				if (vault.isCorrectPassword(guess)) {
					System.out.println(this.getName() + " guessed the password " + guess);
					System.exit(0);
				}

			}

		}

	}

	private static class DescendingHackerThread extends HackerThread {

		public DescendingHackerThread(Vault vault) {
			super(vault);
		}

		@Override
		public void run() {

			// iterate from 0 to MAX_PASSWord and check the vault's isCorrectPassword method
			for (int guess = MAX_PASSWORD; guess >= 0; guess--) {

				if (vault.isCorrectPassword(guess)) {
					System.out.println(this.getName() + " guessed the password " + guess);
					System.exit(0);
				}

			}

		}

	}

	private static class PoliceThread extends Thread {

		@Override
		public void run() {

			for (int i = 10; i > 0; i--) {
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i + " seconds left.");
			}

			System.out.println("Game over for you Hackers!");
			System.exit(0);
		}
	}
}
