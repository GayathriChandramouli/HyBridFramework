package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	WebDriver driver=new ChromeDriver();

	//constructor
	public MyAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	//locators

		@FindBy(xpath="//h2[normalize-space()='My Account']")
		WebElement myaccountname;
		
		@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
		WebElement logoutlink;
		
	//Action methods
		
	public boolean accountlogin()
	    {
		try
		{
		return myaccountname.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	    }
	
	public void logout()
	{
		logoutlink.click();
	}

}
