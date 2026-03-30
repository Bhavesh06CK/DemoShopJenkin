package com.qa.orangeHrm.pageobjects;

import org.openqa.selenium.WebDriver;

import com.qa.orangeHrm.utilities.ElementActions;
import com.qa.orangeHrm.utilities.WebDriverActions;

public class BasePage {

	protected WebDriver driver;
	protected ElementActions elementactions;
	protected WebDriverActions driverActions;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		elementactions = new ElementActions(driver);
		driverActions = new WebDriverActions(driver);
	}

}
