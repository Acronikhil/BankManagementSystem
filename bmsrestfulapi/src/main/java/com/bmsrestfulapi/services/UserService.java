package com.bmsrestfulapi.services;

import com.bmsrestfulapi.entities.User;
import com.bmsrestfulapi.exceptions.InvalidCredentialsException;

public interface UserService {
	// creating a new user
	public String createUser(User user);
	
	//login user
	public String login(Integer accNo, String password) throws InvalidCredentialsException;

}
