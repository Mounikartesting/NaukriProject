package com.testing;

import org.testng.annotations.Test;

import com.reusablemethods.BaseClass;


public class CrossBrowser extends BaseClass{
	@Test
	private void edge() {
		browserLaunch("Edge");
		urlLaunch("https://www.naukri.com/");
		System.out.println("Browser ID:" + Thread.currentThread().getId());
	}
	
	@Test
	private void chrome() {
		browserLaunch("Chrome");
		urlLaunch("https://www.naukri.com/");
		System.out.println("Browser ID:" + Thread.currentThread().getId());
	}
	@Test
	private void firefox() {
		browserLaunch("Firefox");
		urlLaunch("https://www.naukri.com/");
		System.out.println("Browser ID:" + Thread.currentThread().getId());

	}
}
