package com.testing;

import org.testng.annotations.Test;

import com.reusablemethods.BaseClass;


public class InvocationCountClass extends BaseClass {
	@Test(invocationCount = 5)
	private void demo() {
		browserLaunch("Chrome");
		urlLaunch("https://www.facebook.com/");
		quitWindow();
	}

}
