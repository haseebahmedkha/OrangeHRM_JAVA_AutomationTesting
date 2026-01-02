package demo.orangehrm.org.sidebar;

import com.aventstack.extentreports.Status;
import demo.orangehrm.org.SideBar;
import demo.orangehrm.org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * AdminTest Class
 * ------------------------
 * - Tests the Admin Sidebar functionality in OrangeHRM
 * - Verifies that:
 *   1. Admin page title is displayed
 *   2. User Management title is correct
 */
public class AdminTest extends BaseTest {

    @Test
    public void testAdminTitleAndUserManagementTitle() {
        // Expected text for verification
        String expectedUserManagementTitle = "User Management";

        // Start ExtentReports logging
        extentTest = extentReports.createTest("Verify Admin and User Management Titles");

        // Step 1: Login
        loginPage.delay(10000); // Wait for page to load
        loginPage.enterUsername("Admin");
        extentTest.log(Status.INFO, "Entered valid username: Admin");
        loginPage.enterPassword("admin123");
        extentTest.log(Status.INFO, "Entered valid password");
        loginPage.clickLoginButton();
        extentTest.log(Status.INFO, "Clicked login button");

        // Step 2: Navigate to Admin from Sidebar
        SideBar sideBar = new SideBar();
        loginPage.delay(10000);
        sideBar.clickOnAdmin();
        loginPage.delay(6000);

        // Step 3: Create Admin page object
        Admin admin = new Admin();
        loginPage.delay(5000);

        // Step 4: Verify Admin title
        boolean isAdminTitleDisplayed = admin.isAdminTitleDisplayed();
        extentTest.log(Status.INFO, "Admin title displayed: " + isAdminTitleDisplayed);
        Assert.assertTrue(isAdminTitleDisplayed, "Admin Title is not displayed");

        // Step 5: Verify User Management title
        String actualUserManagementTitle = admin.getUserManagementTitleText();
        if (actualUserManagementTitle.equals(expectedUserManagementTitle)) {
            extentTest.log(Status.PASS, "User Management title is correct: " + actualUserManagementTitle);
        } else {
            extentTest.log(Status.FAIL, "User Management title mismatch: " + actualUserManagementTitle);
            Assert.fail("Expected User Management title: " + expectedUserManagementTitle +
                    ", but found: " + actualUserManagementTitle);
        }
    }
}
