package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProvider.DataProviderFactory;
import dataProvider.ExcelDataProvider;
import helper.Utility1;

public class HomePage 

{
	
	WebDriver driver;
	
	
	public HomePage(WebDriver ldriver)
	
	{
		
		this.driver=ldriver;
		
		
	}
	
	@FindBy(id="txtUsername") WebElement username;
	@FindBy(id="txtPassword") WebElement password;
	@FindBy(id="btnLogin") WebElement loginButton;
	
	public void verifyHomePageTitle()
	
	{
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.titleContains("OrangeHRM"));
		
		Utility1.verifyTitleContains(driver, "OrangeHRM");
	}
	
	public void loginAsAdmin()
	
	{
		
		username.sendKeys(DataProviderFactory.getExcel().getStringCellData("OrangeHrm", 0, 0));
		
		password.sendKeys(DataProviderFactory.getExcel().getStringCellData("OrangeHrm", 0, 1));
		
		loginButton.click();
		
		//WebDriverWait wait = new WebDriverWait(driver,30);
		
		//wait.until(ExpectedConditions.urlContains("dashboard"));
		
		//Writing separate function in Utility to avoid repeation
		
		Utility1.verifyTitleContains(driver, "dashboard");
	}
	
	

}
