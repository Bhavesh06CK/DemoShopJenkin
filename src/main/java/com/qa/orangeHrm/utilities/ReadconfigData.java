package com.qa.orangeHrm.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadconfigData {
	public Properties prop;
	
	public ReadconfigData()throws IOException{
		FileInputStream fis = new FileInputStream("C:\\Users\\Belliappa CK\\eclipse-workspace\\DemoShop_E2E2\\src\\test\\resources\\Config.properties");
		prop = new Properties();
		prop.load(fis);
	}
	
	public String getProperty(String key) {
		return prop.getProperty(key);
	}
}
