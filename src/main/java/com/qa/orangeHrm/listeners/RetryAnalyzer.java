package com.qa.orangeHrm.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	private static int count=0;
	private static int maxTry=3;
	
	
	public boolean retry(ITestResult result) {
		if (!result.isSuccess()) {
			if(count < maxTry) {
				System.out.println("IF Retrying");
				count++;
				result.setStatus(result.FAILURE);
				return true;
			}
			else {
				System.out.println("ELSE Retrying");
				result.setStatus(result.FAILURE);
			}
		}
			else{
				System.out.println("Retrying IFELSE");
				result.setStatus(result.SUCCESS);
			}
			return false;
		}
	}
