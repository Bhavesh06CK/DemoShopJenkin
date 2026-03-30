package com.qa.orangeHrm.Base;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.orangeHrm.factory.DriverManager;
import com.qa.orangeHrm.pageobjects.RegisterPage;
import com.qa.orangeHrm.pageobjects.WelcomePage;
import com.qa.orangeHrm.utilities.CaptureScreenshot;
import com.qa.orangeHrm.utilities.ReadconfigData;
import com.qa.orangeHrm.utilities.WebDriverActions;

public class BaseTest {
	protected WebDriver driver;
	private DriverManager manager;
	private WebDriverActions driverActions;
	protected WelcomePage welcomePg; 
	private ReadconfigData rcd;
	protected RegisterPage rp;
	protected com.qa.orangeHrm.utilities.FakeDataGenerator dataGen;
	
	private static final Logger logger=LogManager.getLogger(BaseTest.class);
	
	
	@Parameters({"browserNameXml","headlessModeXml","privateModeXml"})
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String browserNameXml,@Optional("true") String headlessModeXml,@Optional("true") String privateModeXml  ) throws IOException{
		logger.info("Launching the browser: "+browserNameXml+"headless mode: "+headlessModeXml+"and private mode as "+privateModeXml+"");
		rcd = new ReadconfigData();
		manager = new DriverManager();
		
		String browser = System.getProperty("browser", browserNameXml);
		String headless= System.getProperty("headless", headlessModeXml);
		String incognito=System.getProperty("incognito", privateModeXml);
		
		
		if (browserNameXml != null) {
			rcd.prop.setProperty("browsername", browser);
		}
		if (headlessModeXml != null) {
			rcd.prop.setProperty("headless", headless);
		}
		if (privateModeXml != null) {
			rcd.prop.setProperty("incognito", incognito);
		}
		
		
		boolean headLessvalue= Boolean.parseBoolean(rcd.getProperty("headless"));
		boolean incognitovalue= Boolean.parseBoolean(rcd.getProperty("incognito"));
//		driver= manager.initDriver("CHROME");
		driver= manager.initDriver(rcd.getProperty("browsername"),headLessvalue, incognitovalue);
		driverActions = new WebDriverActions(driver);
//		driverActions.enterUrl("https://demowebshop.tricentis.com/");
		driverActions.enterUrl(rcd.getProperty("testUrl"));
		driverActions.maximizeBrowser();
		welcomePg= new WelcomePage(driver);
		rp = new RegisterPage(driver);		
	}
	
	@AfterMethod
	public void attachScreenshot(ITestResult result) {
		if(!result.isSuccess()) {
			logger.info("The ScreenShot is being captured for the method"+result.getName());
			ChainTestListener.embed(CaptureScreenshot.getscreenshotFile(driver), "image/png");
		}
	}
	
	public void closeApplication() {
		logger.info("The Application is being logged out");
		welcomePg.doLogout();
	}
	
	@AfterClass(enabled = true)
	public void tearDown() throws InterruptedException{
		Reporter.log("Pages are Closed", true);
		logger.info("Closed browser after logout validated");
		driverActions.closeBrowser();
	}

}
