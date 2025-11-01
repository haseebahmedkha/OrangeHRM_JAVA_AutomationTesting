package com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.base.BasePage;
import net.bytebuddy.asm.Advice;

public class ExtentManager extends BasePage {

    private static ExtentReports extentReports;

    // to check the instance
    public static ExtentReports getInstance(){
        if (extentReports == null){
            createInsatnce();
        }
        return extentReports;
    }

    public static ExtentReports createInsatnce(){
        String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("OrangeHRM Automation Report");
        htmlReporter.config().setReportName("Automation Test Execution Report");

        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("Project","OrangeHRM");
        extentReports.setSystemInfo("Tester","Haseeb Ahmed");
        extentReports.setSystemInfo("Environment","QA");

        return extentReports;




    }
}
