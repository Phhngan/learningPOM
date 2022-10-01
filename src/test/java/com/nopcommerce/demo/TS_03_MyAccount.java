package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalConstants;
import pageObjects.AddressesObject;
import pageObjects.ChangePassObject;
import pageObjects.HomePageObject;
import pageObjects.MyAccountObject;


public class TS_03_MyAccount extends BaseTest {
	WebDriver driver;
	MyAccountObject myAccount;
	AddressesObject addressPage;
	ChangePassObject changePassPage;
	HomePageObject homePage;
	
	String company ="test";
	String day = "2";
	String month = "January";
	String year = "2002";

	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		String urlPage = "https://demo.nopcommerce.com/customer/info";
		driver = getBrowserDriver(urlPage, browserName);
		myAccount = new MyAccountObject(driver);
		addressPage = new AddressesObject(driver);
		changePassPage = new ChangePassObject(driver);
		homePage = new HomePageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	@Test
	public void TC_00_Login() {
		myAccount.refeshCurrentPage(driver);
		myAccount.enterTextToTextBox(GlobalConstants.email, "Email");
		myAccount.enterTextToTextBox(GlobalConstants.password, "Password");
		myAccount.clickToLoginButton();
	}
	@Test 
	public void TC_01_UpdateInfo() {
		myAccount.refeshCurrentPage(driver);
		myAccount.checkGender("female");
		myAccount.updateDateOfBirth(day, "Day");
		myAccount.updateDateOfBirth(month, "Month");
		myAccount.updateDateOfBirth(year, "Year");
		myAccount.enterTextToTextBox(company, "Company");
		myAccount.clickToSaveButton();
		Assert.assertTrue(myAccount.checkCompanyName(company));
	}
	@Test
	public void TC_02_UpdateAddress() {
		myAccount.refeshCurrentPage(driver);
		myAccount.clickToAddressLink();
		addressPage.clickToAddNewAddress();
		addressPage.enterTextToTextBox(GlobalConstants.firstName, "FirstName");
		addressPage.enterTextToTextBox(GlobalConstants.lastName, "LastName");
		addressPage.enterTextToTextBox(GlobalConstants.email, "Email");
		addressPage.selectCountry("Viet Nam");
		addressPage.selectState("Other");
		addressPage.enterTextToTextBox("Ha Noi", "City");
		addressPage.enterTextToTextBox("Linh Dam", "Address1");
		addressPage.enterTextToTextBox("00000", "ZipPostalCode");
		addressPage.enterTextToTextBox("0912345678", "PhoneNumber");
		addressPage.clickToSaveButton();
		Assert.assertTrue(addressPage.addSuccess(GlobalConstants.email));
	}
	
	@Test
	public void TC_03_ChangePassword() {
		myAccount.refeshCurrentPage(driver);
		addressPage.clickToChangePasswordLink();
		changePassPage.enterTextToTextBox(GlobalConstants.password, "Old");
		changePassPage.enterTextToTextBox(GlobalConstants.newPassword, "New");
		changePassPage.enterTextToTextBox(GlobalConstants.newPassword, "ConfirmNew");
		changePassPage.clickToSaveButton();
		changePassPage.clickToCloseStatus();
		changePassPage.clickToLogOutLink();
		homePage.clickToLoginLink();
	}
	
}
