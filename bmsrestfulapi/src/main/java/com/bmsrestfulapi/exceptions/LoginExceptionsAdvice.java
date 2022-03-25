package com.bmsrestfulapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 *handles all the login related exceptions
 */
@RestControllerAdvice
public class LoginExceptionsAdvice {
	/*
	 * handling invalid login credentials exception
	 */
	@ExceptionHandler(InvalidLoginCredentialsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String invalidLoginCredentials(InvalidLoginCredentialsException ex) {
		return ex.getMessage();
	}
	
	/* handling the exception when user is not loggedIn */
	@ExceptionHandler(NotLoggedInException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String notLoggedInException(NotLoggedInException ex) {
		return ex.getMessage();
	}

}
