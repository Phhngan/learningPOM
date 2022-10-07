package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalConstants;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class TS_01_Register extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	HomePageObject homePage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		String urlPage = "https://demo.nopcommerce.com/register?returnUrl=%2F";
		driver = getBrowserDriver(urlPage, browserName);
		registerPage = new RegisterPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void TC_01_RegisterWithEmptyData() {
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.checkErrorMessage("FirstName", "First name is required."));
		Assert.assertTrue(registerPage.checkErrorMessage("LastName", "Last name is required."));
		Assert.assertTrue(registerPage.checkErrorMessage("Email", "Email is required."));
		Assert.assertTrue(registerPage.checkErrorMessage("Password", "Password is required."));
		Assert.assertTrue(registerPage.checkErrorMessage("ConfirmPassword", "Password is required."));
	}

	@Test
	public void TC_02_RegisterWithInvalidEmail() {
		registerPage.refeshCurrentPage(driver);
		registerPage.enterTextToTextBox("Email", "abcxyz");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.checkErrorMessage("Email", "Wrong email"));
	}

	@Test
	public void TC_03_RegisterSuccess() {
		registerPage.refeshCurrentPage(driver);
		registerPage.enterTextToTextBox("FirstName", GlobalConstants.firstName);
		registerPage.enterTextToTextBox("LastName", GlobalConstants.lastName);
		registerPage.enterTextToTextBox("Email", GlobalConstants.email);
		registerPage.enterTextToTextBox("Password", GlobalConstants.password);
		registerPage.enterTextToTextBox("ConfirmPassword", GlobalConstants.password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.checkResultMessage("Your registration completed"));
		registerPage.clickToLogOutButton();
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
	}

	@Test
	public void TC_04_RegisterWithExistEmail() {
		registerPage.refeshCurrentPage(driver);
		registerPage.enterTextToTextBox("FirstName", GlobalConstants.firstName);
		registerPage.enterTextToTextBox("LastName", GlobalConstants.lastName);
		registerPage.enterTextToTextBox("Email", GlobalConstants.email);
		registerPage.enterTextToTextBox("Password", GlobalConstants.password);
		registerPage.enterTextToTextBox("ConfirmPassword", GlobalConstants.password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.checkExistEmailtMessage("The specified email already exists"));
	}

	@Test
	public void TC_05_PasswordLessThan6Characters() {
		registerPage.refeshCurrentPage(driver);
		registerPage.enterTextToTextBox("FirstName", GlobalConstants.firstName);
		registerPage.enterTextToTextBox("LastName", GlobalConstants.lastName);
		registerPage.enterTextToTextBox("Email", GlobalConstants.email);
		registerPage.enterTextToTextBox("Password", "123");
		registerPage.enterTextToTextBox("ConfirmPassword", "123");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.checkErorPasswordMessage("Password must meet the following rules:"));
		Assert.assertTrue(registerPage.checkErorPasswordMessage("must have at least 6 characters"));
	}

	@Test
	public void TC_06_PasswordNotMatch() {
		registerPage.refeshCurrentPage(driver);
		registerPage.enterTextToTextBox("FirstName", GlobalConstants.firstName);
		registerPage.enterTextToTextBox("LastName", GlobalConstants.lastName);
		registerPage.enterTextToTextBox("Email", GlobalConstants.email);
		registerPage.enterTextToTextBox("Password", GlobalConstants.password);
		registerPage.enterTextToTextBox("ConfirmPassword", "112233");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(
				registerPage.checkNotMatchPasswordMessage("The password and confirmation password do not match."));
	}
}