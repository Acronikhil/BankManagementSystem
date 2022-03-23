package com.bmsrestfulapi.services;

import java.util.List;

import com.bmsrestfulapi.entities.User;
import com.bmsrestfulapi.exceptions.InvalidCredentialsException;
import com.bmsrestfulapi.exceptions.UserNotCreatedException;

public interface UserService {

	public static final String STRING = "\"string\"";

	// get
	public List<User> getAllNotVerifiedUser();

	// creating a new user
	public String createUser(User user) throws UserNotCreatedException;

	public String verifyUser(Integer userId);

	public String checkBalance(Integer pin, Integer userId) throws InvalidCredentialsException;

	public String withdrawMoney(Integer pin, Integer amount, Integer accountNo) throws InvalidCredentialsException;

	public String moneyTransfer(Integer pin, Integer amount, Integer accountNo, Integer receiversAccountNo)
			throws InvalidCredentialsException;
}
