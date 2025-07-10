package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com. aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseMethods;

public class ExtentReportManager implements ITestListener
{
    public ExtentSparkReporter sparkReporter; // UI of the report
    public ExtentReports extent; //populate common info on the report
    public ExtentTest test; // creating test case entries in the report and update status of the test met
   // String reportname;
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
   	String repName = "Test-Report-"+timeStamp+".html";
    public void onStart(ITestContext context)    
    {
    	/*SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    	Date dt=new Date();
    	String currentdatetimestamp=df.format(dt) ;*/

       	

    	    sparkReporter = new ExtentSparkReporter(".\\reports\\"+repName);
    		
			sparkReporter.config().setDocumentTitle("Automation Report"); // Title of report
			sparkReporter.config().setReportName("Functional Testing"); // name of the report
			sparkReporter.config().setTheme(Theme.DARK);
			
			extent=new ExtentReports();
			extent.attachReporter(sparkReporter);
			
			extent.setSystemInfo("Computer Name","localhost");
			extent.setSystemInfo("Environment","QA");
			extent.setSystemInfo("Module","Opencart_log");
			extent.setSystemInfo("Submodule","Customer");
			extent.setSystemInfo("Tester Name",System.getProperty("user.name"));
			
			
			String os= context.getCurrentXmlTest().getParameter("os");
			extent.setSystemInfo("Operating System",os);
			
			String browser= context.getCurrentXmlTest().getParameter("browser");
			extent.setSystemInfo("Bowser Name",browser);
			
			List<String> includedgrps= context.getCurrentXmlTest().getIncludedGroups();
			if(!includedgrps.isEmpty())
			{
				extent.setSystemInfo("Executed Group",includedgrps.toString());
			}
			
    }	
    public void onTestSuccess(ITestResult result)
    {
			test = extent.createTest(result.getName()); // create a new entry in the report
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s
			
    }
	
    public void onTestFailure(ITestResult result)
    {
			test = extent.createTest(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
			test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());
			
			try {
				String imgPath = new BaseMethods().captureScreen(result.getName());
				test.addScreenCaptureFromPath(imgPath) ;

				} catch (IOException e1) {
				e1.printStackTrace();
				}
    }
    
	public void onTestSkipped(ITestResult result)
	{
			test = extent.createTest(result.getTestClass().getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
			test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	public void OnFinish(ITestContext context)
	{
		extent.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
		File extentReport = new File(pathOfExtentReport) ;

		try {

		Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e)
		{
		e.printStackTrace();
		}

      /*  try { 
        	URL url = new URL("file:///"+System.getProperty("user.dir")+"\\reports"+reportname);
        	// Create the email message

        	ImageHtmlEmail email = new ImageHtmlEmail();
        	email.setDataSourceResolver(new DataSourceUrlResolver(url));
        	email.setHostName("smtp.googlemail.com") ;
        	email.setSmtpPort (465) ;
        	email.setAuthenticator(new DefaultAuthenticator("sakshimouli@gmail.com", "apputanu"));
        	email.setSSLOnConnect(true) ;
        	email.setFrom("sakshimouli@gmail.com"); //Sender
        	email.setSubject("Test Results");
        	email.setMsg("Please find Attached Report....");
        	email.addTo("gayathri.chandramouli0407@gmail.com"); //Receiver
        	email.attach(url, "extent report", "please check report...");
        	email.send(); // send the email
        	}
        catch (IOException e) {

    		e.printStackTrace();

       }*/	
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}

