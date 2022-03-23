package com.bmsrestfulapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmsrestfulapi.repositories.AccountInfoRepository;

@Service
public class AccountInfoServiceImpl implements AccountInfoService {

	@Autowired
	AccountInfoRepository accountInfoRepository;
	
	@Override
	public String checkBalance(Integer userId) {
		return "Current balance: " + accountInfoRepository.getBalance(userId);
	}

}
