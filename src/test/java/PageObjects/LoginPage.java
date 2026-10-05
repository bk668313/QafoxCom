package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(id = "input-email")
    WebElement username;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    public void selectUsername(String email) {
        username.sendKeys(email);
    }

    public void selectPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void clickLogin() {
        loginButton.click();
    }
}
    
    
	
	


