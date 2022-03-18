package com.bmsrestfulapi.exceptions;

public class UserNotCreatedException extends Exception {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String message;

	public UserNotCreatedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserNotCreatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserNotCreatedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserNotCreatedException(String message) {
		super(message);
		this.message = message;
		// TODO Auto-generated constructor stub
	}

	public UserNotCreatedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
