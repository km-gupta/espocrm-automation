package com.esporcm.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.espocrm.config.ConfigReader;
import com.espocrm.factory.DriverFactory;
import com.espocrm.pages.DashboardPage;
import com.espocrm.pages.LoginPage;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    
    @BeforeMethod
    public void initializePages() {
    	loginPage = new LoginPage(driver);
    	dashboardPage = new DashboardPage(driver);
    }

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.initDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getAppUrl());
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
