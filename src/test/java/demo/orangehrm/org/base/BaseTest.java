package demo.orangehrm.org.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.base.BasePage;
import com.utilities.ExtentManager;
import demo.orangehrm.org.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

/**
 * BaseTest Class
 * ----------------
 * - Initializes WebDriver and BasePage
 * - Handles setup and teardown for all tests
 * - Integrates ExtentReports for reporting
 * - Captures screenshots on test failure
 */
public class BaseTest {

    // -------------------------------
    // Reports and WebDriver
    // -------------------------------
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;

    // URL of the application under test
    protected final String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    // -------------------------------
    // TestNG Annotations
    // -------------------------------

    /** Initialize Extent Reports before the test suite starts */
    @BeforeSuite
    public void setUpReport() {
        extentReports = ExtentManager.getInstance();
    }

    /** Initialize WebDriver, BasePage, and LoginPage before each test method */
    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver (you can parameterize to allow Firefox/Edge)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // Setup BasePage and assign driver
        basePage = new BasePage();
        basePage.setDriver(driver);
        basePage.delay(3000); // small wait to allow page load

        // Initialize LoginPage
        loginPage = new LoginPage();
    }

    /**
     * Capture screenshot on test failure
     *
     * @param testResult - TestNG result object
     */
    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);

            // Define screenshot path with test name and date
            String screenshotPath = System.getProperty("user.dir") + "/resources/screenshots/"
                    + "(" + LocalDate.now() + ")_" + testResult.getName() + ".png";

            try {
                FileHandler.copy(source, new File(screenshotPath));
                System.out.println("Screenshot saved at: " + screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /** Close WebDriver after each test method */
    @AfterMethod
    public void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    /** Flush Extent Reports after the suite ends */
    @AfterSuite
    public void tearDownReport() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}
