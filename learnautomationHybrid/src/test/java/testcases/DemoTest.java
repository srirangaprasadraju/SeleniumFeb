package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DemoTest extends BaseClass

{
	@Test
	public void test1()
	
	{
		logger = report.createTest("Google Test");
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		
		logger.pass("Google Test Passed");
		
		
	}

}
