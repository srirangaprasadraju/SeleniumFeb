package unitTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import dataProvider.ConfigDataProvider;

public class TestConfigDataProvider 

{
	@Test
	public void testConfig()
	
	{
		
		ConfigDataProvider config = new ConfigDataProvider();
		
		String value = config.getPropertyVaue("toolName");
		
		Assert.assertTrue(value.contains("Selenium"), "Data is not available");
		
		
	}

}
