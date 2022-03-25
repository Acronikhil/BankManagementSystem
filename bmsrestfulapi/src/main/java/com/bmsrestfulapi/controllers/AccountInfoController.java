package com.bmsrestfulapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bmsrestfulapi.exceptions.InvalidCredentialsException;
import com.bmsrestfulapi.exceptions.UserNotFoundException;
import com.bmsrestfulapi.services.AccountInfoService;

@RestController
@RequestMapping("/accountinfo/")
public class AccountInfoController {

	@Autowired
	AccountInfoService accountInfoService;

	/*
	 * Admin will get balance of their users by userId
	 */
	@PostMapping("/getbalance")
	public ResponseEntity<String> getBalanceByUserId(@RequestParam Integer userId, Integer adminId)
			throws UserNotFoundException, InvalidCredentialsException {
		return new ResponseEntity<>(accountInfoService.checkBalance(userId, adminId), HttpStatus.OK);
	}

	/*
	 * Admin will add money in users account by userId, accountNo and amount
	 */
	@PostMapping("/addmoney")
	public ResponseEntity<String> addMoney(@RequestParam Integer accountNo, Integer adminId, Integer amount)
			throws InvalidCredentialsException, UserNotFoundException {
		return new ResponseEntity<>(accountInfoService.addMoney(accountNo, adminId, amount), HttpStatus.OK);
	}

}
