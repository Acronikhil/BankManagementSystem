package com.bmsrestfulapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bmsrestfulapi.entities.User;
import com.bmsrestfulapi.exceptions.InvalidLoginCredentialsException;
import com.bmsrestfulapi.exceptions.UserNotCreatedException;
import com.bmsrestfulapi.exceptions.UserNotVerifiedException;
import com.bmsrestfulapi.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	private String defaultMessage() {
		return "User Home Page";
	}

	@PostMapping("/create")
	public ResponseEntity<String> createUser(@RequestBody User user) throws UserNotCreatedException {
		return new ResponseEntity<String>(userService.createUser(user), HttpStatus.CREATED);

	}
	
	@PostMapping("/login")
	public  ResponseEntity<String> loginUser(@RequestParam Integer accountNo, @RequestParam String password) throws InvalidLoginCredentialsException, UserNotVerifiedException {
		return new ResponseEntity<String>(userService.login(accountNo, password), HttpStatus.OK);
	}
   
	@PostMapping("/adminlogin")
	public  ResponseEntity<String> adminLogin(@RequestParam Integer accountNo, @RequestParam String password) throws InvalidLoginCredentialsException, UserNotVerifiedException {
		return new ResponseEntity<String>(userService.adminLogin(accountNo, password), HttpStatus.OK);
	}
}
