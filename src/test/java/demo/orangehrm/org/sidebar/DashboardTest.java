package demo.orangehrm.org.sidebar;

import com.aventstack.extentreports.Status;
import demo.orangehrm.org.SideBar;
import demo.orangehrm.org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * DashboardTest Class
 * ------------------------
 * Tests the Dashboard page functionality.
 * Verifies that the Dashboard title is displayed correctly.
 */
public class DashboardTest extends BaseTest {

    @Test
    public void testDashboardTitle() {
        // Expected dashboard title
        String expectedTitle = "Dashboard";

        // Start ExtentReports test
        extentTest = extentReports.createTest("Verify Dashboard Title");

        // Step 1: Login
        loginPage.delay(15000); // Wait for page to load
        loginPage.enterUsername("Admin");
        extentTest.log(Status.INFO, "Entered valid username: Admin");
        loginPage.enterPassword("admin123");
        extentTest.log(Status.INFO, "Entered valid password");
        loginPage.delay(8000);
        loginPage.clickLoginButton();
        extentTest.log(Status.INFO, "Clicked Login Button");
        loginPage.delay(8000);

        // Step 2: Navigate to Dashboard from Sidebar
        SideBar sideBar = new SideBar();
        sideBar.clickOnDashboard();
        extentTest.log(Status.INFO, "Clicked on Dashboard in Sidebar");

        // Step 3: Get Dashboard title
        Dashboard dashboard = new Dashboard();
        loginPage.delay(8000);
        String actualTitle = dashboard.getDashboardTitle();
        extentTest.log(Status.INFO, "Dashboard title retrieved: " + actualTitle);

        // Step 4: Validate title
        try {
            Assert.assertEquals(actualTitle, expectedTitle, "Dashboard title mismatch");
            extentTest.log(Status.PASS, "Dashboard title is correct: " + actualTitle);
        } catch (AssertionError e) {
            extentTest.log(Status.FAIL, "Dashboard title is incorrect: " + actualTitle);
            throw e;
        }
    }
}
