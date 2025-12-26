package demo.orangehrm.org.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.base.BasePage;
import com.utilities.ExtentManager;
import demo.orangehrm.org.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeSuite
    public void SetUpReport(){
        extentReports = ExtentManager.getInstance();
    }


    // its run before any test
    @BeforeMethod
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        basePage = new BasePage();
        basePage.setDriver(driver);
        basePage.delay(5000);
        loginPage = new LoginPage();
    }

    // for taking ScreenShot when Test Case got failed
    @AfterMethod
    public void takeScreenShotOnFailureResult(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshots/(" +
                    java.time.LocalDate.now() + testResult.getName() + ".png");
            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("ScreenShor Located at:" + destination);

        }

    }

    // its run after execution of any testcase
    @AfterMethod
    public void driverClosed () {
        driver.quit();
    }

    // Writes the report to the file
    @AfterSuite
    public void tearDownReport(){
        extentReports.flush();
    }

}


