package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.LoginPageObject;
import common.BaseTest;
import common.GlobalConstants;

public class TS_02_Login extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		String urlPage = "https://demo.nopcommerce.com/login?returnUrl=%2F";
		driver = getBrowserDriver(urlPage, browserName);
		loginPage = new LoginPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void TC_01_LoginWithEmptyData() {
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.checkEmailErrorMessage("Please enter your email"));
	}

	@Test
	public void TC_02_LoginWithInvalidData() {
		loginPage.refeshCurrentPage(driver);
		loginPage.enterTextToEmailTextbox("hi");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.checkEmailErrorMessage("Wrong email"));
	}

	@Test
	public void TC_03_LoginWithUnregisteredEmail() {
		loginPage.refeshCurrentPage(driver);
		loginPage.enterTextToEmailTextbox("hi@yahoo.com");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage
				.checkUnregisteredEmailMessage("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.checkUnregisteredEmailMessage("No customer account found"));
	}

	@Test
	public void TC_04_RegisteredEmailAndEmptyPass() {
		loginPage.refeshCurrentPage(driver);
		loginPage.enterTextToEmailTextbox(GlobalConstants.email);
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage
				.checkUnregisteredEmailMessage("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.checkUnregisteredEmailMessage("The credentials provided are incorrect"));
	}

	@Test
	public void TC_05_RegisteredEmailAndIncorrectPass() {
		loginPage.refeshCurrentPage(driver);
		loginPage.enterTextToEmailTextbox(GlobalConstants.email);
		loginPage.enterPasswordToTextbox("888888");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage
				.checkUnregisteredEmailMessage("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.checkUnregisteredEmailMessage("The credentials provided are incorrect"));
	}

	@Test
	public void TC_06_LoginSuccess() {
		loginPage.refeshCurrentPage(driver);
		loginPage.enterTextToEmailTextbox(GlobalConstants.email);
		loginPage.enterPasswordToTextbox("123456");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.checkLoginSuccess("https://demo.nopcommerce.com/"));

	}
}
