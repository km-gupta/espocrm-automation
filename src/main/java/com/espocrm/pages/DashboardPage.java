package com.espocrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.espocrm.utils.WaitUtils;

public class DashboardPage {
	WebDriver driver;
	
//	@FindBy (xpath = "//span[text()='Edit Dashboard']") private WebElement dashboardPage;
	
	@FindBy (linkText = "EspoCRM") private WebElement dashboardTitle;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    public boolean isDashboardVisible() throws InterruptedException {
    	
        WaitUtils.waitForVisibility(driver, dashboardTitle, 10);
        Thread.sleep(3000);
//        System.out.println(dashboardPage.isDisplayed());
        if(dashboardTitle.isDisplayed()) {
        	return true;
        }
        return false;
    }
}
