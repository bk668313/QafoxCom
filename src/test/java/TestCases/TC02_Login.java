package TestCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.LoginPage;
import PageObjects.LogoutPage;
import TestBase.BaseClass;
import PageObjects.HomePage;


public class TC02_Login  extends BaseClass {
	
	@Test(groups = "Sanity")
    public void verify_login() {
		
		try
		{

        logger.info("*** Starting TC001_Login **********");

        HomePage hp = new HomePage(driver);

        logger.info("*** Clicking My Account and Login *****");
        hp.clickSigin();

        LoginPage lp = new LoginPage(driver);

        logger.info("*** Entering Username *****");
        lp.selectUsername(p.getProperty("username"));

        logger.info("*** Entering Password *****");
        lp.selectPassword(p.getProperty("password"));

        logger.info("*** Clicking Login *****");
        lp.clickLogin();
        
        
        logger.info("*** TC001_Login completed successfully *****");
        
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test failed because: " + e.getMessage());
		}
	}
}


           



        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        

        


