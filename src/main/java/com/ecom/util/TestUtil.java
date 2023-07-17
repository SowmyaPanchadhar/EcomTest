package com.ecom.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil {

	
	public static long PAGE_LOAD_TIMEOUT=12;
	public static long IMPLICIT_WAIT=15;//In seconds
	public static String screenShotLocation="E:\\Selenium_March_2023\\screenshots";


	
	public static void takeScreenShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(screenShotLocation);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	
		}
		
	

}
