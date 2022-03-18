package com.bmsrestfulapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class LoginExceptionsAdvice {
	
	@ExceptionHandler(InvalidLoginCredentialsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String invalidLoginCredentials(InvalidLoginCredentialsException ex) {
		return ex.getMessage();
	}

}
