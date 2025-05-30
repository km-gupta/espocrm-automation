package com.espocrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.espocrm.utils.WaitUtils;

import org.openqa.selenium.support.FindBy;

public class EditAccountPage {
	private WebDriver driver;

	public EditAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@data-name='name']/input") private WebElement nameField;
	@FindBy(xpath = "//div[@data-name='website']/input") private WebElement websiteField;
	@FindBy(xpath = "//div[@data-name='emailAddress']//input") private WebElement emailField;
	@FindBy(xpath = "//div[@data-name='phoneNumber']//span[2]//input") private WebElement phoneField;
	@FindBy(xpath = "//button[@data-action='save']") private WebElement saveButton;
	@FindBy(xpath = "//button[@data-action='cancel']") private WebElement cancelButton;
	
	public void enterNameField(String name) {
//		log.info("Entering name: " + name);
		WaitUtils.waitForVisibility(driver, nameField);
		nameField.sendKeys(name);
	}
	
	public void enterWebsitField(String URL) {
		WaitUtils.waitForVisibility(driver, websiteField);
		websiteField.sendKeys(URL);
	}
	
	public void enterEmailField(String email) {
		WaitUtils.waitForVisibility(driver, emailField);
		emailField.sendKeys(email);
	}
	
	public void enterPhoneField(String phone) {
		WaitUtils.waitForVisibility(driver, phoneField);
		phoneField.sendKeys(phone);
	}
	
	public void clickSaveButton() {
		WaitUtils.waitForVisibility(driver, saveButton);
		saveButton.click();
	}
	
	public void clickCancelButton() {
		WaitUtils.waitForVisibility(driver, cancelButton);
		cancelButton.click();
	}
}
