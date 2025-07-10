 package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectClass.HomePageClass;
import pageObjectClass.LoginPage;
import pageObjectClass.MyAccountPage;
import testBase.BaseMethods;

public class TC002_Login extends BaseMethods
{
	@Test(groups={"Sanity","Master"})
	public void Login()
	{
		log.info("starting test case for account login");
		try {
		HomePageClass hp= new HomePageClass(driver);
		
		hp.accountLinkClk();
		Thread.sleep(3000);
		log.info("clicked on account link");
		
		hp.loginLinkClk();
		Thread.sleep(3000);
		log.info("clicked on login link");
		
		
		LoginPage lp=new LoginPage(driver);
		Thread.sleep(3000);
		log.info("providing credentials");
		
		lp.loginemail(p.getProperty("email"));
		lp.loginpwd(p.getProperty("pwd"));
		lp.loginbtn();
		
		MyAccountPage ap=new MyAccountPage(driver);
		boolean display=ap.accountlogin();
			Assert.assertTrue(display);
			log.info("successful login");
		    }
		catch(Exception e)
		{
			Assert.fail();
			log.info("failed login");
		    
		}
		
	}
}
