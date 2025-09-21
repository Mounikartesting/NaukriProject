package com.runner;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.listner.ExtentReport_Test;
import com.listner.ITestListnerClass;
import com.pageobjectmanager.PageObjectManager;
import com.reusablemethods.BaseClass;

@Listeners(ITestListnerClass.class)
public class NaukriRunner extends BaseClass {
	
	@BeforeClass
	public void prorpertySetup() {
		browserLaunch(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("browser"));
		urlLaunch(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("url"));
	}
	@Test(priority=0)
	public void naukriLogin() throws InterruptedException {
	//ExtentReport_Test.extenttest = extentReports.createTest("LOGIN TEST" +":"+Thread.currentThread()
	//.getStackTrace()[1].getMethodName().toString()).info("Naukri Application Testing");
		//Assert.assertTrue(PageObjectManager.getPageObjectManager().getLoginPage().validLogin());
		PageObjectManager.getPageObjectManager().getLoginPage().validLogin();
}
//	@Test
////	private void profileUpdate() {
////		PageObjectManager.getPageObjectManager().getProfileUpdate().profileUpdation();
//
////	}
@AfterClass
public void termination() {
	quitWindow();
}
@BeforeSuite
private void testStart() {
		extentReportStart(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("reportstart"));
}
@AfterSuite
private void testend() throws IOException {
		extentReportTearDown(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("reportend"));
}

}
