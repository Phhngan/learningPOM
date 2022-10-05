package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.WishListUI;

public class WishListObject extends BasePage {
	WebDriver driver;

	// constructor
	public WishListObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkProductInWishlist(String value) {
		String productName = getTextOfElement(driver, WishListUI.PRODUCT_NAME);
		return productName.equals(value);
	}

	public void clickToAddToCartCheckBox() {
		waitForElementClickable(driver, WishListUI.ADD_TO_CART_CHECKBOX);
		clickToElement(driver, WishListUI.ADD_TO_CART_CHECKBOX);
	}

	public void clickToAddToCartButton() {
		waitForElementClickable(driver, WishListUI.ADD_TO_CLASS_BUTTON);
		clickToElement(driver, WishListUI.ADD_TO_CLASS_BUTTON);
	}

	public boolean checkWishlistEmpty(String value) {
		String message = getTextOfElement(driver, WishListUI.EMPTY_WISHLIST_MESSAGE);
		return message.equals(value);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, WishListUI.LOGIN_LINK);
		clickToElement(driver, WishListUI.LOGIN_LINK);
	}
}
