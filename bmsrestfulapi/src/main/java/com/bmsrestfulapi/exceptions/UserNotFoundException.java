package com.bmsrestfulapi.exceptions;

/*
 * class representing custom exception 
 */
public class UserNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	/*
	 * calling the constructor of parent Exception
	 */
	public UserNotFoundException(String message) {
		super(message);
	}

}
