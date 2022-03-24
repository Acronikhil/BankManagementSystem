package com.bmsrestfulapi.exceptions;

/*
 * class representing custom exception 
 */
public class UserNotVerifiedException extends Exception {
	private static final long serialVersionUID = 1L;

	/*
	 * calling the constructor of parent Exception
	 */
	public UserNotVerifiedException(String message) {
		super(message);
	}

}
