package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() 
	{
		File src = new File("./TestData/Data.xlsx");
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			
			wb = new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			
			System.out.println("Unable to read excel file" + e.getMessage());
		}	
		
	}
	
	public String getStringData(int sheetIndex, int row, int col) 
	{
		 return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
		
	}
	
	public String getStringData(String sheetName, int row, int col) 
	{
		 return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
		
	}
	
	
	public double getNumericData(String sheetName, int row, int col)
	{
		return wb.getSheet("sheetName").getRow(row).getCell(col).getNumericCellValue();
	}

}
