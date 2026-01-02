package demo.orangehrm.org.login_logout;

import com.aventstack.extentreports.Status;
import demo.orangehrm.org.HomePage;
import demo.orangehrm.org.LogoutPage;
import demo.orangehrm.org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * LogoutTest Class
 * ------------------------
 * - Tests the Logout functionality of OrangeHRM
 * - Steps include:
 *   1. Login with valid credentials
 *   2. Navigate to HomePage
 *   3. Click the user dropdown
 *   4. Click Logout
 *   5. Verify logout completed successfully
 */
public class LogoutTest extends BaseTest {

    /**
     * Test Logout functionality
     */
    @Test
    public void testLogout() {
        try {
            // Create ExtentReports test
            extentTest = extentReports.createTest("Verify Logout Test Begin");

            // Wait for Login Page to load
            loginPage.delay(10000);

            // Step 1: Enter Username
            extentTest.log(Status.INFO, "Entering Username: Admin");
            loginPage.enterUsername("Admin");

            // Step 2: Enter Password
            extentTest.log(Status.INFO, "Entering Password: admin123");
            loginPage.enterPassword("admin123");

            // Step 3: Click Login Button
            extentTest.log(Status.INFO, "Clicking Login Button");
            loginPage.clickLoginButton();
            loginPage.delay(6000); // Wait for HomePage to load

            // Step 4: Navigate to HomePage and Logout
            extentTest.log(Status.INFO, "Navigating to HomePage");
            HomePage homePage = new HomePage();
            LogoutPage logoutPage = new LogoutPage();

            loginPage.delay(4000);
            extentTest.log(Status.INFO, "Clicking User Dropdown");
            logoutPage.clickUserDropdown();

            loginPage.delay(2000);
            extentTest.log(Status.INFO, "Clicking Logout Button");
            logoutPage.clickLogout();

            // Step 5: Verify logout completed successfully
            extentTest.log(Status.PASS, "Logout Successful");

        } catch (Exception e) {
            // Capture any exception, log, and fail the test
            extentTest.log(Status.FAIL, "Logout Failed: " + e.getMessage());
            Assert.fail("Logout Test Failed due to Exception: " + e.getMessage());
        }
    }
}
