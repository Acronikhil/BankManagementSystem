package com.bmsrestfulapi.exceptions;

public class InvalidCredentialsException extends Exception {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String message;

	public InvalidCredentialsException() {
		super();

	}

	public InvalidCredentialsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public InvalidCredentialsException(String message, Throwable cause) {
		super(message, cause);

	}

	public InvalidCredentialsException(String message) {
		super(message);
		this.message = message;

	}

	public InvalidCredentialsException(Throwable cause) {
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
