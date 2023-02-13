package com.qa.hs.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hs.BusinessComponent.BusinessComponents;

public class HomeSearchPage extends BusinessComponents {
	
	WebDriver driver;
	
	public HomeSearchPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".header-search")
	WebElement search;
	
	@FindBy(id="site-search-keyword")
	WebElement sitesearch;
	
	@FindBy(css=".search-form-submit")
	WebElement searchicon;
	
	@FindBy(css=".results")
	WebElement verifyResults;
	
	
	public void clickSearch() {
		search.click();
	}
	
	public void performSearch(String keyword) throws InterruptedException {
		
		waitForElementToAppear(sitesearch);
		sitesearch.sendKeys(keyword);
		Thread.sleep(2000);
		searchicon.click();

	}
	
	public String assertSearchResults() {
		
	  String text = verifyResults.getText();
	  return text;
	
   }
	
	
}
