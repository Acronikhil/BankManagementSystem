package com.bmsrestfulapi.services;

import com.bmsrestfulapi.exceptions.InvalidCredentialsException;

/*all user operations*/
public interface RoleService {

	/*
	 * Assigning role to user (only admin can perform this operation). Requires
	 * userId, Role (to assign to user)
	 */
	public String assignRole(Integer userId, String value) throws InvalidCredentialsException;
}
