package com.bmsrestfulapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bmsrestfulapi.exceptions.InvalidCredentialsException;
import com.bmsrestfulapi.services.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	/*
	 * Assigning role as admin to the user 
	 */
	@PostMapping("/assignrole")
	public ResponseEntity<String> assignRole(@RequestParam Integer userId, String value)
			throws InvalidCredentialsException {
		return new ResponseEntity<>(roleService.assignRole(userId, value), HttpStatus.OK);
	}
}
