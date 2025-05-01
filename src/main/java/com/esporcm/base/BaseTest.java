package com.esporcm.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	
	//Browser Setup
	@BeforeSuite
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://localhost:8080/");
		
	}
	
	
	//Browser TearDown
	@AfterSuite
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
	
	
	
}
