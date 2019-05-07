package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.Utility1;

public class LogoutPage 

{
	
	WebDriver driver;
	
	public LogoutPage(WebDriver ldriver)
	
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//a[contains(text(),'Welcome Admin')]") WebElement WelcomeAdmin_link;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]") WebElement logout_link;
	
	public void logoutFromApplication() throws Exception
	
	{
		//Utility1.switchFrameByNameAndId(driver, "mainpanel");
		
		WelcomeAdmin_link.click();
		
		Thread.sleep(3000);
		
		logout_link.click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.urlContains("login"));
		
		
		
		
	}
	

}
