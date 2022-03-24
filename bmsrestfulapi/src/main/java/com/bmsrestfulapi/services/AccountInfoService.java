package com.bmsrestfulapi.services;

import com.bmsrestfulapi.exceptions.InvalidCredentialsException;
import com.bmsrestfulapi.exceptions.UserNotFoundException;

public interface AccountInfoService {

	public String checkBalance(Integer userId);

	public String addMoney(Integer userId, Integer accountNo, Integer amount)
			throws InvalidCredentialsException, UserNotFoundException;

}
