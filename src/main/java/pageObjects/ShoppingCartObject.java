package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;

import pageUIs.ShoppingCartUI;

public class ShoppingCartObject extends BasePage {
	WebDriver driver;

	// constructor
	public ShoppingCartObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkProductInCart(String value) {
		String productName = getTextOfElement(driver, ShoppingCartUI.PRODUCT_NAME);
		return productName.equals(value);
	}

	public void clickToWishlistLink() {
		waitForElementClickable(driver, ShoppingCartUI.WISHLIST_LINK);
		clickToElement(driver, ShoppingCartUI.WISHLIST_LINK);
	}

	public void enterQuantity(String value) {
		waitForElementVisible(driver, ShoppingCartUI.INPUT_QUANTITY);
		doubleClickToElement(driver, ShoppingCartUI.INPUT_QUANTITY);
		sendKeysToElement(driver, ShoppingCartUI.INPUT_QUANTITY, value);
	}

	public void clickToUpdateCartButton() {
		waitForElementClickable(driver, ShoppingCartUI.UPDATE_SHOPPING_CART_BUTTON);
		clickToElement(driver, ShoppingCartUI.UPDATE_SHOPPING_CART_BUTTON);
	}

	public boolean checkQuantity(String value) {
		String quantity = getAttributeValue(driver, ShoppingCartUI.INPUT_QUANTITY, "value");
		return quantity.equals(value);
	}

	public void clickToRemoveProductButton() {
		waitForElementClickable(driver, ShoppingCartUI.REMOVE_PRODUCT_BUTTON);
		clickToElement(driver, ShoppingCartUI.REMOVE_PRODUCT_BUTTON);
	}

	public boolean checkEmptyCart(String value) {
		waitForElementVisible(driver, ShoppingCartUI.EMPTY_CART_MESSAGE);
		String quantity = getTextOfElement(driver, ShoppingCartUI.EMPTY_CART_MESSAGE, "value");
		return quantity.equals(value);
	}

}
