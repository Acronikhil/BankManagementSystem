package com.bmsrestfulapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmsrestfulapi.entities.Login;
import com.bmsrestfulapi.exceptions.InvalidLoginCredentialsException;
import com.bmsrestfulapi.exceptions.UserNotVerifiedException;
import com.bmsrestfulapi.repositories.LoginRepository;
import com.bmsrestfulapi.repositories.RoleRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public String login(Integer accountNo, String password)
			throws InvalidLoginCredentialsException, UserNotVerifiedException {
		Login login = loginRepository.getCredentials(accountNo, password);
		if (login != null) {
			if (login.isVerified()) {
				login.setLogin(true);
				loginRepository.save(login);
				return "Successful login";
			} else {
				throw new UserNotVerifiedException("You are not verified, Please wait until Admin verifies you.");
			}

		}
		throw new InvalidLoginCredentialsException("Please check your Login Credentials!");

	}

	@Override
	public String adminLogin(Integer accountNo, String password)
			throws InvalidLoginCredentialsException, UserNotVerifiedException {
		Login login = loginRepository.getCredentials(accountNo, password);
		if (login != null) {
			String role = roleRepository.getRole(login.getUser().getUserId()).toLowerCase();
			if (role.equals("admin")) {
				login.setLogin(true);
				loginRepository.save(login);
				return "Admin Successfully loggedin";
			} else {
				throw new UserNotVerifiedException("You are not admin, Please contact with BM.");
			}
		}
		throw new InvalidLoginCredentialsException("Please check your Login Credentials!");
	}

}
