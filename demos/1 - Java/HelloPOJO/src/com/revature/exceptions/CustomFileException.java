package com.revature.exceptions;

import java.io.IOException;

public class CustomFileException extends IOException{
	
	public CustomFileException (String message) {
		super(message);
	}

}
