package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By header = By.cssSelector("div#logo a");
	private By accountsSection = By.cssSelector("div#content h2");
	private By searchTextField = By.name("search");
	private By searchButton = By.cssSelector("div#search button");
	private By logoutButton = By.linkText("Logout");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	public String getAccountPageTitle() {
		return eleUtil.doGetTitle(Constants.ACCOUNTS_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	public String getAccountsPageHeader() {
		return eleUtil.doGetText(header);
	}

	public boolean islogoutLinkExists() {
		return eleUtil.doIsDisplayed(logoutButton);
	}

	public void logout() {
		if (islogoutLinkExists()) {
			eleUtil.doClick(logoutButton);
		}
	}

	public List<String> getAccountSectionList() {
		List<WebElement> accountsectionList = eleUtil.waitForElementsToBeVisible(accountsSection, 10);
		List<String> accSecValList = new ArrayList<String>();
		for (WebElement e : accountsectionList) {
			String text = e.getText();
			accSecValList.add(text);
		}
		return accSecValList;

	}
	
	public boolean isSearchFieldExist() {
		return eleUtil.doIsDisplayed(searchTextField);
	}
	

	public SerachResultsPage doSearch(String productName) {
		System.out.println("the searching the product"  + productName);
		eleUtil.doSendKeys(searchTextField, productName);
		eleUtil.doClick(searchButton);
		
		return new SerachResultsPage(driver);
		
	}
	
	
	
	
	
	

}
