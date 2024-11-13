package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest {

	@Test(priority=1)
	public void loginPageTitleTest() {

		String actTitle = loginPage.getLoginPageTitle();
		System.out.println("page title is:" + actTitle);
		Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority=2)

	public void loginPageUrlTest() {
		String Acturl = loginPage.getLoginPageURL();
		System.out.println("page url is:" + Acturl);
		Assert.assertTrue(Acturl.contains(Constants.LOGIN_PAGE_URL_FRACTION));
	}

	@Test(priority=3)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isforgotPwdLinkExist());
	}

	@Test(priority=4)
	public void regirsterLinkTest() {
		Assert.assertTrue(loginPage.isRegisterLinkExist());
	}

	@Test(priority=5)
	public void loginTest() {
		loginPage.doLogin("abhilekhtripathi8@gmail.com", "Abhilekh@123");
	}
}
