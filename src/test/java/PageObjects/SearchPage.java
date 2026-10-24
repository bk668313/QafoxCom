package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class SearchPage {
	WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    
    @FindBy(name="search")
    WebElement searchBox;
    
    @FindBy(xpath="//button[@class='btn btn-default btn-lg']")
    WebElement  searchButton;
    
    
    @FindBy(xpath = "//div[@class='product-thumb']//h4/a")
    List<WebElement> searchResults;
    
    
    public void enterProductName(String productName)
    {
    	searchBox.clear();
    	searchBox.sendKeys(productName);
    }
    
    
    
    public void clickSearch()
    {
    	searchButton.click();
    }
    
    
    public int getResultCount()
    {
    	return searchResults.size();
    }
    
    
    public boolean isproductDisplayed(String productName)
    {
    	for(WebElement product:searchResults)
    	{
    		if(product.getText().contains(productName))
    		{
    			return true;
    		}
    	}
		return false;
    }
    
    
    
    

}
