package demo.orangehrm.org.sidebar;

import com.aventstack.extentreports.Status;
import demo.orangehrm.org.SideBar;
import demo.orangehrm.org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * MyInfoTest Class
 * ------------------------
 * Verifies that the My Info page is accessible and the title is displayed correctly.
 */
public class MyInfoTest extends BaseTest {

    @Test
    public void testMyInfoTitle() {
        // Expected title for My Info page
        String expectedTitle = "My Info";

        // Initialize ExtentReports test
        extentTest = extentReports.createTest("Verify My Info Title");

        // Step 1: Login to OrangeHRM
        loginPage.delay(15000); // Wait for page to load completely
        loginPage.enterUsername("Admin");
        extentTest.log(Status.INFO, "Entered valid username: Admin");
        loginPage.enterPassword("admin123");
        extentTest.log(Status.INFO, "Entered valid password");
        loginPage.delay(8000);
        loginPage.clickLoginButton();
        extentTest.log(Status.INFO, "Clicked Login Button");

        // Step 2: Navigate to My Info page via Sidebar
        SideBar sideBar = new SideBar();
        loginPage.delay(8000);
        sideBar.clickOnMyInfo();
        extentTest.log(Status.INFO, "Clicked on My Info in Sidebar");
        loginPage.delay(12000);

        // Step 3: Retrieve My Info page title
        MyInfo myInfo = new MyInfo();
        loginPage.delay(10000);
        boolean isTitleDisplayed = myInfo.isMyInfoTitleDisplayed();
        String actualTitle = myInfo.getMyInfoTitleText();
        extentTest.log(Status.INFO, "My Info page title retrieved: " + actualTitle);

        // Step 4: Validate title and display status
        try {
            Assert.assertTrue(isTitleDisplayed, "My Info title is not displayed");
            Assert.assertEquals(actualTitle, expectedTitle, "My Info title mismatch");
            extentTest.log(Status.PASS, "My Info title is correct: " + actualTitle);
        } catch (AssertionError e) {
            extentTest.log(Status.FAIL, "My Info title verification failed: " + actualTitle);
            throw e;
        }
    }
}
