package com.bmsrestfulapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bmsrestfulapi.exceptions.InvalidLoginCredentialsException;
import com.bmsrestfulapi.exceptions.UserNotVerifiedException;
import com.bmsrestfulapi.services.UserService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public  ResponseEntity<String> loginUser(@RequestParam Integer accountNo, @RequestParam String password) throws InvalidLoginCredentialsException, UserNotVerifiedException {
		return new ResponseEntity<>(userService.login(accountNo, password), HttpStatus.OK);
	}
   
	@PostMapping("/admin")
	public  ResponseEntity<String> adminLogin(@RequestParam Integer accountNo, @RequestParam String password) throws InvalidLoginCredentialsException, UserNotVerifiedException {
		return new ResponseEntity<>(userService.adminLogin(accountNo, password), HttpStatus.OK);
	}

}
