package com.bmsrestfulapi.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmsrestfulapi.entities.AccountInfo;
import com.bmsrestfulapi.entities.Login;
import com.bmsrestfulapi.entities.User;
import com.bmsrestfulapi.exceptions.InvalidCredentialsException;
import com.bmsrestfulapi.exceptions.InvalidLoginCredentialsException;
import com.bmsrestfulapi.exceptions.UserNotCreatedException;
import com.bmsrestfulapi.exceptions.UserNotVerifiedException;
import com.bmsrestfulapi.repositories.AccountInfoRepository;
import com.bmsrestfulapi.repositories.LoginRepository;
import com.bmsrestfulapi.repositories.RoleRepository;
import com.bmsrestfulapi.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private AccountInfoRepository accountInfoRepository;
	
	
	

	@Override
	public List<User> getAllNotVerifiedUser() {
		return userRepository.getNotVerifiedUsers();
	}

	@Override
	public String createUser(User user) throws UserNotCreatedException {
		if (userRepository.existsById(user.getUserId())) {
			throw new UserNotCreatedException("Error creating user!'\n'User already exist.");
		} else if (user.getName().equals(UserService.STRING) || user.getAddress().equals(UserService.STRING) || user.getContactNo() == 0
				|| user.getGender().equals(UserService.STRING) || user.getPin() == 0) {
			throw new UserNotCreatedException("Error creating user!'\n'Please check details.");

		} else {
			User u = userRepository.save(user);
			u.getLogin().setAccountNo(u.getAccountList().get(0).getAccountNo());
			return "User created Successfully\nDetails:\n" + user;
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

	@Override
	public String verifyUser(Integer userId) {
		Login login = loginRepository.getLoginById(userId);
		login.setVerified(true);
		return " User verified Successfully.";
	}

	@Override
	public String adminLogin(Integer accountNo, String password)
			throws InvalidLoginCredentialsException, UserNotVerifiedException {
		Login login = loginRepository.getCredentials(accountNo, password);
		if (login != null) {
			Integer userId = accountInfoRepository.getUserIdByAccountNot(accountNo);
			String role = roleRepository.getRole(userId).toLowerCase();
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

	@Override
	public String checkBalance(Integer pin, Integer userId) throws InvalidCredentialsException {
		User user = userRepository.getPin(pin, userId);
		if (user != null && user.getPin().equals(pin) && user.getUserId().equals(userId)) {
			return "Your current balance is: " + accountInfoRepository.getBalance(userId);
		} else
			throw new InvalidCredentialsException("Please check your pin and user id");
	}

	@Override
	public String withdrawMoney(Integer pin, Integer amount, Integer accountNo) throws InvalidCredentialsException {
		User user = userRepository.verifyPin(pin);
		AccountInfo accountInfo = accountInfoRepository.getAccountNo(accountNo);
		if (user != null && accountInfo != null && user.getPin().equals(pin)
				&& accountInfo.getAccountNo().equals(accountNo)) {
			Integer availableBalance = accountInfo.getCurrentBalance();
			if (amount <= availableBalance) {
				availableBalance -= amount;
				accountInfo.setCurrentBalance(availableBalance);
				accountInfoRepository.save(accountInfo);
				return "Money Withdrawn Successfully! \nYour available balance is: " + availableBalance;
			} else {
				return "Insufficient Balance";
			}
		} else {
			throw new InvalidCredentialsException("Please check your pin and account number");
		}
	}

	@Override
	public String moneyTransfer(Integer pin, Integer amount, Integer accountNo, Integer receiversAccountNo)
			throws InvalidCredentialsException {
		User user = userRepository.verifyPin(pin);
		AccountInfo accountInfo = accountInfoRepository.getAccountNo(accountNo);
		AccountInfo receiverAccountInfo = accountInfoRepository.getAccountNo(receiversAccountNo);

		if (user != null && accountInfo != null && receiverAccountInfo != null && user.getPin().equals(pin)
				&& accountInfo.getAccountNo().equals(accountNo)
				&& receiverAccountInfo.getAccountNo().equals(receiversAccountNo)) {
			Integer availableBalance = accountInfo.getCurrentBalance();
			Integer receiversAvailableBalance = receiverAccountInfo.getCurrentBalance();
			if (amount <= availableBalance) {
				availableBalance -= amount;
				accountInfo.setCurrentBalance(availableBalance);
				accountInfoRepository.save(accountInfo);

				receiversAvailableBalance += amount;
				receiverAccountInfo.setCurrentBalance(receiversAvailableBalance);
				accountInfoRepository.save(receiverAccountInfo);
				return "Money Transfered Successfully! \nYour current balance is: " + availableBalance;
			} else {
				return "Insufficient Balance";
			}
		} else {
			throw new InvalidCredentialsException("Please enter valid credentials");
		}
	}

}
