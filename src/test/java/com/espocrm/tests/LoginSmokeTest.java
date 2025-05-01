package com.espocrm.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.esporcm.base.BaseTest;

public class LoginSmokeTest extends BaseTest {
	
	@Test
	public void verifyPageTitle() throws InterruptedException {
		//Login
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("password");
		
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		
		Thread.sleep(1000);
		String title = driver.findElement(By.xpath("//li[@data-name='Home']//span[2]")).getText();
		System.out.println(title);
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertNotEquals(title, "Home", "Login Done");
		
//		Assert.assertNotEquals(title, "Home", "Login Done");
	}
}
