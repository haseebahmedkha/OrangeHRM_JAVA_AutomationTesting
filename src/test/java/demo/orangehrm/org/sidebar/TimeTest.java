package demo.orangehrm.org.sidebar;

import com.aventstack.extentreports.Status;
import demo.orangehrm.org.SideBar;
import demo.orangehrm.org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeTest extends BaseTest {

    @Test
    public void testTimeTitle() {
        String expectedResult = "Time";
        String expectedTimeSheetTitle = "Timesheets";
        extentTest = extentReports.createTest("Verify Time Title");
        loginPage.delay(15000);
        loginPage.setUserName("Admin");
        extentTest.log(Status.INFO, "Valid User Name Entered");
        loginPage.setUserPassword("admin123");
        extentTest.log(Status.INFO, "Valid User Password Entered");
        loginPage.delay(8000);
        loginPage.clickLoginButton();
        extentTest.log(Status.INFO, "Clicked Login Button");
        SideBar sideBar = new SideBar();
        loginPage.delay(8000);
        sideBar.clickOnTime();
        extentTest.log(Status.INFO, "Clicked on Time");
        loginPage.delay(12000);
        TimeSideBar timeSideBar = new TimeSideBar();
        loginPage.delay(10000);
        boolean isTitleDisplayed = timeSideBar.isTimeTitleDisplayed();
        String returnTitle = timeSideBar.isReturnTimeTitle();
        String returnTimeSheetsTitle = timeSideBar.isReturnTimeSheetTitle();
        loginPage.delay(5000);
        Assert.assertTrue(isTitleDisplayed, "The Title is Displayed.");
        extentTest.log(Status.PASS, "The Title Should be Time: " + isTitleDisplayed);
        if (expectedResult.equals(returnTitle) && expectedTimeSheetTitle.equals(returnTimeSheetsTitle)){
            extentTest.log(Status.PASS,"The Title Should be Time and Timesheets: " + returnTitle + "/" + returnTimeSheetsTitle);
            Assert.assertEquals(returnTitle,expectedResult,"The Result is Matched");
            Assert.assertEquals(returnTimeSheetsTitle,expectedTimeSheetTitle,"The Result is Matched");
        }
        else {
            extentTest.log(Status.FAIL,"The Title Not Matched: " + returnTitle + "/" + returnTimeSheetsTitle );
            Assert.assertEquals(returnTitle,expectedTimeSheetTitle,"The Result is Not Matched");
        }

    }



}
