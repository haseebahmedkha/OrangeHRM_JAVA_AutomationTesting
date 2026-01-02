package demo.orangehrm.org.sidebar;

import com.aventstack.extentreports.Status;
import demo.orangehrm.org.SideBar;
import demo.orangehrm.org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PimTest extends BaseTest {

    @Test
    public void testPimTitle(){
        // Expected Title for Validation
        String expectedTitle = "PI";

        // Initialize ExtentReports test for logging
        extentTest = extentReports.createTest("Verify PIM Title");

        // Step 1: Enter Username
        loginPage.delay(15000);
        loginPage.enterUsername("Admin");
        extentTest.log(Status.INFO,"Valid User Name Entered");

        // Step 2: Enter Password
        loginPage.enterPassword("admin123");
        extentTest.log(Status.INFO,"Valid User Password Entered");

        // Step 3: Click Login Button
        loginPage.delay(8000);
        loginPage.clickLoginButton();
        extentTest.log(Status.INFO,"Clicked Login Button");

        // Step 4: Navigate to PIM from Sidebar
        SideBar sideBar = new SideBar();
        loginPage.delay(8000);
        sideBar.clickOnPim();
        loginPage.delay(12000);

        // Step 5: Create PIM Page Object and get Title
        Pim pim = new Pim();
        String actualTitle = pim.getPimTitleText();
        loginPage.delay(10000);

        extentTest.log(Status.INFO,"Clicked on PIM");

        // Step 6: Validate Title
        loginPage.delay(5000);
        if (expectedTitle.equals(actualTitle)){
            Assert.assertEquals(actualTitle,expectedTitle,"The Actual and Expected Title Matched");
            extentTest.log(Status.PASS,"The Title Should be PIM: " + actualTitle);
        }
        else {
            extentTest.log(Status.FAIL,"The Title Not Matched: " + actualTitle);
            Assert.assertEquals(actualTitle,expectedTitle,"The Actual and Expected Do Not Matched");
        }
    }
}
