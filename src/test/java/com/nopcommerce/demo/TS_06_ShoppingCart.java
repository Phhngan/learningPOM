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
import pageObjects.LoginPageObject;
import pageObjects.ShoppingCartObject;

public class TS_06_ShoppingCart extends BaseTest {
	WebDriver driver;
	ShoppingCartObject shoppingCart;
	LoginPageObject loginPage;
	HomePageObject homePage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		String urlPage = "https://demo.nopcommerce.com/cart";
		driver = getBrowserDriver(urlPage, browserName);
		shoppingCart = new ShoppingCartObject(driver);
		loginPage = new LoginPageObject(driver);
		homePage = new HomePageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void TC_00_LoginSuccess() {
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		loginPage = new LoginPageObject(driver);
		loginPage.refeshCurrentPage(driver);
		loginPage.enterTextToEmailTextbox(GlobalConstants.email);
		loginPage.enterPasswordToTextbox(GlobalConstants.password);
		loginPage.clickToLoginButton();
		homePage.clickToProduct();
		homePage.addToCart();
	}

	@Test
	public void TC_01_UpdateCart() {
		homePage.clickToCartLink();
		shoppingCart.enterQuantity("5");
		shoppingCart.clickToUpdateCartButton();
		Assert.assertTrue(shoppingCart.checkQuantity("5"));
	}

	@Test
	public void TC_02_RemoveFromCart() {
		shoppingCart.refeshCurrentPage(driver);
		shoppingCart.clickToRemoveProductButton();
		Assert.assertTrue(shoppingCart.checkEmptyCart("Your Shopping Cart is empty!"));
	}
}
