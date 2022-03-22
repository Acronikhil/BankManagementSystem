package com.bmsrestfulapi.exceptions;

public class UserNotCreatedException extends Exception {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String message;

	public UserNotCreatedException() {
		super();

	}

	public UserNotCreatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public UserNotCreatedException(String message, Throwable cause) {
		super(message, cause);

	}

	public UserNotCreatedException(String message) {
		super(message);
		this.message = message;

	}

	public UserNotCreatedException(Throwable cause) {
		super(cause);

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
