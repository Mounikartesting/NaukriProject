package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.junit.Assert;

public class FileReaderManager {
	private static FileInputStream fileInputStream;
	private static Properties property;

	public static void setupProperty() {
	//	File file=new File("C:\\Users\\user\\eclipse-workspace\\MavenProject\\src\\main\\resources\\TestData.properties");
	//	File file=new File("C:\\Users\\user\\eclipse-workspace\\MavenProject\\src\\main\\resources\\SauceTestData.properties");
		File file=new File("C:\\Users\\LENOVO\\eclipse-workspace\\NaukriProject\\src\\main\\resources\\Naukri.properties");

		try {
			fileInputStream = new FileInputStream(file);
			property = new Properties();
			property.load(fileInputStream);
		} catch (FileNotFoundException e) {
			Assert.fail("ERROR: OCCUR DURING FILE LOADING");
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING FILE READING");
		}
}
	public static String getDataProperty(String value) {
	setupProperty();
	String data = property.getProperty(value);
	return data;
	}
	//public static void main(String[] args) {
	//	System.out.println(getDataProperty("browser"));
	}
//}
