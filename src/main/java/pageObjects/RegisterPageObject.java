package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	// constructor
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

//	public boolean checkFirstnameErrorMessage(String value) {
//		String errorMessage = getTextOfElement(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
//		return errorMessage.equals(value);
//	}
//
//	public boolean checkLastnameErrorMessage(String value) {
//		String errorMessage = getTextOfElement(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
//		return errorMessage.equals(value);
//	}
//
//	public boolean checkEmailErrorMessage(String value) {
//		String errorMessage = getTextOfElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
//		return errorMessage.equals(value);
//	}
//
//	public boolean checkPasswordErrorMessage(String value) {
//		String errorMessage = getTextOfElement(driver, RegisterPageUI.PASS_ERROR_MESSAGE);
//		return errorMessage.equals(value);
//	}
//
//	public boolean checkConfirmPasswordErrorMessage(String value) {
//		String errorMessage = getTextOfElement(driver, RegisterPageUI.CONFIRM_PASS_ERROR_MESSAGE);
//		return errorMessage.equals(value);
//	}

	public boolean checkResultMessage(String value) {
		String errorMessage = getTextOfElement(driver, RegisterPageUI.RESULT_MESSAGE);
		return errorMessage.equals(value);
	}

	public boolean checkExistEmailtMessage(String value) {
		String errorMessage = getTextOfElement(driver, RegisterPageUI.EXISTS_EMAIL_MESSAGE);
		return errorMessage.equals(value);
	}

	public boolean checkErorPasswordMessage(String value) {
		String errorMessage = getTextOfElement(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return errorMessage.contains(value);
	}

	public boolean checkNotMatchPasswordMessage(String value) {
		String errorMessage = getTextOfElement(driver, RegisterPageUI.PASSWORD_NOT_MATCH_MESSAGE);
		return errorMessage.equals(value);
	}

	public void enterTextToTextBox(String textboxName ,String value) {
		waitForElementVisible(driver, RegisterPageUI.INPUT_TEXTBOX, textboxName);
		sendKeysToElement(driver, RegisterPageUI.INPUT_TEXTBOX, value, textboxName);
	}

//	public void enterTextToFirstNameBox(String firstName) {
//		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
//		sendKeysToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
//	}
//
//	public void enterTextToLastNameBox(String lastName) {
//		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
//		sendKeysToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
//	}
//
//	public void enterTextToPasswordBox(String password) {
//		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
//		sendKeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
//	}
//
//	public void enterTextToConfirmPasswordBox(String cfpassword) {
//		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
//		sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, cfpassword);
//	}

	public void clickToLogOutButton() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_BUTTON);
		clickToElement(driver, RegisterPageUI.LOGOUT_BUTTON);
	}
	public boolean checkErrorMessage(String textboxName, String value) {
		 String errorMessage = getTextOfElement(driver, RegisterPageUI.ERROR_MESSAGE, textboxName);
	        return errorMessage.equals(value);
	}
}
	
	
