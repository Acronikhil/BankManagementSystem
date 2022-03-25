package com.bmsrestfulapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bmsrestfulapi.entities.AccountInfo;
import com.bmsrestfulapi.entities.Login;
import com.bmsrestfulapi.entities.Role;
import com.bmsrestfulapi.entities.User;
import com.bmsrestfulapi.exceptions.EmptyUserListException;
import com.bmsrestfulapi.exceptions.InvalidCredentialsException;
import com.bmsrestfulapi.exceptions.NotLoggedInException;
import com.bmsrestfulapi.exceptions.UserNotCreatedException;
import com.bmsrestfulapi.exceptions.UserNotFoundException;
import com.bmsrestfulapi.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String defaultMessage() {
		return "User Home Page";
	}

	/*
	 * Admin creates user
	 */
	@PostMapping("/create")
	public ResponseEntity<String> createUser(@RequestBody User user) throws UserNotCreatedException {
		Role r = new Role(user);
		AccountInfo ai = new AccountInfo(user);
		List<AccountInfo> accountList = new ArrayList<>();
		accountList.add(ai);
		Login l = new Login(user, ai);

		user.setRole(r);
		user.setLogin(l);
		user.setAccountList(accountList);

		return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);

	}

	/*
	 * Admin deletes user and admin by userId and adminId
	 * 
	 */
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteUserById(@RequestParam Integer userId, Integer adminId)
			throws UserNotFoundException, InvalidCredentialsException, NotLoggedInException {
		return new ResponseEntity<>(userService.deleteUserById(userId, adminId), HttpStatus.ACCEPTED);
	}

	/*
	 * Admin updates user
	 */

	@PutMapping("/update")
	public ResponseEntity<String> updateUser(@RequestBody User user, @RequestParam(value = "adminId") Integer adminId)
			throws UserNotFoundException, InvalidCredentialsException, NotLoggedInException {
		return new ResponseEntity<>(userService.updateUser(user, adminId), HttpStatus.OK);
	}

	/*
	 * Admin gets list of users
	 */

	@GetMapping("/getall/{adminId}")
	public ResponseEntity<String> getAllUsers(@PathVariable Integer adminId)
			throws EmptyUserListException, InvalidCredentialsException, UserNotFoundException, NotLoggedInException {
		return new ResponseEntity<>(userService.getAllUsers(adminId), HttpStatus.FOUND);
	}

	/*
	 * Admin will get list of all non verified users
	 */
	@GetMapping("/getAllNonVerifiedUsers")
	public ResponseEntity<List<User>> getAllNonVerifiedUsers() throws EmptyUserListException {
		return new ResponseEntity<>(userService.getAllNotVerifiedUser(), HttpStatus.OK);
	}

	/*
	 * Admin verifies users by userId
	 */
	@PostMapping("/verify")
	public ResponseEntity<String> verifyUser(@RequestParam Integer userId, Integer adminId)
			throws InvalidCredentialsException, UserNotFoundException, NotLoggedInException {
		return new ResponseEntity<>(userService.verifyUser(userId, adminId), HttpStatus.OK);

	}

	/*
	 * User checks balance by userId and pin
	 */
	@PostMapping("/checkbalance")
	public ResponseEntity<String> checkBalance(@RequestParam Integer userId, Integer pin)
			throws InvalidCredentialsException, NotLoggedInException {
		return new ResponseEntity<>(userService.checkBalance(userId, pin), HttpStatus.OK);
	}

	/*
	 * User withdraws money by giving accountNo, amount and pin
	 */
	@PostMapping("/withdrawmoney")
	public ResponseEntity<String> withdrawMoney(@RequestParam Integer accountNo, Integer amount, Integer pin)
			throws InvalidCredentialsException, NotLoggedInException {
		return new ResponseEntity<>(userService.withdrawMoney(accountNo, amount, pin), HttpStatus.OK);
	}

	/*
	 * User tranfers money by giving account no of sender and receiver, amount and
	 * pin
	 */
	@PostMapping("/moneytransfer")
	public ResponseEntity<String> transferMoney(@RequestParam Integer accountNo, Integer receiversAccountNo,
			Integer amount, Integer pin) throws InvalidCredentialsException, NotLoggedInException {
		return new ResponseEntity<>(userService.moneyTransfer(accountNo, receiversAccountNo, amount, pin),
				HttpStatus.OK);
	}

}
