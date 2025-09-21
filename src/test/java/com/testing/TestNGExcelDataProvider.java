package com.testing;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.reusablemethods.BaseClass;
import com.utility.ExcelReader;

public class TestNGExcelDataProvider extends BaseClass{
	@DataProvider(name="excelDataProvider")
	public Object[][] dataProviderMethod() throws FileNotFoundException{
		String filePath = System.getProperty("user.dir")+ "\\resources\\TestData.xlsx";
		String sheetName="data";
		return ExcelReader.getExcelData(filePath,sheetName);	
	}
	@Test(dataProvider="excelDataProvider")	
	private void testMethods(String username,String password ) {
		browserLaunch("Chrome");
		implicitWait(30);
		urlLaunch("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		System.out.println("UserName :" +username+ "Password :"+password);
	}
	
}

