package com.qa.orangeHrm.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class WelcomePage extends BasePage {
	//locators
		public By links(String linkName) {
			return By.xpath("//a[@href='/" + linkName + "']");
		}

		final private By registerLink = By.xpath("//a[@href='/register']");

		public By menuSelector(String menuName) {
			return By.xpath("//a[@href='/" + menuName + "']");
		}

		final private By logoutlink = By.xpath("//a[@href='/logout']");

		// constructor

		public WelcomePage(WebDriver driver) {
			super(driver);
		}

		// action methods
		@Step("Checking link visibility test")
		public boolean linksVisibilityTest(String linkName) {
			return elementactions.checkElementDisplayed(links(linkName));
		}
		@Step("Selecting Menu by passing ")
		public RegisterPage clickRegisterLink() {
			elementactions.doClick(registerLink);
			return new RegisterPage(driver);
		}

//		public RegisterPage selectMenu(String menuName) {
//			switch (menuName) {
//			case "register": elementactions.doClick(menuSelector(menuName));
//			return new RegisterPage(driver);
////			case "login": elementactions.doClick(menuSelector(menuName));
////			break;
////			case "cart": elementactions.doClick(menuSelector(menuName));
////			break;
////			case "wishlist":elementactions.doClick(menuSelector(menuName));
////			break;
//			default:
//				Reporter.log("Invalid Module Selected", true);
//				throw new FrameworkExceptions("===INVALID MODULE PASSED===");
//			}
//		}
		
		@Step("Logging out from the application")
		public void doLogout() {
			elementactions.doClick(logoutlink);
		}

	}
