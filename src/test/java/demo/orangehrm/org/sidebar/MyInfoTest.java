package demo.orangehrm.org.sidebar;

import com.aventstack.extentreports.Status;
import demo.orangehrm.org.SideBar;
import demo.orangehrm.org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyInfoTest extends BaseTest {

    @Test
    public void testMyInfoTitle() {
        String expectedResult = "My Info";
        extentTest = extentReports.createTest("Verify MyInfo Title");
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
        sideBar.clickOnMyInfo();
        extentTest.log(Status.INFO, "Clicked on Recruitment");
        loginPage.delay(12000);
        MyInfo myInfo = new MyInfo();
        loginPage.delay(10000);
        boolean isTitleDisplayed = myInfo.isMyInfoTitleDisplayed();
        String returnTitle = myInfo.returnMyInfoTitle();
        loginPage.delay(5000);
//        Assert.assertEquals(returnTitle,expectedResult,"The Expected and actual result do not matched ");
        extentTest.log(Status.PASS, "The Title Should be Displayed: " + isTitleDisplayed);
        if (returnTitle.equals(expectedResult)){
            extentTest.log(Status.PASS,"The Title Should be My Info: " + returnTitle);
            Assert.assertEquals(returnTitle,expectedResult,"The Result is Matched");
        }
        else {
            extentTest.log(Status.FAIL, "The Title Not Matched: " + returnTitle);
            Assert.assertEquals(returnTitle,expectedResult, "The Result is Not Matched");
        }

    }

}
