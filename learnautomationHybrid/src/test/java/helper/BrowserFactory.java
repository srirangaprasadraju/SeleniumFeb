package helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

public class BrowserFactory {
	
	public static WebDriver startSession(String browserName, String url)
	
	{
		
		WebDriver driver = null;
		
		if (browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dheshu\\OneDrive\\Selenium Training Videos\\Browser drivers\\chromedriver.exe");
			
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
		}else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dheshu\\OneDrive\\Selenium Training Videos\\Browser drivers\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			
			driver.manage().window().maximize();
			
		}else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Dheshu\\OneDrive\\Selenium Training Videos\\Browser drivers\\IEDriverServer.exe");
			
			driver = new InternetExplorerDriver();
				
			driver.manage().window().maximize();
			
		}else
		
		{
			Reporter.log("Sorry we support only Chrome, FireFox and IE", true);
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Reporter.log("Application is up and running");
		
		return driver;
				
	}
	
	public static void closeSession(WebDriver driver)
	
	{
		
		Reporter.log("Trying to close the session",true);
		
		driver.quit();
		
		Reporter.log("Session Closed",true);
		
	}

}
