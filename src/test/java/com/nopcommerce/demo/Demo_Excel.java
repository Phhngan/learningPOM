package com.nopcommerce.demo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import utils.ExcelUtil;

public class Demo_Excel extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;

	@Parameters({ "browser" })
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
	public void TC_01_LoginWithExcelData() throws IOException {
//		loginPage.refeshCurrentPage(driver);
//		loginPage.enterTextToEmailTextbox(GlobalConstants.email);
//		loginPage.enterPasswordToTextbox("123456");
//		loginPage.clickToLoginButton();
//		Assert.assertTrue(loginPage.checkLoginSuccess("https://demo.nopcommerce.com/"));

		ExcelUtil.setExcelFile("Sheet1");
		for (int i = 1; i <= ExcelUtil.getRowCountInSheet(); i++) {
			String excelUserName = ExcelUtil.getCellData(i, 0);
			String excelPassword = ExcelUtil.getCellData(i, 1);

			System.out.println("Account using: " + excelUserName + "," + excelPassword);

			loginPage.refeshCurrentPage(driver);
			loginPage.enterTextToEmailTextbox(excelUserName);
			;
			loginPage.enterPasswordToTextbox(excelPassword);
			homePage = new HomePageObject(driver);
			loginPage.clickToLoginButton();

//        Assert.assertEquals(homePage.getPageUrl(driver), "https://demo.nopcommerce.com/");

			String homePageUrl = homePage.getPageUrl(driver);
			if (homePageUrl.equals("https://demo.nopcommerce.com/")) {
				ExcelUtil.setCellData("Pass", i, 2);
			} else {
				ExcelUtil.setCellData("Fail", i, 2);
			}
		}
	}
}
