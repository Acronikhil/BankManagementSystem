package com.bmsrestfulapi.exceptions;

/*contains all the messages showed in exceptions*/
public class CustomExceptionsMessages {

	public static final String YOU_ARE_NOT_ADMIN_EXCEPTION = "You are not an Admin \nCan't delete user.";
	
	public static final String YOU_ARE_NOT_ADMIN_CANT_UPDATE_USER = "You are not an Admin \nCan't update user.";

	public static final String NO_USER_EXISTS_WITH_THIS_ID = "No user exist with this Id";

	public static final String NO_USER_EXIST_IN_DATABASE = "No user exist in database";

	public static final String PLEASE_ENTER_VALID_CREDENTIALS = "Please enter valid credentials";

	public static final String PLEASE_CHECK_YOUR_PIN_AND_ACCOUNT_NUMBER = "Please check your pin and account number";

	public static final String PLEASE_CHECK_YOUR_PIN_AND_USER_ID = "Please check your pin and user id";

	public static final String PLEASE_CHECK_DETAILS = "Error creating user!\nPlease check details.";

	public static final String USER_ALREADY_EXIST_WITH_SAME_CONTACT_NO = "Error creating user!\nUser already exist with same contact no.";

	public static final String USER_ALREADY_EXIST = "Error creating user!\nUser already exist.";

	public static final String EVERYONE_ALREADY_VERIFIED = "All users are already verified.";

	public static final String PLEASE_ENTER_VALID_ROLE_NAME = "Please enter valid role name";

	public static final String NO_USER_WITH_THIS_NAME = "No user exist with this user number";

	public static final String WAIT_UNTIL_ADMIN_VERIFIES = "You are not verified, Please wait until Admin verifies you.";

	public static final String PLEASE_CHECK_YOUR_LOGIN_CREDENTIALS = "Please check your Login Credentials!";

	public static final String YOU_ARE_NOT_ADMIN_CONTACT_TO_BM = "You are not admin, Please contact with BM.";

	public static final String NO_USER_WITH_THIS_ACCOUNT_NUMER = "No user exist with this account number";
	
	public static final String 	CANT_ADD_MONEY= "You are not an Admin \nCan't perform this action";
	
	public static final String NO_ADMIN_EXIST_BY_ID= "No admin exist with this Id";
	private CustomExceptionsMessages() {
	}

}
