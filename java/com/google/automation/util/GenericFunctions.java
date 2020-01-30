package com.google.automation.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericFunctions {

	public boolean isElementPresent(WebElement pageObject) {
		try { 
			if(pageObject.isDisplayed()) 
			return true;
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public String capture(WebDriver driver,String screenShotName) throws IOException
    {
		String dest = "";
		String date = SystemConstants.time;
		if(!SystemConstants.BrowserName.equalsIgnoreCase("HtmlUnitDriver")){
			try{
				File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				dest = System.getProperty("user.dir") +"\\ErrorScreenshots\\"+date+"\\"+screenShotName+".png";
		        File destination = new File(dest);
				FileUtils.copyFile(screenshot, destination);
			}catch(Exception e){
				e.printStackTrace();
			}
		}      
        return dest;
    }
	
	
}
