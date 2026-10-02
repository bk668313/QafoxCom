package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.RegisterPage;
import TestBase.BaseClass;

public class TC01_Register extends BaseClass {

    @Test(groups = {"Sanity", "Regression", "Master"})
    public void verifyUserRegistration() {

        logger.info("***** Starting User Registration Test *****");

        
        RegisterPage registerPage = new RegisterPage(driver);

        
        logger.info("Clicking My Account");
        driver.findElement(org.openqa.selenium.By.xpath("//span[text()='My Account']") ).click();

       
        logger.info("Clicking Register");
        driver.findElement(org.openqa.selenium.By.xpath("//a[text()='Register']")).click();

        
        String firstName = "Test" + randomString();
        String lastName = "User" + randomString();
        String email = randomAlphaNumeric() + "@gmail.com";
        String telephone = randomNumber();
        String password = "Test@123";

        logger.info("Entering First Name");
        registerPage.enterFirstName(firstName);

        logger.info("Entering Last Name");
        registerPage.enterLastName(lastName);

        logger.info("Entering Email");
        registerPage.enterEmail(email);

        logger.info("Entering Telephone");
        registerPage.enterTelephone(telephone);

        logger.info("Entering Password");
        registerPage.enterPassword(password);

        logger.info("Entering Confirm Password");
        registerPage.enterConfirmPassword(password);

        logger.info("Selecting Privacy Policy");
        registerPage.selectPrivacyPolicy();

        logger.info("Clicking Continue");
        registerPage.clickContinue();

        // Validate account creation
        logger.info("Validating Account Created message");

        boolean accountCreated = registerPage.isAccountCreated();

        Assert.assertTrue(accountCreated, "Registration failed - Account Created message was not displayed" );

        logger.info("***** User Registration Test Passed *****");
    }
}

