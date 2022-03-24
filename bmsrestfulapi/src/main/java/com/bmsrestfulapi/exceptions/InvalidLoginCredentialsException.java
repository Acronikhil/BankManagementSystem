package com.bmsrestfulapi.exceptions;

/*
 * class representing custom exception 
 */
public class InvalidLoginCredentialsException extends Exception {

	private static final long serialVersionUID = 1L;

	/*
	 * calling the constructor of parent Exception
	 */
	public InvalidLoginCredentialsException(String message) {
		super(message);

	}

}
