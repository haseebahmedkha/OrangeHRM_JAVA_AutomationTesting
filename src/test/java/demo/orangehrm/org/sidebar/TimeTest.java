package demo.orangehrm.org.sidebar;

import com.aventstack.extentreports.Status;
import demo.orangehrm.org.SideBar;
import demo.orangehrm.org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeTest extends BaseTest {

    @Test
    public void testTimeTitle() {
        // Step 0: Define expected titles
        String expectedResult = "Time";
        String expectedTimeSheetTitle = "Timesheets";

        // Step 1: Initialize ExtentReports test
        extentTest = extentReports.createTest("Verify Time Title");

        // Step 2: Login
        loginPage.delay(15000);
        loginPage.enterUsername("Admin");
        extentTest.log(Status.INFO, "Entered valid username: Admin");
        loginPage.enterPassword("admin123");
        extentTest.log(Status.INFO, "Entered valid password");
        loginPage.delay(8000);
        loginPage.clickLoginButton();
        extentTest.log(Status.INFO, "Clicked Login Button");

        // Step 3: Navigate to Time sidebar
        SideBar sideBar = new SideBar();
        loginPage.delay(8000);
        sideBar.clickOnTime();
        extentTest.log(Status.INFO, "Clicked on Time");
        loginPage.delay(12000);

        // Step 4: Get titles from Time page
        TimeSideBar timeSideBar = new TimeSideBar();
        loginPage.delay(10000);
        boolean isTitleDisplayed = timeSideBar.isTimeTitleDisplayed();
        String returnTitle = timeSideBar.getTimeTitleText();
        String returnTimeSheetsTitle = timeSideBar.getTimeSheetTitleText();
        loginPage.delay(5000);

        // Step 5: Validate Time title is displayed
        Assert.assertTrue(isTitleDisplayed, "The Title is Displayed.");
        extentTest.log(Status.PASS, "The Title should be Time: " + isTitleDisplayed);

        // Step 6: Validate Time and Timesheets titles
        if (expectedResult.equals(returnTitle) && expectedTimeSheetTitle.equals(returnTimeSheetsTitle)) {
            extentTest.log(Status.PASS,"The Titles are correct: " + returnTitle + " / " + returnTimeSheetsTitle);
            Assert.assertEquals(returnTitle, expectedResult, "The Result is Matched");
            Assert.assertEquals(returnTimeSheetsTitle, expectedTimeSheetTitle, "The Result is Matched");
        } else {
            extentTest.log(Status.FAIL,"The Titles do not match: " + returnTitle + " / " + returnTimeSheetsTitle );
            Assert.assertEquals(returnTitle, expectedResult, "The Result is Not Matched");
        }
    }
}
