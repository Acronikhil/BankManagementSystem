package com.bmsrestfulapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmsrestfulapi.entities.Login;
import com.bmsrestfulapi.exceptions.CustomExceptionsMessages;
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
				throw new UserNotVerifiedException(CustomExceptionsMessages.WAIT_UNTIL_ADMIN_VERIFIES);
			}

		}
		throw new InvalidLoginCredentialsException(CustomExceptionsMessages.PLEASE_CHECK_YOUR_LOGIN_CREDENTIALS);

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
				throw new UserNotVerifiedException(CustomExceptionsMessages.YOU_ARE_NOT_ADMIN_CONTACT_TO_BM);
			}
		}
		throw new InvalidLoginCredentialsException(CustomExceptionsMessages.PLEASE_CHECK_YOUR_LOGIN_CREDENTIALS);
	}

}
