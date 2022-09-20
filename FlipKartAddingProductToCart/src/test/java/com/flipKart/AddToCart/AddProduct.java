package com.flipKart.AddToCart;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.appium.MobileUtility.BaseClass;

public class AddProduct extends BaseClass{
	
	@Test
	public void addProductTest() throws InterruptedException {
		
		searchPage.getSearchTextbox();
		String productSearchName = excelFile.getExcelData(1, 0, "CartPage");
		searchPage.getEnterText(productSearchName);
		cartPage.clickProduct();
		String expected = cartPage.getFirstProduct();
		System.out.println(expected);
		cartPage.clickOnFirstProduct();
		cartPage.clickonAddToCartButton();
		String actual = cartPage.actualProductInCart();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		
		
		
		
		
	}

}
