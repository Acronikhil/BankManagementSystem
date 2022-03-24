package com.bmsrestfulapi.exceptions;

/*
 * class representing custom exception 
 */
public class InvalidCredentialsException extends Exception {

	private static final long serialVersionUID = 1L;

	/*
	 * calling the constructor of parent Exception
	 */
	public InvalidCredentialsException(String message) {
		super(message);
	}

}
