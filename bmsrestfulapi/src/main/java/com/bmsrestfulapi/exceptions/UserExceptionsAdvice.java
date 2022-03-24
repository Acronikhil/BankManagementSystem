package com.bmsrestfulapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 *handles all the users exceptions
 */
@RestControllerAdvice
public class UserExceptionsAdvice {
	/*
	 * handling user not found exception
	 */
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String userNotFound(UserNotFoundException ex) {
		return ex.getMessage();
	}

	/*
	 * handling user not created exception
	 */
	@ExceptionHandler(UserNotCreatedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String userNotCreated(UserNotCreatedException ex) {
		return ex.getMessage();
	}

	/*
	 * handling user not verified exception
	 */
	@ExceptionHandler(UserNotVerifiedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String userNotVerified(UserNotVerifiedException ex) {
		return ex.getMessage();
	}

	/*
	 * handling invalid credentials exception
	 */
	@ExceptionHandler(InvalidCredentialsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String invalidCredentials(InvalidCredentialsException ex) {
		return ex.getMessage();
	}

	/*
	 * handling empty user list exception
	 */
	@ExceptionHandler(EmptyUserListException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String getAllNotVerifiedUsers(EmptyUserListException ex) {
		return ex.getMessage();
	}

}
