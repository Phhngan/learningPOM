package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.ChangePassPageUI;

public class ChangePassObject extends BasePage {
	WebDriver driver;

	// constructor
	public ChangePassObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterTextToTextBox(String value, String textboxID) {
		waitForElementVisible(driver, ChangePassPageUI.PASSWORD_TEXTBOX, textboxID);
		sendKeysToElement(driver, ChangePassPageUI.PASSWORD_TEXTBOX, value, textboxID);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, ChangePassPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, ChangePassPageUI.CHANGE_PASSWORD_BUTTON);
	}

	public void clickToCloseStatus() {
		waitForElementClickable(driver, ChangePassPageUI.CLOSE_STATUS);
		clickToElement(driver, ChangePassPageUI.CLOSE_STATUS);
	}
	
	public void clickToLogOutLink() {
		waitForElementClickable(driver, ChangePassPageUI.LOGOUT_LINK);
		clickToElement(driver, ChangePassPageUI.LOGOUT_LINK);
	}
}
