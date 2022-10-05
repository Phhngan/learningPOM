package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	// constructor
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	}

	public void clickToProduct() {
		waitForElementClickable(driver, HomePageUI.PRODUCT);
		clickToElement(driver, HomePageUI.PRODUCT);
	}

	public void addToWishlist() {
		waitForElementClickable(driver, HomePageUI.ADD_TO_WISHLIST);
		clickToElement(driver, HomePageUI.ADD_TO_WISHLIST);
	}

	public boolean checkAddToWishlistSuccess(String value) {
		String message = getTextOfElement(driver, HomePageUI.ADD_TO_WISHLIST_SUCCESS_NOTI);
		return message.contains(value);
	}

	public void clickToClose() {
		waitForElementClickable(driver, HomePageUI.CLOSE_NOTI);
		clickToElement(driver, HomePageUI.CLOSE_NOTI);
	}

	public void clickToWishlistLink() {
		waitForElementClickable(driver, HomePageUI.WISHLIST_LINK);
		clickToElement(driver, HomePageUI.WISHLIST_LINK);
	}

	public void addToCart() {
		waitForElementClickable(driver, HomePageUI.ADD_TO_CART);
		clickToElement(driver, HomePageUI.ADD_TO_CART);
	}
	public void clickToCartLink() {
		waitForElementClickable(driver, HomePageUI.SHOPPING_CLASS_LINK);
		clickToElement(driver, HomePageUI.SHOPPING_CLASS_LINK);
	}

}
