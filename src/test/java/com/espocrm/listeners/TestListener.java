package com.espocrm.listeners;

import com.aventstack.extentreports.Status;
import com.espocrm.config.ConfigReader;
import com.espocrm.factory.DriverFactory;
import com.espocrm.reports.ExtentTestManager;
import com.espocrm.utils.LoggerUtil;
import com.espocrm.utils.ScreenshotUtils;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	private long startTime;

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		String author = ConfigReader.getProperty("author");
		String category = result.getTestClass().getRealClass().getSimpleName();
		ExtentTestManager.startTest(testName, author, category);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().log(Status.PASS, "Test Passed!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		Class<?> className = result.getTestClass().getRealClass();
		WebDriver driver = DriverFactory.getDriver();

		String screenshotPath = ScreenshotUtils.captureScreenshot(driver, testName);

		// Log to ExtentReports
		ExtentTestManager.getTest().fail("Test Failed. Screenshot below:").addScreenCaptureFromPath(screenshotPath);
		
	    // Log to Log4j
	    Logger log = LoggerUtil.getLogger(className);
	    log.error("Test failed. Screenshot saved at: " + screenshotPath);
		
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed:", result.getThrowable(), null);
		ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		startTime = System.currentTimeMillis();
	}

	@Override
	public void onFinish(ITestContext context) {
		long endTime = System.currentTimeMillis();
		long durationInSeconds = (endTime - startTime) / 1000;

		ExtentTestManager.getTest().log(Status.INFO, "⏱ Total execution time: " + durationInSeconds + " seconds");
		ExtentTestManager.endTest();
	}
}
