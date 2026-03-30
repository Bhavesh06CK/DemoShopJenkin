package com.qa.orangeHrm.factory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;

public class DriverOptions {
	public static ChromeOptions getChromeOptions(Boolean headLess, Boolean incognito) {
		ChromeOptions opt = new ChromeOptions();
		if (headLess) {
			opt.addArguments("--headless");
			Reporter.log("Chrome is running in Headless mode", true);
		}
		if (incognito) {
			opt.addArguments("--incognito");
			Reporter.log("Chrome is running in Incognito mode", true);
		}
		if (!headLess && !incognito) {
		    Reporter.log("Chrome is running in Normal mode", true);
		}
		
		return opt;
	}
	public static FirefoxOptions getFirefoxOptions(Boolean headLess, Boolean incognito) {
		FirefoxOptions opt = new FirefoxOptions();
		if (headLess) {
			opt.addArguments("--headless");
			Reporter.log("FireFox is running in Headless mode", true);
		}
		if (incognito) {
			opt.addArguments("--incognito");
			Reporter.log("FireFox is running in Incognito mode", true);
		}
		if (!headLess && !incognito) {
		    Reporter.log("FireFox is running in Normal mode", true);
		}
		return opt;	
	}
	public static EdgeOptions getEdgeOptions(Boolean headLess, Boolean incognito) {
		EdgeOptions opt = new EdgeOptions();
		if (headLess) {
			opt.addArguments("--headless");
			Reporter.log("Edge is running in Headless mode", true);
		}
		if (incognito) {
			opt.addArguments("--incognito");
			Reporter.log("Edge is running in Incognito mode", true);
		}
		if (!headLess && !incognito) {
		    Reporter.log("Edge is running in Normal mode", true);
		}
		return opt;	
	}

}
