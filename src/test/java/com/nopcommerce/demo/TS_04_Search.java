package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.SearchPageObject;

public class TS_04_Search extends BaseTest {
	WebDriver driver;
	SearchPageObject searchPage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		String urlPage = "https://demo.nopcommerce.com/search";
		driver = getBrowserDriver(urlPage, browserName);
		searchPage = new SearchPageObject(driver);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void TC_01_SearchWithEmptyData() {
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.checkSearchErrorMessage("Search term minimum length is 3 characters"));
	}

	@Test
	public void TC_02_SearchWithNotExistData() {
		searchPage.refeshCurrentPage(driver);
		searchPage.enterTextToSearch("Macbook Pro 2040");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.checkNoResult("No products were found that matched your criteria."));
	}
	
//	@Test
	public void TC_03_SearchLenovo() {
		searchPage.refeshCurrentPage(driver);
		searchPage.enterTextToSearch("Lenovo");
	}
	
	@Test
	public void TC_04_AdvancedSearchWithParentCategory() {
		searchPage.refeshCurrentPage(driver);
		searchPage.enterTextToSearch("Apple Macbook Pro");
		searchPage.clickToAdvCheckBox();
		searchPage.selectCategory("Computers");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.checkNoResult("No products were found that matched your criteria."));
	}
	
	@Test
	public void TC_05_AdvancedSearchWithSubCategory() {
		searchPage.refeshCurrentPage(driver);
		searchPage.enterTextToSearch("Apple Macbook Pro");
		searchPage.selectCategory("Computers");
		searchPage.clickToAutoSearchSubCheckBox();
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.checkDisplayItems("Apple MacBook Pro"));
	}
}
