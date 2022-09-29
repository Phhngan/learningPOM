package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class TS_01_Register extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	String firstName = "Ha";
	String lastName = "Ngan";
	String email = "hngan@gmail.com";
	String password = "123456";
	String cfpassword = "123456";

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
	public void TC_01_RegisterWithEmptyData() {
		registerPage.clickToRegisterButton();
//		Assert.assertTrue(registerPage.checkFirstnameErrorMessage("First name is required."));
//		Assert.assertTrue(registerPage.checkLastnameErrorMessage("Last name is required."));
//		Assert.assertTrue(registerPage.checkEmailErrorMessage("Email is required."));
//		Assert.assertTrue(registerPage.checkPasswordErrorMessage("Password is required."));
//		Assert.assertTrue(registerPage.checkConfirmPasswordErrorMessage("Password is required."));
//		sleepInSecond(3);
		Assert.assertTrue(registerPage.checkErrorMessage("FirstName", "First name is required."));
        Assert.assertTrue(registerPage.checkErrorMessage("LastName", "Last name is required."));
        Assert.assertTrue(registerPage.checkErrorMessage("Email", "Email is required."));
        Assert.assertTrue(registerPage.checkErrorMessage("Password", "Password is required."));
        Assert.assertTrue(registerPage.checkErrorMessage("ConfirmPassword", "Password is required."));
	}

	@Test
	public void TC_02_RegisterWithInvalidEmail() {
		registerPage.refeshCurrentPage(driver);
		registerPage.enterTextToTextBox("Email","abcxyz");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.checkErrorMessage("Email","Wrong email"));
	}
	
	@Test
	public void TC_03_RegisterSuccess() {
		registerPage.refeshCurrentPage(driver);
//		registerPage.enterTextToFirstNameBox(firstName);
//		registerPage.enterTextToLastNameBox(lastName);
//		registerPage.enterTextToEmailBox(email);
//		registerPage.enterTextToPasswordBox(password);
//		registerPage.enterTextToConfirmPasswordBox(cfpassword);
		registerPage.enterTextToTextBox("FirstName", firstName);
		registerPage.enterTextToTextBox("LastName", lastName);
		registerPage.enterTextToTextBox("Email", email);
		registerPage.enterTextToTextBox("Password", password);
		registerPage.enterTextToTextBox("ConfirmPassword", cfpassword);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.checkResultMessage("Your registration completed"));
		registerPage.clickToLogOutButton();
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
	}
	
	@Test
	public void TC_04_RegisterWithExistEmail() {
		registerPage.refeshCurrentPage(driver);
//		registerPage.enterTextToFirstNameBox(firstName);
//		registerPage.enterTextToLastNameBox(lastName);
//		registerPage.enterTextToEmailBox(email);
//		registerPage.enterTextToPasswordBox(password);
//		registerPage.enterTextToConfirmPasswordBox(cfpassword);
		registerPage.enterTextToTextBox("FirstName", firstName);
		registerPage.enterTextToTextBox("LastName", lastName);
		registerPage.enterTextToTextBox("Email", email);
		registerPage.enterTextToTextBox("Password", password);
		registerPage.enterTextToTextBox("ConfirmPassword", cfpassword);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.checkExistEmailtMessage("The specified email already exists"));
	}
	
	@Test 
	public void TC_05_PasswordLessThan6Characters() {
		registerPage.refeshCurrentPage(driver);
//		registerPage.enterTextToFirstNameBox(firstName);
//		registerPage.enterTextToLastNameBox(lastName);
//		registerPage.enterTextToEmailBox(email);
//		registerPage.enterTextToPasswordBox("123");
//		registerPage.enterTextToConfirmPasswordBox("123");
		registerPage.enterTextToTextBox("FirstName", firstName);
		registerPage.enterTextToTextBox("LastName", lastName);
		registerPage.enterTextToTextBox("Email", email);
		registerPage.enterTextToTextBox("Password", "123");
		registerPage.enterTextToTextBox("ConfirmPassword", "123");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.checkErorPasswordMessage("Password must meet the following rules:"));
		Assert.assertTrue(registerPage.checkErorPasswordMessage("must have at least 6 characters"));
	}
	
	@Test
	public void TC_06_PasswordNotMatch() {
		registerPage.refeshCurrentPage(driver);
//		registerPage.enterTextToFirstNameBox(firstName);
//		registerPage.enterTextToLastNameBox(lastName);
//		registerPage.enterTextToEmailBox(email);
//		registerPage.enterTextToPasswordBox(password);
//		registerPage.enterTextToConfirmPasswordBox("112233");
		registerPage.enterTextToTextBox("FirstName", firstName);
		registerPage.enterTextToTextBox("LastName", lastName);
		registerPage.enterTextToTextBox("Email", email);
		registerPage.enterTextToTextBox("Password", password);
		registerPage.enterTextToTextBox("ConfirmPassword", "112233");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.checkNotMatchPasswordMessage("The password and confirmation password do not match."));
	}
}