package com.bmsrestfulapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmsrestfulapi.entities.AccountInfo;
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
	public String checkBalance(Integer userId) {
		return "Current balance: " + accountInfoRepository.getBalance(userId);
	}

	@Override
	public String addMoney(Integer userId, Integer accountNo, Integer amount)
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
					throw new InvalidCredentialsException("No user exist with this account number");
				}
			} else {
				throw new InvalidCredentialsException("You are not an Admin \nCan't perform this action");
			}
		} else {
			throw new UserNotFoundException("No admin exist with this Id");
		}
	}

}
