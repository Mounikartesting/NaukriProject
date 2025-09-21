package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static Object[][] getExcelData(String filePath,String sheetName) throws FileNotFoundException{
		Object[][] data = null;
		try(FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook =new XSSFWorkbook(fis)){
		Sheet sheet = workbook.getSheet(sheetName);
		int totalRows = sheet.getLastRowNum();
		int totalCols=sheet.getRow(0).getLastCellNum();
		data=new Object[totalRows][totalCols];
		for (int i = 0; i < data.length; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < data.length; j++) {
				Cell cell = row.getCell(j);
				data[i-1][j]=(cell==null)?"" : cell.toString();
			}	
		}
	}catch(Exception e) {
		
	}
		return data;
		
	}
}
