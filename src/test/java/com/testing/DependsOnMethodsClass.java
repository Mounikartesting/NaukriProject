package com.testing;

import org.testng.annotations.Test;

public class DependsOnMethodsClass {
	@Test
	private void sampleOne() {
		int i=10;
		System.out.println(i/0);
		System.out.println("SAMPLE ONE");
	}
	@Test
	private void sampleTwo() {
		System.out.println("SAMPLE TWO");
	}
	@Test(dependsOnMethods= {"sampleOne","sampleTwo"})
	private void sampleThree() {
		System.out.println("SAMPLE THREE");
	}
}
