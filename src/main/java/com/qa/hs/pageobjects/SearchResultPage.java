package com.qa.hs.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.hs.BusinessComponent.BusinessComponents;

public class SearchResultPage extends BusinessComponents{
	
	WebDriver driver;

	public SearchResultPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='search-result']//a")
	List<WebElement> searchResultLinks;
	
	@FindBy(xpath = "//h1[@class='resource-title' or @class='post-title']")
	WebElement title;
	
    @FindBy(css = ".results")
    WebElement result;
	
	public void  openallSearchLinks() throws InterruptedException {
		
		for(int i = 0; i <searchResultLinks.size(); i++) {
			String linkText = searchResultLinks.get(i).getText();
			scrollToElement(searchResultLinks.get(i));
			Thread.sleep(3000);
			searchResultLinks.get(i).click();
			Thread.sleep(3000);
			title.getText();
			Assert.assertEquals(title.getText(), linkText);
			System.out.println("Opened search result successfully");
			driver.navigate().back();
			Thread.sleep(3000);
		}
	}
	
	public String verifySearchLabel() {
		
		return result.getText();
	}

}
