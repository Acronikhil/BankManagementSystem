package com.bmsrestfulapi.services;

import java.util.List;

import com.bmsrestfulapi.entities.User;
import com.bmsrestfulapi.exceptions.InvalidCredentialsException;
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

	public String verifyUser(Integer userId);
	
	public String adminLogin(Integer accNo, String password) throws InvalidLoginCredentialsException, UserNotVerifiedException;
	
	public String checkBalance(Integer pin, Integer userId) throws InvalidCredentialsException;
	
	public String withdrawMoney(Integer pin, Integer amount, Integer accountNo) throws InvalidCredentialsException;
	
	public String moneyTransfer(Integer pin, Integer amount, Integer accountNo, Integer receiversAccountNo) throws InvalidCredentialsException;
}
