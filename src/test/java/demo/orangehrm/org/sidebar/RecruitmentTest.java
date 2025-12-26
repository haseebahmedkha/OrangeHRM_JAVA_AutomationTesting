package demo.orangehrm.org.sidebar;

import com.aventstack.extentreports.Status;
import demo.orangehrm.org.SideBar;
import demo.orangehrm.org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RecruitmentTest extends BaseTest {

    @Test
    public void testRecruitmentTitle() {
        extentTest = extentReports.createTest("Verify recruitment Title");
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
        sideBar.clickOnRecruitment();
        extentTest.log(Status.INFO, "Clicked on Recruitment");
        loginPage.delay(12000);
        Recruitment recruitment = new Recruitment();
        loginPage.delay(10000);
        boolean isTitleDisplayed = recruitment.isRecruitmentTitleDisplayed();
        String returnTitle = recruitment.returnRecruitmentTitle();
        loginPage.delay(5000);
        Assert.assertTrue(isTitleDisplayed, "The Title is Displayed.");
        extentTest.log(Status.PASS, "The Title Should be Recruitment: " + isTitleDisplayed);
        extentTest.log(Status.PASS,"The Title Should be Recruitment: " + returnTitle);

    }
}
