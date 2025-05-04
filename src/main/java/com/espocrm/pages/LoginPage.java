package com.espocrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.espocrm.utils.WaitUtils;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = "//input[@name=\"username\"]")
	private WebElement usernameField;

	@FindBy(xpath = "//input[@name=\"password\"]")
	private WebElement passwordField;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login(String username, String password) {
		WaitUtils.waitForVisibility(driver, usernameField);
		usernameField.sendKeys(username);

		WaitUtils.waitForVisibility(driver, passwordField);
		passwordField.sendKeys(password);

		WaitUtils.waitForVisibility(driver, loginButton);
		loginButton.click();
	}

}
