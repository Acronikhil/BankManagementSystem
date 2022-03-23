package com.bmsrestfulapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bmsrestfulapi.services.AccountInfoService;


@RestController
@RequestMapping("/accountinfo/")
public class AccountInfoController {
	
	@Autowired
	AccountInfoService accountInfoService;
	
	@PostMapping("/getbalance")
	public ResponseEntity<String> getBalanceByUserId(@RequestParam Integer userId) {
		return new ResponseEntity<>(accountInfoService.checkBalance(userId), HttpStatus.OK);
	} 
	
}
