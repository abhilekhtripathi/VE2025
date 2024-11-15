package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	// declare private driver
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 2 create a page constructor

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil  = new ElementUtil(driver);
	}

	// 3 By Locators

	private By emailID = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//button[text()='Login']");////button[text()='Login']////input[@value='Login']
	private By registerLink = By.linkText("Register");
	private By forgotPwdLink = By.linkText("Forgotten Password");

	// page actions

	public String getLoginPageTitle() {
		return eleUtil.doGetTitle(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}
	
	public boolean getLoginPageURL() {
		return eleUtil.waitForURLToContain(Constants.LOGIN_PAGE_URL_FRACTION,Constants.DEFAULT_TIME_OUT);
	}
	
	public boolean isforgotPwdLinkExist() {
		return eleUtil.doIsDisplayed(forgotPwdLink);
	}
	
	public boolean isRegisterLinkExist() {
		return eleUtil.doIsDisplayed(registerLink);
	}
	
	public void doLogin(String un, String pwd) {
		System.out.println("login with :" + un + " :" + pwd);
		eleUtil.doSendKeys(emailID, un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		
		
	}

}
