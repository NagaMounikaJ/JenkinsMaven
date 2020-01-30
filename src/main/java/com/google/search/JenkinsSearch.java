package com.google.search;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class JenkinsSearch {

	public void search(WebDriver driver, ExtentTest extTest){
		System.out.println("search");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys("jenkins");
		extTest.log(LogStatus.INFO, "search for jenkins in google");
		driver.findElement(By.xpath("//input[@aria-label='Google Search']")).click();
		
		driver.findElement(By.xpath("//a[@href = 'https://jenkins.io/']")).click();
		System.out.println("search jenkins");
		extTest.log(LogStatus.PASS, "jenkins io screen is launched");
	}
}
