package unitTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import dataProvider.ExcelDataProvider;

public class TestExcelDataProvider 

{
	@Test
	public void testExcel()
	
	{
		
		ExcelDataProvider excel = new ExcelDataProvider();
		
		String value = excel.getStringCellData("login", 0, 0);
		
		System.out.println("value is "+value);
		
		Assert.assertTrue(value.contains("Admin"));
		
		
	}

}
