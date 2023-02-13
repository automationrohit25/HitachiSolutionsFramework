package com.qa.hs.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hs.BaseTest.BasePage;
import com.qa.hs.pageobjects.HomeSearchPage;
import com.qa.hs.pageobjects.SearchResultPage;

public class SearchKeywordTest extends BasePage{
	
	@Test
	public void searchTest() throws IOException, InterruptedException {
		
		String keyword = "Construction";
		HomeSearchPage searchPage = new HomeSearchPage(driver);
		searchPage.clickSearch();
		searchPage.performSearch(keyword);
		Thread.sleep(5000);
		Assert.assertEquals("Search results for: "+ keyword, searchPage.assertSearchResults());
		System.out.println("Search Results page is opened successfully");
		SearchResultPage opensearch = new SearchResultPage(driver);
		opensearch.openallSearchLinks();

	}
	
	@Test
	public void searchSpecialCharTest() throws InterruptedException {
		
		String value = "@###$";
		HomeSearchPage searchPage = new HomeSearchPage(driver);
		searchPage.clickSearch();
		searchPage.performSearch(value);
		Thread.sleep(5000);
		SearchResultPage searchres = new SearchResultPage(driver);
		Assert.assertEquals("Sorry, your search didn't return any results.", searchres.verifySearchLabel());
		System.out.println("Special characters search did not return any results");			
	}
	

	

}
