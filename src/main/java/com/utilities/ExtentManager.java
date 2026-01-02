package com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.base.BasePage;

/**
 * ExtentManager
 * --------------
 * This class is responsible for creating and managing
 * a single instance of ExtentReports using the Singleton pattern.
 *
 * It ensures that only one report instance is used
 * throughout the test execution.
 */
public class ExtentManager extends BasePage {

    /**
     * Static ExtentReports instance
     */
    private static ExtentReports extentReports;

    /**
     * Returns the ExtentReports instance.
     * If the instance does not exist, it creates one.
     *
     * @return ExtentReports instance
     */
    public static ExtentReports getInstance(){
        if (extentReports == null){
            createInsatnce();
        }
        return extentReports;
    }

    /**
     * Creates and configures the ExtentReports instance.
     *
     * @return Configured ExtentReports object
     */
    private static ExtentReports createInsatnce(){
        // Report file path
        String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";

        // Spark reporter for HTML report generation
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);

        // Report UI configurations
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("OrangeHRM Automation Report");
        htmlReporter.config().setReportName("Automation Test Execution Report");

        // Create ExtentReports instance
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);

        // System information shown in report
        extentReports.setSystemInfo("Project", "OrangeHRM");
        extentReports.setSystemInfo("Tester", "Haseeb Ahmed");
        extentReports.setSystemInfo("Environment", "QA");

        return extentReports;
    }
}
