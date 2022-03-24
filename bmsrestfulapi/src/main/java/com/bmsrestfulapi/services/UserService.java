package com.bmsrestfulapi.services;

import java.util.List;

import com.bmsrestfulapi.entities.User;
import com.bmsrestfulapi.exceptions.EmptyUserListException;
import com.bmsrestfulapi.exceptions.InvalidCredentialsException;
import com.bmsrestfulapi.exceptions.UserNotCreatedException;
import com.bmsrestfulapi.exceptions.UserNotFoundException;

public interface UserService {

	public static final String STRING = "\"string\"";

	// get
	public List<User> getAllNotVerifiedUser() throws EmptyUserListException;

	// creating a new user
	public String createUser(User user) throws UserNotCreatedException;

	public String verifyUser(Integer userId);

	public String checkBalance(Integer pin, Integer userId) throws InvalidCredentialsException;

	public String withdrawMoney(Integer pin, Integer amount, Integer accountNo) throws InvalidCredentialsException;

	public String moneyTransfer(Integer pin, Integer amount, Integer accountNo, Integer receiversAccountNo)
			throws InvalidCredentialsException;
	
	public String deleteUserById(Integer userId, Integer adminId) throws UserNotFoundException, InvalidCredentialsException;
	
	public String updateUser(User user, Integer adminId) throws UserNotFoundException, InvalidCredentialsException;
	
	public String getAllUsers(Integer adminId) throws EmptyUserListException, InvalidCredentialsException;

}
