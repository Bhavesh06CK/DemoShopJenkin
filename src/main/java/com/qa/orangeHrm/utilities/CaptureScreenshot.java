package com.qa.orangeHrm.utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {

	public static File getscreenshotFile(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);//ChainTest Report
		return temp;
	}
	
	public static String getscreenshotBASE64(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String temp = ts.getScreenshotAs(OutputType.BASE64);
		return temp;
	}
	
	public static byte[] getscreenshotBYTES(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] temp = ts.getScreenshotAs(OutputType.BYTES);//Allure Report
		return temp;
	}
	
}
