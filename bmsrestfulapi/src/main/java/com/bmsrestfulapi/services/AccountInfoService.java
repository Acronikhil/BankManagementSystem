package com.bmsrestfulapi.services;

import com.bmsrestfulapi.exceptions.InvalidCredentialsException;
import com.bmsrestfulapi.exceptions.NotLoggedInException;
import com.bmsrestfulapi.exceptions.UserNotFoundException;

public interface AccountInfoService {

	/* Check the current balance through user id */
	public String checkBalance(Integer userId, Integer adminId)
			throws UserNotFoundException, InvalidCredentialsException, NotLoggedInException;

	/*
	 * Deposit money to the account. It requires account number, user id and amount.
	 */
	public String addMoney(Integer accountNo, Integer userId, Integer amount)

			throws InvalidCredentialsException, UserNotFoundException, NotLoggedInException;

}
