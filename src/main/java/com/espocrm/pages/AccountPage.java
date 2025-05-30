package com.espocrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.espocrm.utils.WaitUtils;

import org.openqa.selenium.support.FindBy;

public class AccountPage {
	private WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@data-name='create']") private WebElement createAccountField;
	
	public void clickOnCreateAccount() {
		WaitUtils.waitForVisibility(driver, createAccountField);
		createAccountField.click();
	}

}
