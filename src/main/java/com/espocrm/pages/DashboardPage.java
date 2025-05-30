package com.espocrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.espocrm.utils.WaitUtils;

public class DashboardPage {
	private WebDriver driver;
	
//	@FindBy (xpath = "//span[text()='Edit Dashboard']") private WebElement dashboardPage;
	
	@FindBy (linkText = "EspoCRM") private WebElement dashboardTitle;
	@FindBy(xpath ="//input[@placeholder=\"Search\"]") private WebElement searchField;
	@FindBy(xpath = "//li[@data-name='Home']") private WebElement homeField;
	@FindBy(xpath = "//li[@data-name='Account']") private WebElement accountField;
	
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    public boolean isDashboardVisible() throws InterruptedException {
    	
        WaitUtils.waitForVisibility(driver, searchField, 10);
//        Thread.sleep(3000);
//        System.out.println(dashboardPage.isDisplayed());

        //Search field is available
        return searchField.isDisplayed();
    }
    
    public void clickOnAccountField() {
    	WaitUtils.waitForVisibility(driver, accountField, 10);
    	accountField.click();
    }
    
}
