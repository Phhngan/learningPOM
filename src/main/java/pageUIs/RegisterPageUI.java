package pageUIs;

public class RegisterPageUI {
	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
	
//	public static final String FIRSTNAME_ERROR_MESSAGE = "//span[@id='FirstName-error']";
//	public static final String LASTNAME_ERROR_MESSAGE = "//span[@id='LastName-error']";
//	public static final String EMAIL_ERROR_MESSAGE = "//span[@id='Email-error']";
//	public static final String PASS_ERROR_MESSAGE = "//span[@id='Password-error']";
//	public static final String CONFIRM_PASS_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error']";
	
	public static final String ERROR_MESSAGE = "//span[@id='%s-error']";
	
//	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
//	public static final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
//	public static final String LASTNAME_TEXTBOX = "//input[@id='LastName']";
//	public static final String PASSWORD_TEXTBOX ="//input[@id='Password']"; 
//	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
	
	public static final String INPUT_TEXTBOX = "//input[@id='%s']";
	
	public static final String RESULT_MESSAGE = "//div[@class='result']";
	public static final String LOGOUT_BUTTON = "//a[@class='ico-logout']";
	public static final String EXISTS_EMAIL_MESSAGE = "//div[@class='message-error validation-summary-errors']//li";
	public static final String PASSWORD_ERROR_MESSAGE = "//span[@id='Password-error']";
	public static final String PASSWORD_NOT_MATCH_MESSAGE = "//span[@id='ConfirmPassword-error']";
}
