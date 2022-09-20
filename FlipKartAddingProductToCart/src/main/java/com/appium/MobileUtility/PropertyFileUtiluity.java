package com.appium.MobileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtiluity {
	private FileInputStream fis;
	private Properties properties;
	
	
public void initializePropertyFile(String propertyFileFath) {
		
		try {
			fis=new FileInputStream(propertyFileFath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 properties=new Properties();
		try {
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    


	/**
	 * This method is used to fetch the data from property file
	 * @param key
	 * @return
	 */

	public String getDataFromProperty(String key) {
		return properties.getProperty(key);
	}


}
