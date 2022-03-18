package com.bmsrestfulapi.exceptions;

public class UserNotVerifiedException extends Exception {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String message;

	public UserNotVerifiedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserNotVerifiedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserNotVerifiedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserNotVerifiedException(String message) {
		super(message);
		this.message = message;
		// TODO Auto-generated constructor stub
	}

	public UserNotVerifiedException(Throwable cause) {
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
