package com.bmsrestfulapi.exceptions;

public class UserNotVerifiedException extends Exception {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String message;

	public UserNotVerifiedException() {
		super();

	}

	public UserNotVerifiedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public UserNotVerifiedException(String message, Throwable cause) {
		super(message, cause);

	}

	public UserNotVerifiedException(String message) {
		super(message);
		this.message = message;

	}

	public UserNotVerifiedException(Throwable cause) {
		super(cause);

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
