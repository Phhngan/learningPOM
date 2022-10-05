package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.LoginPageUI;
import pageUIs.MyAccountUI;



public class MyAccountObject extends BasePage {
	WebDriver driver;

	// constructor
	public MyAccountObject(WebDriver driver) {
		this.driver = driver;
	}

	public void checkGender(String gender) {
		waitForElementVisible(driver, MyAccountUI.GENDER, gender);
		clickToElement(driver, MyAccountUI.GENDER, gender);
	}

	public void updateDateOfBirth(String value, String dropDownName) {
		waitForElementVisible(driver, MyAccountUI.DATE_OF_BIRTH, dropDownName);
		selectDropdown(driver, MyAccountUI.DATE_OF_BIRTH, value, dropDownName);
	}
	public void enterTextToTextBox(String value, String textboxID) {
		waitForElementVisible(driver, MyAccountUI.INPUT_TEXTBOX, textboxID);
		sendKeysToElement(driver, MyAccountUI.INPUT_TEXTBOX, value, textboxID);
	}
	public void clickToSaveButton() {
		waitForElementClickable(driver, MyAccountUI.SAVE_BUTTON);
		clickToElement(driver, MyAccountUI.SAVE_BUTTON);
	}
	public boolean checkCompanyName(String value) {
		 String check = getAttributeValue(driver, MyAccountUI.INPUT_TEXTBOX, "value", "Company");
		 return check.equals(value);
	}
	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}
	public void clickToAddressLink() {
		waitForElementClickable(driver, MyAccountUI.ADDRESS_LINK);
		clickToElement(driver, MyAccountUI.ADDRESS_LINK);
	}
	
}
