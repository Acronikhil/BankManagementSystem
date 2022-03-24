package com.bmsrestfulapi.services;

import com.bmsrestfulapi.exceptions.InvalidLoginCredentialsException;
import com.bmsrestfulapi.exceptions.UserNotVerifiedException;

/*all login operations*/
public interface LoginService {

	/* login user by account number and password */
	public String login(Integer accNo, String password)
			throws InvalidLoginCredentialsException, UserNotVerifiedException;

//	login admin by account number and password
	public String adminLogin(Integer accNo, String password)
			throws InvalidLoginCredentialsException, UserNotVerifiedException;

}
