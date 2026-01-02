package demo.orangehrm.org.sidebar;

import com.aventstack.extentreports.Status;
import demo.orangehrm.org.SideBar;
import demo.orangehrm.org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * LeaveTest Class
 * ------------------------
 * Verifies that the Leave page is accessible and the title is displayed correctly.
 */
public class LeaveTest extends BaseTest {

    @Test
    public void testLeaveTitle() {
        // Expected Leave page title
        String expectedTitle = "Leave";

        // Start ExtentReports test
        extentTest = extentReports.createTest("Verify Leave Title");

        // Step 1: Login to OrangeHRM
        loginPage.delay(15000); // Wait for page to load
        loginPage.enterUsername("Admin");
        extentTest.log(Status.INFO, "Entered valid username: Admin");
        loginPage.enterPassword("admin123");
        extentTest.log(Status.INFO, "Entered valid password");
        loginPage.delay(8000);
        loginPage.clickLoginButton();
        extentTest.log(Status.INFO, "Clicked Login Button");

        // Step 2: Navigate to Leave page via Sidebar
        SideBar sideBar = new SideBar();
        loginPage.delay(8000);
        sideBar.clickOnLeave();
        extentTest.log(Status.INFO, "Clicked on Leave in Sidebar");
        loginPage.delay(12000);

        // Step 3: Retrieve Leave page title
        Leave leave = new Leave();
        loginPage.delay(10000);
        boolean isTitleDisplayed = leave.isLeaveTitleDisplayed();
        String actualTitle = leave.getLeaveTitleText();
        extentTest.log(Status.INFO, "Leave page title retrieved: " + actualTitle);

        // Step 4: Validate title
        try {
            Assert.assertTrue(isTitleDisplayed, "Leave title is not displayed");
            Assert.assertEquals(actualTitle, expectedTitle, "Leave title mismatch");
            extentTest.log(Status.PASS, "Leave title is correct: " + actualTitle);
        } catch (AssertionError e) {
            extentTest.log(Status.FAIL, "Leave title verification failed: " + actualTitle);
            throw e;
        }
    }
}
