package com.bmsrestfulapi.exceptions;

/*
 * class representing custom exception 
 */
public class NotLoggedInException extends Exception {
	private static final long serialVersionUID = 1L;

	/*
	 * calling the constructor of parent Exception
	 */
	public NotLoggedInException(String message) {
		super(message);
	}

}
