package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitleTest() {

		String actTitle = loginPage.getLoginPageTitle();
		System.out.println("page title is:" + actTitle);
		Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2)

	public void loginPageUrlTest() {

		Assert.assertTrue(loginPage.getLoginPageURL());
	}

	@Test(priority = 3)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isforgotPwdLinkExist());
	}

	@Test(priority = 4)
	public void regirsterLinkTest() {
		Assert.assertTrue(loginPage.isRegisterLinkExist());
	}

	@Test(priority = 5)
	public void loginTest() {
		accountsPage =loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(accountsPage.getAccountPageTitle(), Constants.ACCOUNTS_PAGE_TITLE);
	}
}
