package demo.orangehrm.org.sidebar;

import com.aventstack.extentreports.Status;
import demo.orangehrm.org.SideBar;
import demo.orangehrm.org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PimTest extends BaseTest {

    @Test
    public void testPimTitle(){
        extentTest = extentReports.createTest("Verify PIM Title");
        loginPage.delay(15000);
        loginPage.setUserName("Admin");
        extentTest.log(Status.INFO,"Valid User Name Entered");
        loginPage.setUserPassword("admin123");
        extentTest.log(Status.INFO,"Valid User Password Entered");
        loginPage.delay(8000);
        loginPage.clickLoginButton();
        extentTest.log(Status.INFO,"Clicked Login Button");
        SideBar sideBar = new SideBar();
        loginPage.delay(8000);
        sideBar.clickOnPim();
        loginPage.delay(12000);
        Pim pim = new Pim();
        loginPage.delay(10000);
        boolean isTitleDisplayed = pim.isPimTitleDisplayed();
        extentTest.log(Status.INFO,"Clicked on PIM");
        loginPage.delay(5000);
        Assert.assertTrue(isTitleDisplayed,"The Title is Displayed.");
        extentTest.log(Status.PASS,"The Tile is Should be PIM: " + isTitleDisplayed);


    }
}
