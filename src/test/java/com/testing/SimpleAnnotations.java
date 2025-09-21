package com.testing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleAnnotations {
	@BeforeSuite
	private void propertySetting() {
		System.out.println("PROPERTY SETTING");
	}
	@BeforeTest
	private void laucnchBrowser() {
		System.out.println("BROWSER LAUNCH");
	}
	@BeforeClass
	private void launchUrl() {
		System.out.println("URL LAUNCH");
	}
	@BeforeMethod
	private void logIn() {
		System.out.println("LOGIN");
	}
	@Test
	private void women() {
		System.out.println("WOMEN");
	}
	@Test
	private void men() {
		System.out.println("MEN");
	}
	@Test
	private void kids() {
		System.out.println("KIDS");
	}
	@AfterMethod
	private void logOut() {
		System.out.println("LOGOUT");
	}
	@AfterClass
	private void screenShort() {
		System.out.println("SCREENSHORT");
	}
	@AfterTest
	private void close() {
		System.out.println("CLOSE");
	}
	@AfterSuite
	private void termination() {
		System.out.println("TERMINATION");

	}

}
