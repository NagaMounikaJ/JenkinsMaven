package com.google.automation.util;

import java.util.Calendar;

public class SystemConstants {
	//HtmlUnitDriver , chrome
	public final static String BrowserName = "chrome";
	public final static String ChromePath = "D://Softwares/chromedriver.exe";
	public final static String GenericDBURL = "";
	public static Calendar now = Calendar.getInstance();
	public static int year = now.get(Calendar.YEAR);
	public static int cmonth = now.get(Calendar.MONTH) + 1;
	public static int day = now.get(Calendar.DATE);
	public static String date = day + "-" + cmonth + "-" + year;
	public static int hours = now.get(Calendar.HOUR);
	public static String hour = date +" "+hours;
	public static int mins = now.get(Calendar.MINUTE);
	public static String time = hour +"."+ mins;
	public static String extentReportPath = System.getProperty("user.dir") + "\\ExtentReportResults.html";
	public static String emailContent = "";
	
}
