package com.bmsrestfulapi.exceptions;

public class UserNotFoundException extends Exception {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String message;

	public UserNotFoundException() {
		super();

	}

	public UserNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public UserNotFoundException(String message) {
		super(message);
		this.message = message;

	}

	public UserNotFoundException(Throwable cause) {
		super(cause);

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
