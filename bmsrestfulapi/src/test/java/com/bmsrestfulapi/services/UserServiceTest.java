package com.bmsrestfulapi.services;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bmsrestfulapi.entities.AccountInfo;
import com.bmsrestfulapi.entities.Login;
import com.bmsrestfulapi.entities.Role;
import com.bmsrestfulapi.entities.User;
import com.bmsrestfulapi.exceptions.EmptyUserListException;
import com.bmsrestfulapi.exceptions.InvalidCredentialsException;
import com.bmsrestfulapi.exceptions.UserNotCreatedException;
import com.bmsrestfulapi.repositories.UserRepository;

@SpringBootTest
class UserServiceTest {

	@Autowired
	UserService userService;
	@Autowired
	LoginService loginService;

	@Autowired
	UserRepository userRepository;

	private final User user = new User(8, "Indore", "abcJuintTest", 123, LocalDate.now(), 8962132378L, "female");

	@BeforeEach
	void setUp() {
		Role r = new Role(user);
		AccountInfo ai = new AccountInfo(user);
		List<AccountInfo> accountList = new ArrayList<>();
		accountList.add(ai);
		Login l = new Login(user, ai);

		l.setVerified(true);
		user.setRole(r);
		user.setLogin(l);
		user.setAccountList(accountList);

		User u = userRepository.save(user);
		u.getLogin().setAccountNo(u.getAccountList().get(0).getAccountNo());

		System.out.println("--------------------\n" + u.getLogin() + "--------------" + u.getAccountList());
	}

	@Test
	void createUserTest() throws UserNotCreatedException {
		assertThrows(UserNotCreatedException.class, () -> userService.createUser(user));
	}

	@Test
	void checkBalanceTest() throws InvalidCredentialsException {

		assertThrows(InvalidCredentialsException.class, () -> userService.checkBalance(123, 0));

	}

	@Test
	void withdrawMoneyTest() throws InvalidCredentialsException {

		assertThrows(InvalidCredentialsException.class, () -> userService.withdrawMoney(121, 500, 0));

	}

	@Test
	void moneyTransferTest() throws InvalidCredentialsException {
		assertThrows(InvalidCredentialsException.class, () -> userService.moneyTransfer(421, 500, 0, 546));
	}

	@Test
	void getAllNotVerifiedUsersTest() throws EmptyUserListException {
		assertThrows(EmptyUserListException.class, () -> userService.getAllNotVerifiedUser());
	}

	@AfterEach
	void tearDown() {
		System.out.println("Tearing Down");
		userRepository.deleteAll();
	}

}
