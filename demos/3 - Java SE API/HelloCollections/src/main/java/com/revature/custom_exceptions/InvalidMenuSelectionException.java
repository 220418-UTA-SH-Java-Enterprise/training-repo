package com.revature.custom_exceptions;

public class InvalidMenuSelectionException extends NumberFormatException{
	private static final long serialVersionUID = 1L;
	
	public InvalidMenuSelectionException() {}

	public InvalidMenuSelectionException(String message) {
		super(message);
	}
}
