package com.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class SetProperties {

	Properties prop;

	public SetProperties() {
		File file = new File("./configuration/common.properties");

		try {
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public String getApplicationUrl() {
		String url = prop.getProperty("baseUrl");
		return url;
	}
	
	public String getUsername() {
		String username=prop.getProperty("username");
		return username;
		
	}

}
