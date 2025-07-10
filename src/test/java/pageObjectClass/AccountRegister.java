package pageObjectClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegister {
	
	WebDriver driver=new ChromeDriver();

	//constructor
	public AccountRegister(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	

	
	//locators

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement first_name;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement last_name;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email_id;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephone_num;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement pwd;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confirm_pwd;
	@FindBy(xpath="//input[@name='agree']")
	WebElement policy_chkbox;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement cont_register;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement register_confirm_msg;

	
	
	//Action methods
	
    public void setFirstName(String firstname)
    {
    	first_name.sendKeys(firstname);
    		
    }
    
    public void setLastName(String lastname)
    {
    	last_name.sendKeys(lastname);
    		
    }
    
    public void setEmailId(String emailid)
    {
    	email_id.sendKeys(emailid);
    		
    }
    
    public void setTelephoneNum(String telnum)
    {
    	telephone_num.sendKeys(telnum);
    		
    }
    
    public void setPassword(String password)
    {
    	pwd.sendKeys(password);
    		
    }
    
    public void setConfirmPwd(String confirmpwd)
    {
    	confirm_pwd.sendKeys(confirmpwd);
    		
    }
    
    public void policychkbox()
    {
    	policy_chkbox.click();
    		
    }
    
    public void continuebtn()
    {
    	cont_register.click();
    		
    }
    
   public String getConfirmationMsg()
   {
	   try
	   {
		   return(register_confirm_msg.getText());
	   }
	   catch(Exception e)
	   {
		   return(e.getMessage());
	   }
   }
    

}
