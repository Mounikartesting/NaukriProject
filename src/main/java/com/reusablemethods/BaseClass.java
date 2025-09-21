package com.reusablemethods;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class BaseClass {
	public static WebDriver driver;
	public static Actions act;
	public static Alert a;
	public static WebDriverWait wait;
	public static ExtentReports extentReports;
	public static File file;
	protected static void browserLaunch(String browser) {
	 try {
		 if (browser.equalsIgnoreCase("Chrome")) {
			 driver=new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			 driver=new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			 driver=new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Safari")) {
			 driver=new SafariDriver();
		} 
		 driver.manage().window().maximize();
	} catch (Exception e) {
		Assert.fail("ERROR: OCCUR DURING THE BROWSER LAUNCHING CHECK BROWSER NAME");
		e.printStackTrace();
	}
}
	protected static void urlLaunch(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING THE URL LAUNCHING");
		}
		
	}
	protected static void inputPassing(WebElement element,String value) {
			try {
				element.sendKeys(value);//sendKeys() method
			} catch (Exception e) {
				Assert.fail("ERROR: OCCUR DURING THE VALUE PASSING");
				e.printStackTrace();
			}
	}
	protected static void elementClick(WebElement element) {
		try {
			element.click();//click() method
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING THE SUBMIT OR CLICK");
			e.printStackTrace();
		}
	}
	protected static void navigateToURL(String menctionURL) {
		try {
			driver.navigate().to(menctionURL);//navigate() method
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING PAGE NAVIGATE");
		}
	}
	protected static void navigateMethods(String navigateType) {
		try {
			if (navigateType.equalsIgnoreCase("back")) {
				driver.navigate().back();
			} else if (navigateType.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			} else if (navigateType.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING THE NAVIGATEMETHODS FAIL");
		} 
	}
	protected static void selectDropDown(WebElement element,String type,String value) {
		Select select=new Select(element);
		try {
			if (type.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));
			} else if (type.equalsIgnoreCase("text")) {
				select.selectByVisibleText(value);
			}else if (type.equalsIgnoreCase("value")) {
				select.selectByValue(value);
			}
		} catch (NumberFormatException e) {
			Assert.fail("ERROR: OCCUR DURING PASSING THE VALUES");
		}
	}
	protected static void staticWait(int sec) throws InterruptedException {
			Thread.sleep(sec*1000);
	}
	protected static void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	protected static void explicitWait(String value,int duration) { 
		try {
			if (value.equalsIgnoreCase("seconds")) {
				wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
			}else if (value.equalsIgnoreCase("minutes")) {
				wait=new WebDriverWait(driver, Duration.ofMinutes(duration));
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING THE WAIT");
		}
	}
	protected static void brwserTermination() {
		try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING THE TERMINATNG THE BROWSER");
		}
	}
	protected static void alert(String options) {
		try {
			a=  driver.switchTo().alert();
			if (options.equalsIgnoreCase("accept")) {
			a.accept();
			} else if (options.equalsIgnoreCase("dismiss")) {
				a.dismiss();
				
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING PASSING WRONG VALUES");
		}
	}
	protected static void navigate(String option) {
		try {
			if(option.equalsIgnoreCase("back")) {
				driver.navigate().back();
			}else if (option.equalsIgnoreCase("forward")) {
				driver.navigate().forward();	
			}else if (option.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			}
		} catch (Exception e) {
			Assert.fail("ERROR: INNVALID OPTION");
			}
	}
	protected static void actions(WebElement element,String options) {
		act = new Actions(driver);
		try {
			if(options.equalsIgnoreCase("click")) {
				act.click(element).perform();		
			}else if (options.equalsIgnoreCase("doubleclick")) {
				act.doubleClick(element).perform();
			}else if (options.equalsIgnoreCase("release")) {
				act.release(element).perform();
			}else if (options.equalsIgnoreCase("clickandhold")) {
				act.clickAndHold(element).perform();
			}else if (options.equalsIgnoreCase("contextclick")) {
				act.contextClick(element).perform();
			}else if (options.equalsIgnoreCase("movetoelement")) {
				act.moveToElement(element).perform();
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING THE INVALID OPTION");
		}
		
		
	}
	protected static void actions(WebElement element1,WebElement element2) {
		act=new Actions(driver);
		try {
			act.dragAndDrop(element1,element2);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING THE INVALID ELEMENT PASS");	
		}
	}
	protected static void click(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.fail("EEROR: DURING OCCURS PASSING WRONG ELEMENT");
			}
	}
	protected static void isdisplayed(WebElement element) {
		try {
			if (element.isDisplayed()) {
				System.out.println("Element is displayed");
			} else {
				System.out.println("Element is not displayed");
			}
		} catch (Exception e) {
			Assert.fail("ERROR: DURING OCCURS PASSING WRONG ELEMENT");
	}
}
	protected static void isenable(WebElement element) {
	try {
		if (element.isEnabled()) {
			System.out.println("Element is enable");
		}else {
			System.out.println("Element is not displayed");
		}
	} catch (Exception e) {
	Assert.fail("ERROR: OCCURS DURING PASSING ELEMENT");	
	}
	}
	protected static void isselected(WebElement element) {
		try {
			if (element.isSelected()) {
				System.out.println("Element is selected");
			}else {
				System.out.println("Element is not selected");
			}
		} catch (Exception e) {
		Assert.fail("ERROR: OCCURS DURING THE SELECTING ELEMENT");	
		}
		
	}
	protected static void frame(String type,String value) {
		if(type.equalsIgnoreCase("index")) {
			int value1=Integer.parseInt(value);
			driver.switchTo().frame(value1);
		}else if (type.equalsIgnoreCase("idname")) {
			driver.switchTo().frame(value);
		}else if (type.equalsIgnoreCase("elementname")) {
			WebElement findElement = driver.findElement(By.name(value));
			driver.switchTo().frame(findElement);
		}
	}
	protected static void prntFrame() {
		driver.switchTo().parentFrame();
	}
	protected static void dafaultFrame() {
		driver.switchTo().defaultContent();
	}
	protected static void closeWindow() {
		try {
			driver.close();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING THE WINDOW CLOSE");
		}
	}
	protected static void quitWindow() {
		try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING THE WINDOW QUIT");
		}
}
	protected static void submitWindow(WebElement element) {
		element.submit();
	}
	protected static void elementGetText(WebElement element) {
		try {
			element.getText();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING THE ELEMENT TEXT ISSUE");
		}
	}
	protected static void getCurentpageUrl(String currenturl) {
		try {
			driver.getCurrentUrl();
			System.out.println(currenturl);
		} catch (Exception e) {
		Assert.fail("ERROR: OCCUR DURING THE PASSING URL");	
		}
	}
	protected static void getFirstSelectedOption(WebElement element1,WebElement element2) {
		try {
			Select select=new Select(element1);
			element2=select.getFirstSelectedOption();
			System.out.println(element2.getText());
		} catch (Exception e) {
		Assert.fail("ERROR: OCCUR DURING SELECTING THE TEXT");	
		}
	}
	protected static void getPageTitle() {
		try {
			driver.getTitle();
		} catch (Exception e) {
		Assert.fail("ERROR: OCCUR DURING TITLE ISSUE");	
		}
	}	
	protected static void getElementAttribute(WebElement element,String value) {
		try {
			String attribute=element.getAttribute(value);
			System.out.println(attribute);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING ATTRIBUTE ISSUE");
		}
	}
	protected static void jsClick(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
	protected static void scrollToDown() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("Window.scrollTo(0,document.body.scrollHeight)");
	}
	protected static void scrollToUp() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("Window.scrollTo(0,0)");
	}
		//protected static void screenShort(String locaton,String name,String formate) {
		//TakesScreenshot ts=(TakesScreenshot)driver;
		//File source=ts.getScreenshotAs(OutputType.FILE);
		//File destination=new File(Location+name,formate);
		//FileHandler.copy(source,destination);
	//}
	protected static void valiidation(WebElement element,String expected) {
		try {
			Assert.assertEquals(element.getText(), expected);
			System.out.println(element.getText());
		} catch (Exception e) {
			Assert.fail("Error occured during validation");
		}
	}
	public static void extentReportStart(String location) {
		try {
			extentReports = new ExtentReports();
			file=new File(location);
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
			extentReports.attachReporter(sparkReporter);
			extentReports.setSystemInfo("OS",System.getProperty("os.name"));
			extentReports.setSystemInfo("JaVa Version", System.getProperty("java.version"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void extentReportTearDown(String location) throws IOException {
		try {
			extentReports.flush();
			file=new File(location);
			Desktop.getDesktop().browse((file).toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String takeScreenshot()throws IOException{
		    TakesScreenshot screenshot = (TakesScreenshot) driver;
			String timeStamp = new SimpleDateFormat("yyyymmdd_HHmmss").format(new Date());
			File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
			File destfile = new File("screenshot\\.png" + "_" + timeStamp + ".png");
			FileHandler.copy(scrfile, destfile);
			return destfile.getAbsolutePath();
	}
}


