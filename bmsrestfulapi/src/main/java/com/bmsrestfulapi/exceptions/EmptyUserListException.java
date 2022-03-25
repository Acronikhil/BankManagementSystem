package com.bmsrestfulapi.exceptions;

/*
 * class representing custom exception 
 */
public class EmptyUserListException extends Exception {

	private static final long serialVersionUID = 1L;

	/*
	 * calling the constructor of parent Exception
	 */
	public EmptyUserListException(String message) {
		super(message);
	}

}
