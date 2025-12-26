package demo.orangehrm.org.sidebar;

import com.aventstack.extentreports.Status;
import demo.orangehrm.org.SideBar;
import demo.orangehrm.org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeaveTest extends BaseTest {

    @Test
    public void testLeaveTitle() {
        String expectedTitle = "Leave";
        extentTest = extentReports.createTest("Verify Leave Title");
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
        sideBar.clickOnLeave();
        loginPage.delay(12000);
        Leave leave = new Leave();
        loginPage.delay(10000);
        boolean isTitleDisplayed = leave.isLeaveTitleDisplayed();
        String returnTitle = leave.returnLeaveTitle();
        extentTest.log(Status.INFO, "Clicked on Leave");
        loginPage.delay(5000);
        if (returnTitle.equals(expectedTitle)){
            extentTest.log(Status.PASS, "The Tile is Should be Leave: " + returnTitle);
            Assert.assertEquals(returnTitle,expectedTitle,"The Result is Matched");
        }
        else {
            extentTest.log(Status.FAIL, "The Title Not Matched: " + returnTitle);
            Assert.assertEquals(returnTitle,expectedTitle,"The Result is Not Matched");
        }


    }
}
