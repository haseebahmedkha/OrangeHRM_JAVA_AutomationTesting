package demo.orangehrm.org.sidebar;

import com.aventstack.extentreports.Status;
import demo.orangehrm.org.HomePage;
import demo.orangehrm.org.LogoutPage;
import demo.orangehrm.org.SideBar;
import demo.orangehrm.org.base.BaseTest;
import org.testng.annotations.Test;

public class SideBarTest extends BaseTest {

    // test a sidebar test case
    @Test
    public void testSideBar(){
        extentTest = extentReports.createTest("Test SideBar For Moving Right to Left");
        loginPage.delay(10000);
        loginPage.setUserName("Admin");
        extentTest.log(Status.INFO,"Enter Valid User Name");
        loginPage.setUserPassword("admin123");
        extentTest.log(Status.INFO,"Enter Valid User Password");
        loginPage.clickLoginButton();
        extentTest.log(Status.INFO,"Enter Login Button");
        loginPage.delay(6000);
        HomePage homePage = new HomePage();
        SideBar sideBar = new SideBar();
        loginPage.delay(6000);
        sideBar.clickOnSideBar();
        extentTest.log(Status.INFO,"Click SideBar to Move Left");
        loginPage.delay(6000);
        sideBar.clickOnSideBar();
        extentTest.log(Status.INFO,"Click SideBar to Move Right");
        extentTest.log(Status.PASS,"SideBar Moving Right To Left and Left to Right Successful");
        LogoutPage logoutPage = new LogoutPage();
        logoutPage.clickOnDropDown();
        logoutPage.clickOnLogout();

    }
}
