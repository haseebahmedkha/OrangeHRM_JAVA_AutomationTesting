package demo.orangehrm.org.sidebar;

import com.aventstack.extentreports.Status;
import demo.orangehrm.org.SideBar;
import demo.orangehrm.org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * PerformanceTest Class
 * ------------------------
 * Verifies that the Performance page and Manage Reviews section titles are displayed correctly.
 */
public class PerformanceTest extends BaseTest {

    @Test
    public void testPerformanceAndManageReviewTitle() {
        // Expected Titles
        String expectedPerformanceTitle = "Performance";
        String expectedManageReviewsTitle = "Manage Reviews";

        // Initialize ExtentReports test
        extentTest = extentReports.createTest("Verify Performance and Manage Reviews Titles");

        // Step 1: Login
        loginPage.delay(15000);
        loginPage.enterUsername("Admin");
        extentTest.log(Status.INFO, "Entered valid username: Admin");
        loginPage.enterPassword("admin123");
        extentTest.log(Status.INFO, "Entered valid password");
        loginPage.delay(8000);
        loginPage.clickLoginButton();
        extentTest.log(Status.INFO, "Clicked Login Button");

        // Step 2: Navigate to Performance page
        SideBar sideBar = new SideBar();
        loginPage.delay(8000);
        sideBar.clickOnPerformance();
        extentTest.log(Status.INFO, "Clicked on Performance in Sidebar");

        // Step 3: Get Titles
        Performance performance = new Performance();
        loginPage.delay(8000);
        String actualPerformanceTitle = performance.getPerformanceTitle();
        String actualManageReviewsTitle = performance.getManageReviewTitle();
        extentTest.log(Status.INFO, "Retrieved Performance title: " + actualPerformanceTitle);
        extentTest.log(Status.INFO, "Retrieved Manage Reviews title: " + actualManageReviewsTitle);

        // Step 4: Validate Titles
        try {
            Assert.assertEquals(actualPerformanceTitle, expectedPerformanceTitle, "Performance title mismatch");
            Assert.assertEquals(actualManageReviewsTitle, expectedManageReviewsTitle, "Manage Reviews title mismatch");
            extentTest.log(Status.PASS, "Performance and Manage Reviews titles are correct: "
                    + actualPerformanceTitle + " / " + actualManageReviewsTitle);
        } catch (AssertionError e) {
            extentTest.log(Status.FAIL, "Title verification failed: "
                    + actualPerformanceTitle + " / " + actualManageReviewsTitle);
            throw e;
        }
    }
}
