package com.qa.orangeHrm.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.orangeHrm.Base.BaseTest;
import com.qa.orangeHrm.testdata.UserCreationData;


@Listeners(ChainTestListener.class)
public class RegisterTest2 extends BaseTest{
	@BeforeMethod
	public void doRegister() {
		rp = welcomePg.clickRegisterLink();
//		dataGen= new FakeDataGenerator();
	}
	
//	@Test(invocationCount = 1)
	@Test(dataProvider = "userData", dataProviderClass =UserCreationData.class,  invocationCount = 1)
	public void doRegisterDetail(String fn,String ln,String email,String psw) {
		rp.selectGender("male");
//		String msg=rp.createUser("Unique","UniqueLN", "Unique123456@gmail.com", "Unique@000");
//		String msg=rp.createUser(dataGen.getFakeFirstName(),dataGen.getFakeLastName(), dataGen.getFakeEmail(),dataGen.getFakePassword());
		String msg=rp.createUser(fn, ln, email, psw);
		assertEquals(msg, "Your registration completed");
		Reporter.log("Assert Successful user created", true);//testng Report
		Reporter.log("Assert Successful user created Rechecked", true);//testng Report
		ChainTestListener.log("Assert Successful user created");//chainTest Report
		closeApplication();
	}
	
}
