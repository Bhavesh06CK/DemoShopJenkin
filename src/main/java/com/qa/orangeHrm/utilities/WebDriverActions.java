package com.qa.orangeHrm.utilities;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class WebDriverActions extends BaseUtility {
	
	public WebDriverActions(WebDriver driver) {
		super(driver);
	}
	
	public void enterUrl(String url) {
		driver.get(url);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getPageSource() {
		return driver.getPageSource();
	}

	public void closeTab() {
		driver.close();
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	
	public void minimizeBrowser() {
		driver.manage().window().minimize();
	}
	
	public void fullscreenBroswer() {
		driver.manage().window().fullscreen();
	}
	
	public void navigateToPage(String Url) {
		driver.navigate().to(Url);
	}
	
	public void navigateToPreviousPage(String Url) {
		driver.navigate().back();
	}
	
	public void navigateToForwardPage(String Url) {
		driver.navigate().forward();
	}
	
	public void refreshPage(String url) {
		driver.navigate().refresh();
	}
	
	public String getCurrentTabAddress() {
		return driver.getWindowHandle();
	}
	
	public Set<String> getAllTabAddress() {
		return driver.getWindowHandles();
	}
	
	public Alert switchToAlert() {
		return driver.switchTo().alert();
	}
	
	public void changeTowindow(String Address) {
		driver.switchTo().window(Address);
	}
	
	public void changetoFrame(int index) {
		driver.switchTo().frame(index);
	}
	
	public void changetoFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
}
