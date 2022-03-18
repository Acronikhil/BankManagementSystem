package com.bmsrestfulapi.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmsrestfulapi.entities.Login;
import com.bmsrestfulapi.entities.User;
import com.bmsrestfulapi.exceptions.InvalidCredentialsException;
import com.bmsrestfulapi.exceptions.UserNotCreatedException;
import com.bmsrestfulapi.repositories.LoginRepository;
import com.bmsrestfulapi.repositories.UserRepository;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LoginRepository loginRepository;
	
	

	@Override
	public String createUser(User user) {
		 User u = userRepository.save(user);
		 if(u!=null) {
			 return "User created Successfully/nDetails:\n" + user;
		 }
		 return null;// will return UserNotCreatedException
	}

	@Override
	public String login(Integer accountNo, String password) throws InvalidCredentialsException {
		Login login = loginRepository.getCredentials(accountNo, password);
		if(login!=null) {
			login.setLogin(true);
			loginRepository.save(login);
		}
		throw new InvalidCredentialsException("Please check your Login Credentials!"); // will return InvalidCredentialsException
	}

}
