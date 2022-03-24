package com.bmsrestfulapi.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmsrestfulapi.entities.Login;
import com.bmsrestfulapi.entities.Role;
import com.bmsrestfulapi.exceptions.CustomExceptionsMessages;
import com.bmsrestfulapi.exceptions.InvalidCredentialsException;
import com.bmsrestfulapi.repositories.LoginRepository;
import com.bmsrestfulapi.repositories.RoleRepository;
import com.bmsrestfulapi.repositories.UserRepository;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public String assignRole(Integer userId, String value) throws InvalidCredentialsException {
		Role role = roleRepository.getRoleObject(userId);
		Login login = loginRepository.getLoginById(userId);
		String roleName = value.toLowerCase();
		if (role != null && userRepository.existsById(userId)) {
		    if (roleName.equals("user") || roleName.equals("admin")) {
		          role.setRoleName(roleName);
		          if(roleName.equals("admin"))
		          {  
		      		login.setVerified(true);
		          }
		          return "Role is assigned successfully!";
		    }
		    else {
		    	throw new InvalidCredentialsException(CustomExceptionsMessages.PLEASE_ENTER_VALID_ROLE_NAME);
		    }
		    
		}else {
			throw new InvalidCredentialsException(CustomExceptionsMessages.NO_USER_WITH_THIS_NAME);
		}
	}
    
	
}
