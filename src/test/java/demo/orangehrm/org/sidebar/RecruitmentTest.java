package demo.orangehrm.org.sidebar;

import com.aventstack.extentreports.Status;
import demo.orangehrm.org.SideBar;
import demo.orangehrm.org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RecruitmentTest extends BaseTest {

    @Test
    public void testRecruitmentTitle() {
        // Step 0: Expected title for verification
        String expectedTitle = "Recruitment";

        // Initialize ExtentReports test for logging
        extentTest = extentReports.createTest("Verify Recruitment Title");

        // Step 1: Enter Username
        loginPage.delay(15000);
        loginPage.enterUsername("Admin");
        extentTest.log(Status.INFO, "Valid User Name Entered");

        // Step 2: Enter Password
        loginPage.enterPassword("admin123");
        extentTest.log(Status.INFO, "Valid User Password Entered");

        // Step 3: Click Login Button
        loginPage.delay(8000);
        loginPage.clickLoginButton();
        extentTest.log(Status.INFO, "Clicked Login Button");

        // Step 4: Navigate to Recruitment via Sidebar
        SideBar sideBar = new SideBar();
        loginPage.delay(8000);
        sideBar.clickOnRecruitment();
        extentTest.log(Status.INFO, "Clicked on Recruitment");
        loginPage.delay(12000);

        // Step 5: Initialize Recruitment Page Object and get title
        Recruitment recruitment = new Recruitment();
        loginPage.delay(10000);
        boolean isTitleDisplayed = recruitment.isRecruitmentTitleDisplayed();
        String returnTitle = recruitment.getRecruitmentTitleText();
        loginPage.delay(5000);

        // Step 6: Validate the title
        if (expectedTitle.equals(returnTitle)){
            extentTest.log(Status.PASS,"The Title Should be Recruitment: " + returnTitle);
            Assert.assertEquals(returnTitle, expectedTitle, "The Actual and Expected Title Matched");
        } else {
            extentTest.log(Status.FAIL,"The Title Not Matched: " + returnTitle);
            Assert.assertEquals(returnTitle, expectedTitle, "The Actual and Expected Title Do Not Match");
        }
    }
}
