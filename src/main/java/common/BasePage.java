package common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	private WebDriverWait explicitWait;

	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void openUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void refeshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	/////////////////////////////////////////////////

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public String getTextOfElement(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}

	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}

	public void sendKeysToElement(WebDriver driver, String locator, String valueInput) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(valueInput);
	}


	public void sendEnterToElement(WebDriver driver, String locator) {
		getElement(driver, locator).sendKeys(Keys.ENTER);
	}

	//////////////////////////////////////////////////
	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.short_timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.short_timeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
	}

	//////////////////////////////////////////////////

	public String getDynamicLocator(String locator, String... params) {
		return String.format(locator, (Object[]) params);
	}

	public WebElement getElement(WebDriver driver, String locator, String... params) {
		return driver.findElement(getByXpath(getDynamicLocator(locator, params)));
	}

	public String getTextOfElement(WebDriver driver, String locator, String... params) {
		return getElement(driver, locator, params).getText();
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.short_timeout);
		explicitWait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(getDynamicLocator(locator, params))));
	}
	public void sendKeysToElement(WebDriver driver, String locator, String valueInput, String... params) {
		getElement(driver, locator, params).clear();
		getElement(driver, locator, params).sendKeys(valueInput);
	}
	public void clickToElement(WebDriver driver, String locator, String ... params) {
		getElement(driver, locator, params).click();
	}
	public void selectDropdown(WebDriver driver, String locator, String value, String...params){
		Select select = new Select(getElement(driver, locator, params));
		select.selectByVisibleText(value);
		
	}
	public String getAttributeValue(WebDriver driver, String locator, String attributeName, String ...params) {
		return getElement(driver, locator, params).getAttribute(attributeName);
	}

}
