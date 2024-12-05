package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By productHeader = By.xpath("//div[@id='content']");
	private By productImage = By.cssSelector("Ui_themnales img");
	private By productMetaData = By.cssSelector("");
	private By productpriceMetaData = By.cssSelector("");
	private By qty= By.id("input_Quantity");
	private By addToCartBUtton = By.id("button-cart");
	
	private Map<String , String> productInfoPage; 

	public void ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getProductHeader() {
		String productHeadertext = eleUtil.doGetText(productHeader);
		System.out.println("the product header is :" + productHeader);

		return productHeadertext;
	}
	
	public int getProductImageCount() {
		return eleUtil.waitForElementsToBeVisible(productImage, 10).size();
	}
     public void getProdutInfo() {
    	 productInfoPage = new HashMap<String, String>();
     }
}
