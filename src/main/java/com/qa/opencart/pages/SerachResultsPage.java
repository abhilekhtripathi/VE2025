package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class SerachResultsPage {
   private WebDriver driver;
   private ElementUtil eleUtil;
   
   
   private By productResults = By.cssSelector("div.caption a");
   
   
   public  SerachResultsPage(WebDriver driver) {
	   this.driver=driver;
	   eleUtil = new ElementUtil(driver);
   }
   
   
   
   public int getProductListCount() {
	int  resultcount   = eleUtil.waitForElementsToBeVisible(productResults, 10, 2000).size();
	System.out.println("the serach result count is " + resultcount);
	return resultcount;
	   
   }
      public ProductInfoPage selectProduct(String mainProductName) {
    	  System.out.println("main product name is :"+ mainProductName);
    	  List<WebElement> searchList = eleUtil.waitForElementsToBeVisible(productResults, 10, 2000);
    	  for (WebElement e : searchList) {
			          String text = e.getText();
			          if (text.equals(mainProductName)) {
						e.click();
						break;
					}
		}
    	  
    	  return new ProductInfoPage();
    	  
      }
   
   
}
