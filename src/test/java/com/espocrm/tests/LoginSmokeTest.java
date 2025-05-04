package com.espocrm.tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.espocrm.config.ConfigReader;
import com.espocrm.dataprovider.LoginDataProvider;
import com.espocrm.pages.DashboardPage;
import com.espocrm.pages.LoginPage;
import com.espocrm.reports.ExtentTestManager;
import com.esporcm.base.BaseTest;

public class LoginSmokeTest extends BaseTest {

	@Test(dataProvider = "loginCredentials", dataProviderClass = LoginDataProvider.class)
	public void testLogin(String username, String password, boolean expectedResult) throws InterruptedException {
		
		
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        ExtentTestManager.getTest().log(Status.INFO, "Entered username: " + username);

        loginPage.enterPassword(password);
        ExtentTestManager.getTest().log(Status.INFO, "Entered password: " + password);

        loginPage.clickLogin();
        ExtentTestManager.getTest().log(Status.INFO, "Clicked Login button");
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		boolean actualResult = dashboardPage.isDashboardVisible();
		

        ExtentTestManager.getTest().log(Status.INFO, "Login success? " + actualResult);
		
		Assert.assertEquals(actualResult, expectedResult, "Login result does not match expected outcome.");
	}

	/*
	 * @Test(description = "Verify that user can login with valid credentials")
	 * public void testValidLogin() throws InterruptedException { LoginPage
	 * loginPage = new LoginPage(driver);
	 * loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword());
	 * 
	 * DashboardPage dashboardPage = new DashboardPage(driver); boolean isLoggedIn =
	 * dashboardPage.isDashboardVisible();
	 * 
	 * Assert.assertTrue(isLoggedIn, "Login failed or dashboard not visible."); }
	 */

	/*
	 * @Test public void verifyPageTitle() {
	 * 
	 * boolean title = false;
	 * 
	 * LoginPage login = new LoginPage(driver); login.login("admin", "password"); //
	 * Login
	 * 
	 * DashboardPage dashboard = new DashboardPage(driver); title =
	 * dashboard.isDashboardVisible();
	 * 
	 * SoftAssert softAssert = new SoftAssert(); softAssert.assertEquals(title,
	 * true);
	 * 
	 * Assert.assertTrue(title, "Login Failed");
	 * 
	 * // Assert.assertNotEquals(title, "Dashboard", "Login Done"); }
	 */

}
