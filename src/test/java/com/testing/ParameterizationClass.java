package com.testing;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.reusablemethods.BaseClass;


public class ParameterizationClass extends BaseClass{
	@Parameters({"username","password"})
	@Test()
	private void testMethods(String username,String password ) {
		browserLaunch("Chrome");
		implicitWait(30);
		urlLaunch("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
	}
	

}
