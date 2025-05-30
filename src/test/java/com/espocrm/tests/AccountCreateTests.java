package com.espocrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.espocrm.pages.AccountPage;
import com.espocrm.pages.CreateAccountPage;
import com.espocrm.pages.DashboardPage;
import com.espocrm.pages.LoginPage;
import com.esporcm.base.BaseTest;

public class AccountCreateTests extends BaseTest {
	
	@Test
	public void accountCreationTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("admin");
        loginPage.enterPassword("password");
        loginPage.clickLogin();
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.clickOnAccountField();
		
		AccountPage accountPage = new AccountPage(driver);
		accountPage.clickOnCreateAccount();
		
		CreateAccountPage createAccountPage = new CreateAccountPage(driver);
		createAccountPage.enterNameField("Krishna");
		createAccountPage.enterWebsitField("https://www.google.com/");
		createAccountPage.enterEmailField("email@domain.com");
		createAccountPage.enterPhoneField("9856985698");
		createAccountPage.clickSaveButton();
		
		Thread.sleep(10000000);
	}
	
	
}

