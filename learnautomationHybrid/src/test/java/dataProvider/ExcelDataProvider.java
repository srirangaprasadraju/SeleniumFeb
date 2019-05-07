package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 

{
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		
				
		try {
			wb = new XSSFWorkbook(new FileInputStream(new File("./TestData/MyAppData.xlsx")));
			
		} catch (FileNotFoundException e) {

			
		} catch (IOException e) {
		
			
		}
		
	}
	
	public String getStringCellData(String sheetName,int row,int cell)
	
	{
		
		 return wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		
	}
	
	public int getIntCellData(String sheetName,int row,int cell)
	
	{
		
		 return (int) wb.getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
		
	}
	
	public double getDoubleCellData(String sheetName,int row,int cell)
	
	{
		
		 return  wb.getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
		
	}
	
	public String getStringCellData(int sheetIndex,int row,int cell)
	
	{		 
		 return wb.getSheetAt(sheetIndex).getRow(row).getCell(cell).getStringCellValue();
		
	}
	
	public int countRows(String sheetName)
	
	{
		
		return wb.getSheet(sheetName).getPhysicalNumberOfRows();
			
	}
	
	public int countRows(int sheetIndex)
	
	{
		
		return wb.getSheetAt(sheetIndex).getPhysicalNumberOfRows();
			
	}
	
	public int countColumn(String sheetName, int row)
	
	{
		
		return wb.getSheet(sheetName).getRow(row).getPhysicalNumberOfCells();
			
	}
	
	public int countColumn(int sheetIndex, int row)
	
	{
		
		return wb.getSheetAt(sheetIndex).getRow(row).getPhysicalNumberOfCells();
			
	}
	
	

}
