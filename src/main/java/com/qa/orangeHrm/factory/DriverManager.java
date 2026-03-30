package com.qa.orangeHrm.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;

import com.qa.orangeHrm.errormsgs.FrameworkErrors;
import com.qa.orangeHrm.exceptions.FrameworkExceptions;

public class DriverManager {
	
	static ThreadLocal<WebDriver> threaddriver = new ThreadLocal<WebDriver>();
	
	public WebDriver initDriver(String browserName, boolean headLessvalue, boolean incognitovalue) {
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			ChromeOptions copt= DriverOptions.getChromeOptions(headLessvalue, incognitovalue);
			threaddriver.set(new ChromeDriver(copt));
			break;
		case"firefox":
			FirefoxOptions ffOpt= DriverOptions.getFirefoxOptions(headLessvalue, incognitovalue);
			threaddriver.set(new FirefoxDriver(ffOpt));
			break;
		case "edge":
			EdgeOptions edgOpt= DriverOptions.getEdgeOptions(headLessvalue, incognitovalue);
			threaddriver.set(new EdgeDriver(edgOpt));
			break;
		default:
			Reporter.log(browserName + FrameworkErrors.browserErrorMsg);
			throw new FrameworkExceptions("Invalid browsername passed"+"/n"+"Supported borwsers are Chrome/FireFox/Edge");
		
		}
		return getDriver();
	}

	public static WebDriver getDriver() {
		return threaddriver.get();
	}
}
