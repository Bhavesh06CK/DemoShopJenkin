package com.qa.orangeHrm.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import io.qameta.allure.Step;

public class RegisterPage extends BasePage {
	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	public By genderSelection(String genderName) {
		return By.xpath("//input[@id='gender-" + genderName + "']");
	}

	private final By fnTf=By.id("FirstName");
	private final By lnTf=By.id("LastName");
	private final By emailTf=By.id("Email");
	private final By pswTf=By.id("Password");
	private final By confirmpsw=By.id("ConfirmPassword");
	private final By registrBtn=By.xpath("//input[@id='register-button']");
	private final By confirmationMsg=By.xpath("//div[@class='result']");
	
	
	@Step("We are selecting gender :{0}")
	public void selectGender(String genderName) {
		elementactions.doClick(genderSelection(genderName));
	}
	
	@Step("We are creating users by entering fn:{0}, ln:{1}, email:{2}, psw:{3}")
	public String createUser(String fn, String ln,String email, String psw) {
		elementactions.doEnterValue(fn, fnTf);
		Reporter.log(fn, true);
		elementactions.doEnterValue(ln, lnTf);
		Reporter.log(ln, true);
		elementactions.doEnterValue(email, emailTf);
		Reporter.log(email, true);
		elementactions.doEnterValue(psw, pswTf);
		Reporter.log(psw, true);
		elementactions.doEnterValue(psw, confirmpsw);
		Reporter.log(psw, true);
		elementactions.doClick(registrBtn);
		return elementactions.fetchElementText(confirmationMsg);
		
		
	}
	
}
