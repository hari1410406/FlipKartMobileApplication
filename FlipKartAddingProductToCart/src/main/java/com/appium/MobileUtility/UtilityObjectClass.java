package com.appium.MobileUtility;

import io.appium.java_client.android.AndroidDriver;

public class UtilityObjectClass {
public static ThreadLocal<AndroidDriver>driver=new ThreadLocal();

public static AndroidDriver getDriver() {
	return driver.get();
}

public static void setDriver(AndroidDriver actdriver) {
	driver.set(actdriver);
}

}
