package com.bmsrestfulapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmsrestfulapi.entities.AccountInfo;
import com.bmsrestfulapi.entities.Login;
import com.bmsrestfulapi.entities.User;
import com.bmsrestfulapi.exceptions.CustomExceptionsMessages;
import com.bmsrestfulapi.exceptions.InvalidCredentialsException;
import com.bmsrestfulapi.exceptions.UserNotFoundException;
import com.bmsrestfulapi.repositories.AccountInfoRepository;
import com.bmsrestfulapi.repositories.RoleRepository;
import com.bmsrestfulapi.repositories.UserRepository;

@Service
public class AccountInfoServiceImpl implements AccountInfoService {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private AccountInfoRepository accountInfoRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public String checkBalance(Integer userId, Integer adminId) throws UserNotFoundException, InvalidCredentialsException {
		if (userRepository.existsById(adminId)) {
			User admin = userRepository.getById(adminId);
			if (admin.getRole().getRoleName().equalsIgnoreCase(UserService.ADMIN)) {
				if (userRepository.existsById(userId)) {
					return "Current balance: " + accountInfoRepository.getBalance(userId);
				} else {
					throw new UserNotFoundException(CustomExceptionsMessages.NO_USER_EXISTS_WITH_THIS_ID);
				}
			} else {
				throw new InvalidCredentialsException(CustomExceptionsMessages.YOU_ARE_NOT_ADMIN_CONTACT_TO_BM);
			}
		} else {
			throw new UserNotFoundException(CustomExceptionsMessages.NO_ADMIN_EXIST_BY_ID);
		}
		
	}

	@Override
	public String addMoney(Integer accountNo , Integer userId  , Integer amount)
			throws InvalidCredentialsException, UserNotFoundException {
		if (userRepository.existsById(userId)) {
			String role = roleRepository.getRole(userId).toLowerCase();
			if (role.equals("admin")) {
				AccountInfo accountInfo = accountInfoRepository.getAccountNo(accountNo);
				if (accountInfo != null && accountInfo.getAccountNo().equals(accountNo)) {
					Integer availableBalance = accountInfo.getCurrentBalance();
					availableBalance += amount;
					accountInfo.setCurrentBalance(availableBalance);
					accountInfoRepository.save(accountInfo);
					return "Money Added Successfully! \nCurrent balance is: " + availableBalance;
				} else {
					throw new InvalidCredentialsException(CustomExceptionsMessages.NO_USER_WITH_THIS_ACCOUNT_NUMER);
				}
			} else {
				throw new InvalidCredentialsException(CustomExceptionsMessages.CANT_ADD_MONEY);
			}
		} else {
			throw new UserNotFoundException(CustomExceptionsMessages.NO_ADMIN_EXIST_BY_ID);
		}
	}

}
