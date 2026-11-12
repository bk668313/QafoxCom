package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.SearchPage;
import TestBase.BaseClass;

public class TC03_Search extends BaseClass {
	
	@Test(groups = {"Sanity", "Regression", "Master"})
	public void verifySearchproduct()
	{
		logger.info("Starting product search test");
		
		SearchPage sp=new SearchPage(driver);
		sp.enterProductName("MacBook");
		sp.clickSearch();
		
		
		Assert.assertTrue(sp.getResultCount()>0,"no of product count in search result");
		Assert.assertTrue(sp.isproductDisplayed("MacBook"),"MacBook was not found in search results");
		
		logger.info("Product search test passed");
		
	}
	

}