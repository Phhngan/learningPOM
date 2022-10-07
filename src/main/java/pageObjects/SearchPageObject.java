package pageObjects;


import org.openqa.selenium.WebDriver;

import common.BasePage;

import pageUIs.SearchPageUI;

public class SearchPageObject extends BasePage {
	WebDriver driver;

	// constructor
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}

	public boolean checkSearchErrorMessage(String value) {
		String errorMessage = getTextOfElement(driver, SearchPageUI.SEARCH_ERROR_MESSAGE);
		return errorMessage.equals(value);
	}

	public void enterTextToSearch(String value) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_INPUT);
		sendKeysToElement(driver, SearchPageUI.SEARCH_INPUT, value);
	}

	public boolean checkNoResult(String value) {
		String result = getTextOfElement(driver, SearchPageUI.NO_RESULT);
		return result.equals(value);
	}
//	public boolean checkProductTitle(String value) {
//		String productTitle = getTextOfElements(driver, SearchPageUI.NO_RESULT);
//		return productTitle.contains(value);
//	}
	
	public void clickToAdvCheckBox() {
		waitForElementClickable(driver, SearchPageUI.ADVANCED_SEARCH);
		clickToElement(driver, SearchPageUI.ADVANCED_SEARCH);
	}
	public void clickToAutoSearchSubCheckBox() {
		waitForElementClickable(driver, SearchPageUI.AUTO_SEARCH_SUB_CATEGORY);
		clickToElement(driver, SearchPageUI.AUTO_SEARCH_SUB_CATEGORY);
	}
	public void selectCategory(String text) {
		waitForElementVisible(driver, SearchPageUI.CATEGORY);
		selectDropdown(driver, SearchPageUI.CATEGORY, text);
	}
	public boolean checkDisplayItems(String value) {
		waitForElementVisible(driver, SearchPageUI.PRODUCT_TITLE);
		String productTitle = getTextOfElement(driver, SearchPageUI.PRODUCT_TITLE);
		return productTitle.contains(value);
	}
	
	public boolean isSearchProductTitleDisplayedOnPageAsExpected(String value) {
		return isTitleDisplayedOnPage(driver, SearchPageUI.PRODUCT_TITLE, value);
	}
}
