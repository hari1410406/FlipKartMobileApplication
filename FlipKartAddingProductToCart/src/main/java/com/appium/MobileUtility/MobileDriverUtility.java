package com.appium.MobileUtility;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;



public class MobileDriverUtility {

	AndroidDriver<WebElement> driver=UtilityObjectClass.getDriver();;

	public AndroidDriver<WebElement> intializeAndroidDriver(URL url,DesiredCapabilities capabilities) {
		return driver=new AndroidDriver<WebElement>(url,capabilities);
	}

	/**
	 * this method is used install the app
	 * Should give app location as path
	 * @param path
	 */
	public void installApp(String path) {
		driver.installApp(path);
	}

	public void launchApp() {
		driver.launchApp();
	}

	public void closeApp() {
		driver.closeApp();
	}

	public void switchToAnotherApp(String appPackage,String appActivity) {
		driver.startActivity(appPackage, appActivity);
	}

	public void singletapOnElement(MobileElement element, int duration, int finger) {
		driver.tap(finger, element, duration);
	}
	public void singletapOnCoOrdinate(int x, int y, int duration, int finger) {
		driver.tap(finger, x, y, duration);
	}

	public void swipe(int start_x, int start_y, int end_x, int end_y ,int duration) throws InterruptedException {
		Thread.sleep(3000);
		driver.swipe(start_x, start_y, end_x, end_y, duration);
	}

	public static void scrollTillElement(AndroidDriver driver, String an, String av) {
		UtilityObjectClass.getDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
	}

	public boolean customWaitToClick(WebElement element, int pollingtime, long timeDuration ) {
		int time=0;
		boolean flag=false;
		while(time<timeDuration) 
		{
			try 
			{
				flag = element.isDisplayed();
				break;
			}
			catch(Exception e) {
				try {
					Thread.sleep(pollingtime);
				}
				catch(InterruptedException e1) {
					e1.printStackTrace();
				}
				time++;
			}
		}
		return flag;
	}


	public void implicitWait(long time) {
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
	}

	public void scrollToElement(AndroidDriver<WebElement> driver, String directions,String elementName,boolean scrollDown) {
		String listId=((RemoteWebElement)driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")).getId();

		String direction;
		if(scrollDown) {
			direction="down";
		}
		else {
			direction="up";
		}

		HashMap<String, String> scrollobject=new HashMap<String,String>();
		scrollobject.put("direction", directions);
		scrollobject.put("element", "listId");
		scrollobject.put("text", elementName);
		driver.executeScript("mobile: scrollTo", scrollobject);
	}

	public void ScrollElement() {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"+exacttext+");
	}
	
	public void getDatePattern() {
		          
		          
		        String dateBefore = "2021-07-10";    
		        System.out.println(dateBefore+" is the date before adding days");  
		          
		        
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		          
		         
		        Calendar cal = Calendar.getInstance();  
		        try{  
		           cal.setTime(sdf.parse(dateBefore));  
		        }catch(Exception e){  
		            e.printStackTrace();  
		         }  
		             
		        
		        cal.add(Calendar.DAY_OF_MONTH, 3);  
		        String dateAfter = sdf.format(cal.getTime());  
		          
		        
		        System.out.println(dateAfter+" is the date after adding 3 days.");  
		    }  

}




/*public class MobileDriverUtility {

	private static AndroidDriver driver=null;

	public  static void scrollTillElement(AndroidDriver driver, String an, String av) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
	}


	public static void  openApplication(String url ) {
		driver.get(url);
	}

	public void swipeAction(int startx, int starty, int endx, int endy, int duration) {
		driver.swipe(startx, starty, endx, endy, duration);
	}

 */


