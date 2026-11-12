package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AddToCartPage;
import TestBase.BaseClass;

public class TC04_AddToCart extends BaseClass{
	
	@Test(groups = {"Sanity", "Regression", "Master"})
    public void verifyAddToCart() {

        logger.info("**** Starting Add To Cart Test ****");

        AddToCartPage atc = new AddToCartPage(driver);
        atc.searchProduct("MacBook");
        atc.selectProduct();
        atc.printProductDetails();
        
        
        
        Assert.assertEquals(atc.getProductTitle(), "MacBook", "Product title mismatch");
        
        String price = atc.getProductPrice();
        System.out.println("Product Price: " + price);

        Assert.assertTrue(!price.isEmpty(), "Product price is not displayed");
        
         atc.enterQuantity("1");
          atc.clickAddToCart();
         String actualMessage = atc.getSuccessMessage();

 Assert.assertTrue( actualMessage.contains("Success: You have added MacBook to your shopping cart!"), "Product not added to cart" );
         atc.clickShoppingCart();

       
        Assert.assertTrue(driver.getCurrentUrl().contains("route=checkout/cart"),"Shopping cart page not opened" );

        logger.info("**** Add To Cart Test Passed ****");
    }
	
	
	
	
	

}
