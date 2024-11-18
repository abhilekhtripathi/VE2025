package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetUp() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void accaPageTitleTest() {
		String actualTilte = accountsPage.getAccountPageTitle();
		System.out.println("this is account page title is : " + actualTilte);
		Assert.assertEquals(actualTilte, Constants.ACCOUNTS_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void accPageHeaderTest() {
		String header = accountsPage.getAccountsPageHeader();
		System.out.println("this is account page title is : " + header);
		Assert.assertEquals(header, Constants.ACCOUNTS_PAGE_HEADER);
	}

	@Test(priority = 3)
	public void isLogoutLinkTest() {
		Assert.assertTrue(accountsPage.islogoutLinkExists());
	}

	@Test(priority = 4)
	public void accPageSectionsTest() {
		List<String> ActaccSecList = accountsPage.getAccountSectionList();
		Assert.assertEquals(ActaccSecList, Constants.getExpectedAccSecList());
	}

	@DataProvider

	public Object[][] productData() {
		return new Object[][] { { "MackBook Pro" }, { "Apple" }, { "Samsung" } };

	}

	@Test(priority = 5, dataProvider = "productData")
	public void searchTest(String productName) {
		searchResultPage = accountsPage.doSearch(productName);
		Assert.assertTrue(searchResultPage.getProductListCount() > 0);
	}

}
