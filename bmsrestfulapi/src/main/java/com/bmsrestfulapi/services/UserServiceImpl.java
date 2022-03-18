package com.bmsrestfulapi.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmsrestfulapi.entities.Login;
import com.bmsrestfulapi.entities.User;
import com.bmsrestfulapi.exceptions.InvalidLoginCredentialsException;
import com.bmsrestfulapi.exceptions.UserNotCreatedException;
import com.bmsrestfulapi.exceptions.UserNotVerifiedException;
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
	public String createUser(User user) throws UserNotCreatedException {
		if (userRepository.existsById(user.getUserId())) {
			throw new UserNotCreatedException("Error creating user!\nUser already exist.");
		} else if (user.getName().equals("string") || user.getAddress().equals("string") || user.getContactNo() == 0
				|| user.getGender().equals("string") || user.getPin() == 0 || user == null) {
			throw new UserNotCreatedException("Error creating user!\nPlease check details.");

		} else {
			User u = userRepository.save(user);
			return "User created Successfully/nDetails:\n" + user;
		}
	}

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
}
