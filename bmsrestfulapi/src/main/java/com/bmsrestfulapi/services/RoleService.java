package com.bmsrestfulapi.services;

import com.bmsrestfulapi.exceptions.InvalidCredentialsException;

public interface RoleService {

	public String assignRole (Integer userId, String value) throws InvalidCredentialsException;
}
