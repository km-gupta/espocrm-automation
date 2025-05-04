package com.espocrm.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	private static final int DEFAULT_TIMEOUT = 5;

	public static void waitForVisibility(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForVisibility(WebDriver driver, WebElement element,int seconds) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOf(element));
	}

}
