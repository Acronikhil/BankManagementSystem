package com.bmsrestfulapi.exceptions;

/*
 * class representing custom exception 
 */
public class UserNotCreatedException extends Exception {

	private static final long serialVersionUID = 1L;

	/*
	 * calling the constructor of parent Exception
	 */
	public UserNotCreatedException(String message) {
		super(message);
	}

}
