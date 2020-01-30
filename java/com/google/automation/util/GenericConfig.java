package com.google.automation.util;

import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenericConfig {

	public static WebDriver driver;
	static ExtentReports report;
	public static ExtentTest extTest;
	static Properties properties = System.getProperties();  
    
	@BeforeSuite
	public static void startTest() {
		report = new ExtentReports(SystemConstants.extentReportPath);
		extTest = report.startTest("ExtentDemo");
	}
	
	@AfterTest
	public static void endTest() {
		report.endTest(extTest);
		report.flush();
	}

	@BeforeTest
	public void setUp() {
		System.out.println("hello");
		if (SystemConstants.BrowserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", SystemConstants.ChromePath);
			driver = new ChromeDriver();
			extTest.log(LogStatus.PASS, "Chrome driver is successfully opened");
		}/*else if(SystemConstants.BrowserName.equalsIgnoreCase("HtmlUnitDriver")){
			driver = new HtmlUnitDriver();
			extTest.log(LogStatus.PASS, "HtmlUnitDriver driver is successfully opened");
		}*/
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterSuite
	public void afterClass() {
		driver.quit();
		extTest.log(LogStatus.PASS, "Chrome driver is successfully closed");
	}

}
