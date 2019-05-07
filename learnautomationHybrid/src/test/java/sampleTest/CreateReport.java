package sampleTest;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class CreateReport 

{
	@Test
	public void test1() throws Exception
	
	{
		
		ExtentHtmlReporter html = new ExtentHtmlReporter(new File("./Report/selenium5.html"));
		
		ExtentReports report = new ExtentReports();
		
		report.attachReporter(html);
		
		ExtentTest test1 = report.createTest("Login");
		
		test1.log(Status.INFO, "Enter Username");
		
		test1.log(Status.INFO, "Enter Password");
		
		test1.log(Status.PASS, "Login Passed");
		
		report.flush();
		
		ExtentTest test2 = report.createTest("Logout");
		
		test2.log(Status.INFO, "Click on Logout button");
						
		test2.log(Status.FAIL, "Logout Failed");
		
		test2.fail("Step Failed", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Dheshu\\OneDrive\\New folder\\Demo.png").build());
		
		
		
		report.flush();
	}

}
