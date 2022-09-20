package com.appium.MobileUtility;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.appium.pomclass.AddToCartPage;
import com.appium.pomclass.SearchProductPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {

	public AndroidDriver driver=UtilityObjectClass.getDriver();
	public PropertyFileUtiluity fileutility;
	public MobileDriverUtility mobile;
	public ExcelUtilityFile excelFile;
	public AddToCartPage cartPage;
	public SearchProductPage  searchPage;


	@BeforeMethod
	public void openApp() throws MalformedURLException {

		fileutility=new PropertyFileUtiluity();
		excelFile=new ExcelUtilityFile();
		excelFile.initializeExcelFile(IPathConstants.ExcelPath);
		fileutility.initializePropertyFile(IPathConstants.PropertyFilePath);

		String platFormName = fileutility.getDataFromProperty("platformName");
		String platFormVersion = fileutility.getDataFromProperty("platformVersion");
		String deviceID = fileutility.getDataFromProperty("UDID");
		String apppacKage = fileutility.getDataFromProperty("appPackage");
		String appActivity = fileutility.getDataFromProperty("appActivity");
		String serverUrl = fileutility.getDataFromProperty("url");
		String timeouts = fileutility.getDataFromProperty("timeout");
		long longTimeouts = new JavaUtility().convertStringToLong(timeouts);
		DesiredCapabilities dc=new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platFormName);
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, platFormVersion);
		dc.setCapability(MobileCapabilityType.UDID,  deviceID);
		dc.setCapability("appPackage",apppacKage );
		dc.setCapability("appActivity", appActivity );
		dc.setCapability("noReset", true);

		URL ur=new URL(serverUrl);
		AndroidDriver driver=new AndroidDriver(ur, dc);
		UtilityObjectClass.setDriver(driver);
		mobile=new MobileDriverUtility();
		mobile.implicitWait(longTimeouts);
	//	String productSearchName = excelFile.getExcelData(1, 0, "CartPage");
		 cartPage=new AddToCartPage();
	 searchPage=new SearchProductPage();
	}

	@AfterMethod
	public void closeApp() {
		mobile.closeApp();
	}


}
