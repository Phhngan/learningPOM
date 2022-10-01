package pageObjects;

import org.openqa.selenium.WebDriver;
import common.BasePage;
import pageUIs.AddressesUI;


public class AddressesObject extends BasePage {
	WebDriver driver;

	// constructor
	public AddressesObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddNewAddress() {
		waitForElementClickable(driver, AddressesUI.ADD_NEW_BUTTON);
		clickToElement(driver, AddressesUI.ADD_NEW_BUTTON);
	}

	public void enterTextToTextBox(String value, String textboxID) {
		waitForElementVisible(driver, AddressesUI.ADDRESS_INPUT, textboxID);
		sendKeysToElement(driver, AddressesUI.ADDRESS_INPUT, value, textboxID);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, AddressesUI.SAVE_BUTTON);
		clickToElement(driver, AddressesUI.SAVE_BUTTON);
	}

	public void selectCountry(String country) {
		waitForElementVisible(driver, AddressesUI.SELECT_COUNTRY);
		selectDropdown(driver, AddressesUI.SELECT_COUNTRY, country);
	}
	
	public void selectState(String state) {
		waitForElementVisible(driver, AddressesUI.SELECT_STATE);
		selectDropdown(driver, AddressesUI.SELECT_STATE, state);
	}
	public boolean addSuccess(String email) {
		 String check = getTextOfElement(driver, AddressesUI.EMAIL_ADDRESS);
		 return check.contains(email);
	}
	public void clickToChangePasswordLink() {
		waitForElementClickable(driver, AddressesUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, AddressesUI.CHANGE_PASSWORD_LINK);
	}
}
