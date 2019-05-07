package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import applicationPages.HomePage;
import applicationPages.LogoutPage;
import helper.BrowserFactory;
import helper.Utility1;


public class LoginTestOrangeHRM extends BaseClass

{
	
	HomePage home;
	
	LogoutPage logout;
	
	WebDriver driver;
	
	
	@Test
	public void loginAsAdmin() throws Exception
	
	{
		//driver = BrowserFactory.startSession("Chrome","https://opensource-demo.orangehrmlive.com/index.php/auth/");
		
		//driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/");
		
		 home = PageFactory.initElements(driver, HomePage.class);
		 
		 logout = PageFactory.initElements(driver, LogoutPage.class);
		 
		 logger = report.createTest("Login and Logout from Application");
		 
		 home.verifyHomePageTitle();
		 
		 logger.pass("User is landed on correct page");
		 
		 home.loginAsAdmin();
		 
		 try {
			 
			logger.pass("User is able to login",MediaEntityBuilder.createScreenCaptureFromPath(Utility1.takeScreenShot(driver)).build());
			
		} catch (Exception e) {
			
			e.getMessage();
		}
		 
		 logout.logoutFromApplication();
		 
		 logger.pass("User is able to logout Application");
	}

}
