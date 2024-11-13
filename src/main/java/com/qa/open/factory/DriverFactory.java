package com.qa.open.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	
	public WebDriver driver;
	
	public void setup(String browserName) {
		System.out.println("the broser name is :"+ browserName);
		if (browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		
		else if (browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else  if (browserName.equals("Safari")) {
			//WebDriverManager.firefoxdriver().setup();
			driver= new SafariDriver();
		}
		else {
			System.out.println("please pass the right browser :"+browserName);
		}
		
		
	}

}
