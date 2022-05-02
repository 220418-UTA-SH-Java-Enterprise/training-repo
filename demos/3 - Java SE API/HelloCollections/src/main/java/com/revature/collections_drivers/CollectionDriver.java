package com.revature.collections_drivers;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.custom_exceptions.InvalidMenuSelectionException;

public class CollectionDriver {
	
	private static Scanner scanner = new Scanner(System.in);
	private static Display display = new Display();
	private static Logger logger = Logger.getLogger(CollectionDriver.class);
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
    	logger.info("This is an informational message from CollectionDriver.");
    	logger.info("Starting app...");
		display.menu();
		int pick = 0;
		do {
			try {
				pick = Integer.parseInt(scanner.nextLine());
				Thread.sleep(1000);
				switch (pick) {
					case 1:
						display.menuSelection(1);
						break;
					case 2:
						display.menuSelection(2);
						break;
					case 3:
						display.menuSelection(3);
						break;
					case 4:
						display.menuSelection(4);
						break;
					case 5:
						display.menuSelection(5);
						break;
					case 6:
						display.menuSelection(6);
						scanner.close();
						System.exit(0);
						break;
					default:
						logger.warn(pick + " is an unavailable menu option. Closing the application...");
						System.out.println(ANSI_RED + String.format("ERROR: Menu option %d is an unacceptable choice. Please see error log. Closing app...", pick) + ANSI_RESET);
						break;
				}
			} catch (InterruptedException e) {
				System.out.println(ANSI_RED + "Program execution interrupted. Closing app..." + ANSI_RESET);
				logger.error("Thread interrupted in CollectionDriver:Main method. Stack Trace: ", e); 
			}catch (InputMismatchException e) {
				System.out.println(ANSI_RED + "ERROR: Menu option entered is an invalid input. See error in log. Closing app..."+ ANSI_RESET);
				logger.error("InputMismatch - Numbers accepted here only. From - CollectionDriver:Main method. Stack Trace: ", new InvalidMenuSelectionException("Not a number input. Trace: " + e.toString()));
			}
		} while(pick != 6);
    }
}
