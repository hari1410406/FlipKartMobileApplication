package com.appium.pomclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appium.MobileUtility.UtilityObjectClass;

public class SearchProductPage {
	
	@FindBy(xpath="//android.widget.TextView[@text='Search for products']")
	private WebElement searchProductsTextbox;
	
	@FindBy(xpath="//android.widget.EditText[@text='Search for Products, Brands and More']")
	private WebElement searchProductsEnterText;
	
		public SearchProductPage() {
		PageFactory.initElements(UtilityObjectClass.getDriver(),this);
	}
	
	public void getSearchTextbox() {
		searchProductsTextbox.click();
	}
	
	public void getEnterText(String value) {
		searchProductsEnterText.sendKeys(value);
	}
	
	
	
	
	
	

}
