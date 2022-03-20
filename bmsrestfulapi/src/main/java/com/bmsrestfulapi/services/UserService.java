package com.bmsrestfulapi.services;

import java.util.List;

import com.bmsrestfulapi.entities.User;
import com.bmsrestfulapi.exceptions.InvalidLoginCredentialsException;
import com.bmsrestfulapi.exceptions.UserNotCreatedException;
import com.bmsrestfulapi.exceptions.UserNotVerifiedException;


public interface UserService {
	
	//get
	public List<User> getAllNotVerifiedUser();
	
	// creating a new user
	public String createUser(User user) throws UserNotCreatedException;

	// login user
	public String login(Integer accNo, String password) throws InvalidLoginCredentialsException, UserNotVerifiedException;

	public String verifyUser(User user);
	
	public String adminLogin(Integer accNo, String password) throws InvalidLoginCredentialsException, UserNotVerifiedException;
}
