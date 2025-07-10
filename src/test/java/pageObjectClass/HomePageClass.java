package pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageClass {
	
	WebDriver driver=new ChromeDriver();

	//constructor
	public HomePageClass(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	
	//locators
	
	By account_link=By.xpath("//span[normalize-space()='My Account']");		
	By register_Link=By.xpath("//a[normalize-space()='Register']");
	By login_Link=By.linkText("Login");

	
	//Action methods
	
    public void accountLinkClk()
    {
    	driver.findElement(account_link).click();
    		
    }
    	
	
    public void registerLinkClk()
    {
    	driver.findElement(register_Link).click();
    		
    }
    
    public void loginLinkClk()
    {
    	driver.findElement(login_Link).click();
    		
    }
       

}
