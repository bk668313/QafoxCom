package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	 WebDriver driver;

	    public LogoutPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    
	    @FindBy(xpath = "//a[contains(text(),'Logout')]")
	    WebElement logoutLink;
	    
	    public boolean CheckLogout() {

	        try {
	            return logoutLink.isDisplayed();
	        } catch (Exception e) {
	            System.out.println("Logout link was NOT found!");
	            e.printStackTrace();
	            return false;
	        }
	    }
}

