package com.espocrm.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
            spark.config().setReportName("EspoCRM Automation Report");
            spark.config().setDocumentTitle("Test Results");
            spark.config().setTheme(Theme.DARK); // or Theme.STANDARD
            spark.config().setDocumentTitle("EspoCRM Test Report");
            spark.config().setReportName("Automation Execution Results");
            spark.config().setTimeStampFormat("dd-MM-yyyy HH:mm:ss");		
            
            
            extent = new ExtentReports();
            extent.attachReporter(spark);
            
            // Add environment/system info
            extent.setSystemInfo("Tester", "Krishna");
            extent.setSystemInfo("Environment", "Localhost");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Browser", "Chrome"); // Update as needed
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        }
        return extent;
    }
}

