package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.RegisterPageObject;
import common.BaseTest;
import common.GlobalConstants;

public class TS_00_Precondition extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;

	@BeforeClass
	public void beforeClass() {
		String urlPage = "https://demo.nopcommerce.com/register?returnUrl=%2F";
		driver = getBrowserDriver(urlPage);
		registerPage = new RegisterPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void TC_00_CreateAccountForTesting() {
		registerPage.enterTextToTextBox("FirstName", GlobalConstants.firstName);
		registerPage.enterTextToTextBox("LastName", GlobalConstants.lastName);
		registerPage.enterTextToTextBox("Email", GlobalConstants.email);
		registerPage.enterTextToTextBox("Password", GlobalConstants.password);
		registerPage.enterTextToTextBox("ConfirmPassword", GlobalConstants.password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.checkResultMessage("Your registration completed"));
		registerPage.clickToLogOutButton();
	}

}
