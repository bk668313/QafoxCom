package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    @FindBy(id = "input-firstname")
    WebElement firstName;

    @FindBy(id = "input-lastname")
    WebElement lastName;

    @FindBy(id = "input-email")
    WebElement email;

    @FindBy(id = "input-telephone")
    WebElement telephone;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(id = "input-confirm")
    WebElement confirmPassword;

    @FindBy(name = "agree")
    WebElement privacyPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;
    
    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    WebElement accountCreatedMessage;
    
    
    public void enterFirstName(String fname) {
        firstName.sendKeys(fname);
    }

    public void enterLastName(String lname) {
        lastName.sendKeys(lname);
    }

    public void enterEmail(String mail) {
        email.sendKeys(mail);
    }

    public void enterTelephone(String phone) {
        telephone.sendKeys(phone);
    }
    public void enterPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void enterConfirmPassword(String pwd) {
        confirmPassword.sendKeys(pwd);
    }

    public void selectPrivacyPolicy() {
        privacyPolicy.click();
    }

    public void clickContinue() {
        continueButton.click();
    }
    public boolean isAccountCreated() {
        return accountCreatedMessage.isDisplayed();
    }
}
    
    
    
    
	
	


