package com.listner;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.reusablemethods.BaseClass;

public class ITestListnerClass extends BaseClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			ExtentReport_Test.extenttest.pass(result.getMethod().getMethodName()+":"+"Test Pass",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ExtentReport_Test.extenttest.fail(result.getMethod().getMethodName()+":"+"Test Fail",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
	}

//	@Override
////	public String takeScreenshot() throws IOException {
//		// TODO Auto-generated method stub
//		return super.takeScreenshot();
//	}
//
//	@Override
//	public int hashCode() {
//		// TODO Auto-generated method stub
//		return super.hashCode();
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		// TODO Auto-generated method stub
//		return super.equals(obj);
//	}
//
//	@Override
//	protected Object clone() throws CloneNotSupportedException {
//		// TODO Auto-generated method stub
//		return super.clone();
//	}
//
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return super.toString();
//	}
//	@Override
//	protected void finalize() throws Throwable {
//		// TODO Auto-generated method stub
//		super.finalize();
//	}

}
