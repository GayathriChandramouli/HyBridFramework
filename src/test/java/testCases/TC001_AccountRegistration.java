package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectClass.AccountRegister;
import pageObjectClass.HomePageClass;
import testBase.BaseMethods;

public class TC001_AccountRegistration extends BaseMethods {

	
	@Test(groups={"Regression","Master"})
	public void Login() throws InterruptedException
	{
		log.info("starting test case for account registration");
		try
		{
		HomePageClass hp= new HomePageClass(driver);
		hp.accountLinkClk();
		log.info("clicked on account link");
		
		hp.registerLinkClk();
		log.info("clicked on register link");
		
		String randompwd=randomeAlphanumeric();
		
		AccountRegister ar= new AccountRegister(driver);
		
		log.info("providing new user details");
		
		ar.setFirstName(randomeString());
		ar.setLastName(randomeString());
		ar.setEmailId(randomeString()+"@gmail.com");
		ar.setTelephoneNum(randomeNumber());
		ar.setPassword("apputanu");
		ar.setConfirmPwd("apputanu");
		ar.policychkbox();
		ar.continuebtn();
		Thread.sleep(3000);
		
		log.info("validated account created message");
		
		String message= ar.getConfirmationMsg();
	    if(message.equals("Your Account Has Been Created!"))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	log.error("test failed");
			log.debug("debug logs");
		    Assert.assertTrue(false);
	    }
		}
	    //Assert.assertEquals(message,"Your Account Has Been Created!sdf");
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		log.info("Account registration test case completed");
	}
	
}
