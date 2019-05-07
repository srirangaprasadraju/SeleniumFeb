package unitTestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import helper.BrowserFactory;

public class TestBrowserFactory 

{
	@Test
	public void testChromeBrowser()
	
	{
		WebDriver driver = BrowserFactory.startSession("Chrome","");
		
		Assert.assertFalse(driver.equals(null));
		
		BrowserFactory.closeSession(driver);
		
	}
	
	@Test
	public void testFireFoxBrowser()
	
	{
		WebDriver driver = BrowserFactory.startSession("Firefox","");
		
		Assert.assertFalse(driver.equals(null));
		
		BrowserFactory.closeSession(driver);
		
	}
	
	@Test
	public void testIEBrowser()
	
	{
		WebDriver driver = BrowserFactory.startSession("IE","");
		
		Assert.assertFalse(driver.equals(null));
		
		BrowserFactory.closeSession(driver);
		
	}

}
