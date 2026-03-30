package com.qa.orangeHrm.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.orangeHrm.Base.BaseTest;
import com.qa.orangeHrm.listeners.RetryAnalyzer;
import com.qa.orangeHrm.testdata.UserCreationData;


@Listeners(ChainTestListener.class)
public class RegisterTest extends BaseTest{
	@BeforeMethod
	public void doRegister() {
		rp = welcomePg.clickRegisterLink();
	}
	
	@Test(dataProvider = "userData", dataProviderClass =UserCreationData.class,  invocationCount = 1, retryAnalyzer = RetryAnalyzer.class)
	public void doRegisterDetail(String fn,String ln,String email,String psw) {
		rp.selectGender("male");
		String msg=rp.createUser(fn, ln, email, psw);
		assertEquals(msg, "Your registration completed");
		Reporter.log("Assert Successful user created", true);//testng Report
		ChainTestListener.log("Assert Successful user created");//chainTest Report
		closeApplication();
	}
	
}
