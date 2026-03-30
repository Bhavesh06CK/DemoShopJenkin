package com.qa.orangeHrm.Validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.orangeHrm.exceptions.ElementExceptions;

public class ValidationHelper {

	public static void ValidateLocator(By locator, String methodName) {
		if (locator==null) {
			throw new ElementExceptions("===[Validatelocator] the specified locator cannot be null \n"+ locator +" "
					+"used in method"+methodName+"===");
		}
		if (methodName==null) {
			throw new ElementExceptions("===[Validatelocator] the specified methodName cannot be null \n"+ methodName +" "
					+"used in method"+methodName+"===");
		}
	}

	public static void ValidateElement(WebElement element, String methodName) {
		if (element==null) {
			throw new ElementExceptions("===[ValidateElement] the specified element cannot be null \n"+ element +" "
					+"used in method"+methodName+"===");
		}
		if (methodName==null) {
			throw new ElementExceptions("===[ValidateElement] the specified methodName cannot be null \n"+ methodName +" "
					+"used in method"+methodName+"===");
		}
	}
	public static void ValidateString(String value, String methodName) {
		if (value==null) {
			throw new ElementExceptions("===[ValidateString] the specified value cannot be null \n"+ value +" "
					+"used in method"+methodName+"===");
		}
		if (methodName==null) {
			throw new ElementExceptions("===[ValidateString] the specified methodName cannot be null \n"+ methodName +" "
					+"used in method"+methodName+"===");
		}
	}
	
}
