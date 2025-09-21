package com.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertClass {
	@Test
	private void demo() {
		String actual="Mounika";
		String expected="mounika";
	Assert.assertEquals(actual, expected);
	System.out.println("VALIDATION DONE");
	}

}
