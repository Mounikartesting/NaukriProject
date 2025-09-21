package com.testing;

import org.testng.annotations.Test;

public class PriorityClass {
	
	@Test(priority = -5)
	private void login() {
		System.out.println("LOGIN");
	}
	
	@Test(priority = 0)
	private void search() {
		System.out.println("SEARCH");
	}
	
	@Test(priority = 5)
	private void addtoCart() {
		System.out.println("ADD TO CART");
	}

}
