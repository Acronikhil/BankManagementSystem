package com.bmsrestfulapi.exceptions;

public class InvalidLoginCredentialsException extends Exception {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private String message;

	public InvalidLoginCredentialsException() {
		super();

	}

	public InvalidLoginCredentialsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public InvalidLoginCredentialsException(String message, Throwable cause) {
		super(message, cause);

	}

	public InvalidLoginCredentialsException(String message) {
		super(message);
		this.message = message;

	}

	public InvalidLoginCredentialsException(Throwable cause) {
		super(cause);

	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
