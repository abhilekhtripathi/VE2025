package com.qa.open.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	
	public WebDriver driver;
	public Properties prop;
	
	/**
	 * this is use inialize the webdriver 
	 * @param browserName
	 * @return this will return the driver 
	 */
	
	public WebDriver init_driver(Properties prop) {
		
		String browserName = prop.getProperty("browser").trim();
		System.out.println("the broser name is :"+ browserName);
		if (browserName.equals("chrome")) {
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
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		return driver;
		
	}
	
	/**
	 * this method is inialize the properties prop
	 * @return  this is retuen by prop refrence 
	 */
	
	  public Properties init_prop() {
		  prop = new Properties();
		  try {
			FileInputStream ip = new FileInputStream("./src/test/Resources/config/config.properties");
               prop.load(ip);			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return prop;
	  }
	
	
	

}
