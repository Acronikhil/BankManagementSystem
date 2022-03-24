package com.bmsrestfulapi.services;

import com.bmsrestfulapi.exceptions.InvalidCredentialsException;
import com.bmsrestfulapi.exceptions.UserNotFoundException;

public interface AccountInfoService {

	/* Check the current balance through user id */
	public String checkBalance(Integer userId);

	/*
	 * Deposit money to the account. It requires account number, user id and amount.
	 */
	public String addMoney(Integer amount, Integer accountNo, Integer userId)
			throws InvalidCredentialsException, UserNotFoundException;

}
