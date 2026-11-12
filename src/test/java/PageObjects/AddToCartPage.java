package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import java.util.List;


public class AddToCartPage {
	
	WebDriver driver;
	
	public AddToCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(name="search")
	 WebElement searchbox;
	 
	 @FindBy(xpath = "//button[contains(@class,'btn-default') and contains(@class,'btn-lg')]")
	    WebElement searchButton;
	 
	 @FindBy(xpath = "//a[text()='MacBook']")
	    WebElement product;
	 
	 @FindBy(xpath = "//div[@id='content']//h1")
	    WebElement productTitle;
	 
	 @FindBy(xpath = "(//div[@id='content']//h2)[2]")
	 WebElement productPrice;
	 
	 @FindBy(id = "input-quantity")
	    WebElement quantity;
	 
	 
	 
	 @FindBy(id = "button-cart")
	    WebElement addToCartButton;
	 
	  @FindBy(css = ".alert-success")
	    WebElement successMessage;
	  
	  @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
	    WebElement shoppingCartLink;
	  
	  
	  public void searchProduct(String productName)
	  {
		  searchbox.clear();
		  searchbox.sendKeys(productName);
		  searchButton.click();
		  	  
	  }
	  
	  public void selectProduct() {
	        product.click();
	    }
	  
	  public String getProductTitle() {
	        return productTitle.getText();
	    }
	  
	  public String getProductPrice() {
		    return productPrice.getAttribute("textContent").trim();
		}
	  
	  public void enterQuantity(String qty) {
	        quantity.clear();
	        quantity.sendKeys(qty);
	    }
	  
	  
	  public void printProductDetails() {

		    List<WebElement> elements =
		            driver.findElements(By.xpath("//div[@id='content']//h2"));

		    for (int i = 0; i < elements.size(); i++) {

		        System.out.println("Element " + i + ": " + elements.get(i).getText());

		        System.out.println("Text Content: "  + elements.get(i).getAttribute("textContent"));
		    }
	  }
	  
	  
	  public void clickAddToCart() {
	        addToCartButton.click();
	    }
	  
	  public String getSuccessMessage() {
	        return successMessage.getText();
	    }
	  
	  public void clickShoppingCart() {
	        shoppingCartLink.click();
	    }

}
