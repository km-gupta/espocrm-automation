package com.espocrm.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.espocrm.utils.LoggerUtil;
import com.espocrm.utils.WaitUtils;

public class LoginPage {

	WebDriver driver;
	private static final Logger log = LoggerUtil.getLogger(LoginPage.class);

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

	public void enterUsername(String username) {
		log.info("Entering username: " + username);
		WaitUtils.waitForVisibility(driver, usernameField);
		usernameField.sendKeys(username);
		
	}
	
	public void enterPassword(String password) {
		log.info("Entering username: " + password);
		WaitUtils.waitForVisibility(driver, passwordField);
		passwordField.sendKeys(password);
		
	}

	public void clickLogin() {
        log.info("Clicking login button");
		WaitUtils.waitForVisibility(driver, loginButton);
		loginButton.click();
		
	}

}
