package com.appium.MobileUtility;

public class JavaUtility {
	
	public String[] splitString(String value,String strategy) {
		return value.split(strategy);
		
	}
	public long convertStringToLong( String value) {
		return Long.parseLong(value);
	}


}
