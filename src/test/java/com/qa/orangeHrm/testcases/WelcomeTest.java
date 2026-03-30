package com.qa.orangeHrm.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.orangeHrm.Base.BaseTest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
@Listeners(ChainTestListener.class)

public class WelcomeTest extends BaseTest {
	@Epic("SRS_001")
	@Feature("RegisterPage")
	@Story("Register_Visibility")
	@Test
	public void registerVisible() {
		Boolean flag=welcomePg.linksVisibilityTest("register");
		assertTrue(flag);
		Reporter.log("RegisterPage Validated",true);
		ChainTestListener.log("RegisterPage Validated");//chainTest Report
	}
	@Epic("SRS_001")
	@Feature("LoginPage")
	@Story("Login_Visibility")
	@Test
	public void loginVisible() {
		Boolean flag= welcomePg.linksVisibilityTest("login");
		assertTrue(flag);
		Reporter.log("LoginPage Validated", true);
		ChainTestListener.log("LoginPage Validated");
//		Assert.fail();
	}
	
	@Epic("SRS_001")
	@Feature("WelcomeModule")
	@Story("Cart_Visibility")
	@Test
	public void cartVisible() {
		Boolean flag=welcomePg.linksVisibilityTest("cart");
		assertTrue(flag);
		Reporter.log("CartPage Validated", true);
		ChainTestListener.log("CartPage Validated");
	}
	
	@Epic("SRS_001")
	@Feature("WishListModule")
	@Story("WishList_Visibility")
	@Test
	public void wishlistVisible() {
		Boolean flag=welcomePg.linksVisibilityTest("wishlist");
		assertTrue(flag);
		Reporter.log("WishlistPage Validated", true);
		ChainTestListener.log("WishListPage Validated");
	}
	

}
