package com.qa.opencart.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.open.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {

	DriverFactory df;
	WebDriver driver;
	LoginPage loginPage;
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		driver = df.init_driver("chrome");
		loginPage = new LoginPage(driver);
	}

	@AfterTest

	public void tearDown() {
		driver.quit();
	}

}
