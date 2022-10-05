package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	// constructor
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}
	public boolean checkEmailErrorMessage(String value) {
		String errorMessage = getTextOfElement(driver, LoginPageUI.EMAIL_EMPTY_MESSAGE);
		return errorMessage.equals(value);
	}
	
	public void enterTextToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}
	
	public boolean checkErrorMessage(String value) {
		String errorMessage = getTextOfElement(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return errorMessage.contains(value);
	}
	
	public void enterPasswordToTextbox(String pass) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, pass);
	}
	
	public boolean checkLoginSuccess(String url) {
		waitForElementVisible(driver, HomePageUI.WELCOME_TEXT);
		String pageURL =  getPageUrl(driver);
		return pageURL.equals(url);
	}
}
