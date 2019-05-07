package testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.beust.jcommander.Parameter;

import dataProvider.ConfigDataProvider;
import dataProvider.DataProviderFactory;
import helper.BrowserFactory;
import helper.Utility1;

public class BaseClass 

{
	
	WebDriver driver;
	
	ExtentReports report;
	
	ExtentTest logger;
		
	
	
	@BeforeSuite
	public void setupproject()
	
	{
		Reporter.log("Setting up the report for the project",true);
		
		ExtentHtmlReporter html = new ExtentHtmlReporter(new File("./Report/LearAutomation_"+Utility1.getCurrentTime()+".html"));
		
		ExtentReports report = new ExtentReports();
		
		report.attachReporter(html);
		
		Reporter.log("Report instance is ready",true);
	}
	
/*	@BeforeClass
	public void setupTest()
	
	{		
		
		driver = BrowserFactory.startSession(DataProviderFactory.getConfig().getBrowser(),DataProviderFactory.getConfig().getStagingURL());
	}
*/
	@Parameters("appBrowser")
	@BeforeClass
	public void setupTest(String browser)
	
	{		
		
		driver = BrowserFactory.startSession(browser,DataProviderFactory.getConfig().getStagingURL());
	}
	
	@AfterClass
	public void tearDownTest()
	
	{
		BrowserFactory.closeSession(driver);
		
	}
	
	@AfterMethod
	public void tearDownProject(ITestResult result)
	
	{
		
		if (result.getStatus()==ITestResult.SUCCESS)
			
		{
			logger.pass("Test Passed");
		}
		else
		{
			try {
				logger.fail("Test Failed"+result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(Utility1.takeScreenShot(driver)).build());
			} catch (IOException e) {
				
				e.getMessage();
			}
		}
		
		report.flush();
		Reporter.log("Adding the test result to the report",true);
	}
	
	
	
	

}
