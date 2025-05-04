package com.espocrm.reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

	private static final Map<Integer, ExtentTest> testMap = new HashMap<>();

	public static ExtentTest getTest() {
		return testMap.get((int) Thread.currentThread().getId());
	}

	public static void startTest(String testName, String author, String category) {
		ExtentTest test = ExtentManager.getInstance().createTest(testName).assignAuthor(author)
				.assignCategory(category);
		testMap.put((int) Thread.currentThread().getId(), test);
	}

	public static void endTest() {
		ExtentManager.getInstance().flush();
	}
}
