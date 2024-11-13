package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	// declare private driver
	private WebDriver driver;

	// 2 create a page constructor

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3 By Locators

	private By emailID = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//button[text()='Login']");////button[text()='Login']////input[@value='Login']
	private By registerLink = By.linkText("Register");
	private By forgotPwdLink = By.linkText("Forgotten Password");

	// page actions

	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String getLoginPageURL() {
		return driver.getCurrentUrl();
	}
	
	public boolean isforgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public boolean isRegisterLinkExist() {
		return driver.findElement(registerLink).isDisplayed();
	}
	
	public void doLogin(String un, String pwd) {
		System.out.println("login with :" + un + " :" + pwd);
		driver.findElement(emailID).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		
		
	}

}
