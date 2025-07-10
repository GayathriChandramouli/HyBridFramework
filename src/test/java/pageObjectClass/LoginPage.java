package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver=new ChromeDriver();

	//constructor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	//locators

		@FindBy(xpath="//input[@id='input-email']")
		WebElement login_email;
		
		@FindBy(xpath="//input[@id='input-password']")
		WebElement login_password;
		
		@FindBy(xpath="//input[@value='Login']")
		WebElement login_btn;
		
		
		//Action methods
		
	    public void loginemail(String email)
	    {
	    	login_email.sendKeys(email);
	    		
	    }
	    
	    public void loginpwd(String pwd)
	    {
	    	login_password.sendKeys(pwd);
	    		
	    }
	    
	    public void loginbtn()
	    {
	    	login_btn.click();
	    		
	    }
		
	}
