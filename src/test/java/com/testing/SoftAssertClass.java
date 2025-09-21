package com.testing;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertClass {
	@Test
	private void softAssertDemo() {
		String actualword ="Electronic";
		String expectedword="Electronics";
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actualword, expectedword);
		System.out.println("VERIFICATION DONE");
}
}
