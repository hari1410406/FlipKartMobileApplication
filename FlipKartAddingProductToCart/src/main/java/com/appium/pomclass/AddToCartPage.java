package com.appium.pomclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appium.MobileUtility.UtilityObjectClass;

public class AddToCartPage {
	
	@FindBy(xpath="//android.widget.TextView[@text='winter heater']")
	private WebElement EnteredTextFirstOption;
	
	@FindBy(xpath="//android.widget.TextView[@index='1']")
	private WebElement ProductClick;
	
	@FindBy(xpath="//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[1]")
	private WebElement productGetText;
	
	@FindBy(xpath="//android.widget.TextView[@text='Go to cart']")
	private WebElement addToCartButton;
	
	@FindBy(xpath="//android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[1]")
	private WebElement actualCartProduct;
	
	
	/*@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[1]"));
	private WebElement dharsanamProduct;*/
	
	public AddToCartPage() {
		PageFactory.initElements(UtilityObjectClass.getDriver(),this);
	}
	
	public void EnterProductText() {
		EnteredTextFirstOption.click();
	}
	
	public void clickonAddToCartButton() {
		addToCartButton.click();
	}
	
	public String getProductText() {
		String text = productGetText.getText().trim();
		return text;
	}
/*	public String clickOnProduct() {
		return ProductClick.getAttribute("text").trim();
	//	ProductClick.click();	
	}*/
	public void clickProduct() {
		
			ProductClick.click();
			
	}
	public String getFirstProduct() {
		return productGetText.getText().trim();
	}
	
	public void clickOnFirstProduct() {
		productGetText.click();
	}
	
	public String actualProductInCart() {
		return actualCartProduct.getText().trim();
	}
	
	


}
