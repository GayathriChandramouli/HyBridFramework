package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectClass.HomePageClass;
import pageObjectClass.LoginPage;
import pageObjectClass.MyAccountPage;
import testBase.BaseMethods;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseMethods {

    @Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="DDT")
    public void verify_loginDDT(String email, String pwd, String exp)
    {
    	
    	log.info("start of test case");
    	
    	try {
    	
        // HomePage
        HomePageClass hp= new HomePageClass(driver);
		
		hp.accountLinkClk();
		hp.loginLinkClk();
		
		LoginPage lp=new LoginPage(driver);
				
		lp.loginemail(email);
		lp.loginpwd(pwd);
		lp.loginbtn();
		
		MyAccountPage ap=new MyAccountPage(driver);
		boolean display=ap.accountlogin();
       
		if (exp.equalsIgnoreCase("Valid"))
		{
		    if (display == true)
		    {
		        ap.logout();
		        Assert.assertTrue(true);
		    }
		    else
		    {
		        Assert.assertTrue(false);
		    }
		}
		if (exp.equalsIgnoreCase("inValid"))
		{
		    if (display == true)
		    {
		        ap.logout();
		        Assert.assertTrue(false);
		    }
		    else
		    {
		        Assert.assertTrue(true);
		    }
		}
    }
    	catch(Exception e)
    	{
    		Assert.fail();
    	}
    	log.info("end of test case");
        	
    }
}
