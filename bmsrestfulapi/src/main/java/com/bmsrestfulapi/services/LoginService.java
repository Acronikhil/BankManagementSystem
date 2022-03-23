package com.bmsrestfulapi.services;

import com.bmsrestfulapi.exceptions.InvalidLoginCredentialsException;
import com.bmsrestfulapi.exceptions.UserNotVerifiedException;

public interface LoginService {

	public String login(Integer accNo, String password)
			throws InvalidLoginCredentialsException, UserNotVerifiedException;

	public String adminLogin(Integer accNo, String password)
			throws InvalidLoginCredentialsException, UserNotVerifiedException;

}
