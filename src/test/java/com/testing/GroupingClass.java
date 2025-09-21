package com.testing;

import org.testng.annotations.Test;

public class GroupingClass {
	@Test(groups = "BREAKFASTITEMS")
	private void iddly() {
		System.out.println("IDDLY");
	}
	@Test(groups = "BREAKFASTITEMS")
	private void poori() {
		System.out.println("POORI");
	}
	@Test(groups = "BREAKFASTITEMS")
	private void dosa() {
		System.out.println("DOSA");
	}
	@Test(groups = "LUNCHITEMS")
	private void vegBriyani() {
		System.out.println("VEG BRIYANI");
	}
	@Test(groups = "LUNCHITEMS")
	private void cocoMilkPulav() {
		System.out.println("COCOMILK PULAV");
	}
	@Test(groups = "LUNCHITEMS")
	private void mashroomRice() {
		System.out.println("MASHROOM RICE");
	}	
	@Test(groups = "EC")
	private void mobile() {
		System.out.println("MOBILE");
	}
	@Test(groups = "EC")
	private void laptop() {
		System.out.println("LAPTOP");
	}
	@Test(groups = "EC")
	private void watch() {
		System.out.println("WATCH");
	}
	

}
