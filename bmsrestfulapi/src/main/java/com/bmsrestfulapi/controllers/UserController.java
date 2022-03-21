package com.bmsrestfulapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmsrestfulapi.entities.AccountInfo;
import com.bmsrestfulapi.entities.Login;
import com.bmsrestfulapi.entities.Role;
import com.bmsrestfulapi.entities.User;
import com.bmsrestfulapi.exceptions.UserNotCreatedException;
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
	
	@GetMapping("/getAllNonVerifiedUsers")
	private ResponseEntity<List<User>> getAllNonVerifiedUsers() {
		return new ResponseEntity<List<User>>(userService.getAllNotVerifiedUser(),HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<String> createUser(@RequestBody User user) throws UserNotCreatedException {
		Role r = new Role(user);
		AccountInfo ai = new AccountInfo(user);
		List<AccountInfo> accountList = new ArrayList<AccountInfo>();
		accountList.add(ai);
		Login l = new Login(user,ai);
		
		user.setRole(r);
		user.setLogin(l);
		user.setAccountList(accountList);
		
		return new ResponseEntity<String>(userService.createUser(user), HttpStatus.CREATED);

	}
	
	
	@PostMapping("/verify")
	public ResponseEntity<String> verifyUser(@RequestBody User user) {
		return new ResponseEntity<String>(userService.verifyUser(user), HttpStatus.OK);

	}
	
}
