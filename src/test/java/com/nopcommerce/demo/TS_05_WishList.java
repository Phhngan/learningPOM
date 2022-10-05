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
import pageObjects.WishListObject;

public class TS_05_WishList extends BaseTest{
	WebDriver driver;
	WishListObject wishlishPage;
	LoginPageObject loginPage;
	HomePageObject homePage;
	ShoppingCartObject shoppingCart;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		String urlPage = "https://demo.nopcommerce.com/wishlist";
		driver = getBrowserDriver(urlPage, browserName);
		loginPage = new LoginPageObject(driver);
		wishlishPage = new WishListObject(driver);
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
		homePage = new HomePageObject(driver);
		homePage.clickToProduct();
	}
	@Test
	public void TC_01_AddProductToWishlist() {
		homePage = new HomePageObject(driver);
		homePage.addToWishlist();
		homePage.checkAddToWishlistSuccess("The product has been added to your ");
		homePage.checkAddToWishlistSuccess("wishlist");
		homePage.clickToClose();
		homePage.clickToWishlistLink();
		Assert.assertTrue(wishlishPage.checkProductInWishlist(productName));
	}
	
	@Test
	public void TC_02_AddProductToShoppingCart() {
		wishlishPage.refeshCurrentPage(driver);
		wishlishPage.clickToAddToCartCheckBox();
		wishlishPage.clickToAddToCartButton();
		shoppingCart = new ShoppingCartObject(driver);
		Assert.assertTrue(shoppingCart.checkProductInCart(productName));
		shoppingCart.clickToWishlistLink();
		Assert.assertTrue(wishlishPage.checkWishlistEmpty("The wishlist is empty!"));
	}
	
}
