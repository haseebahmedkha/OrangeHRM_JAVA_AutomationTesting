package demo.orangehrm.org.sidebar;

import com.aventstack.extentreports.Status;
import demo.orangehrm.org.HomePage;
import demo.orangehrm.org.LogoutPage;
import demo.orangehrm.org.SideBar;
import demo.orangehrm.org.base.BaseTest;
import org.testng.annotations.Test;

public class SideBarTest extends BaseTest {

    // Test Case: Verify Sidebar toggle functionality (Right ↔ Left)
    @Test
    public void testSideBar(){
        // Step 0: Initialize ExtentReports test
        extentTest = extentReports.createTest("Test SideBar For Moving Right to Left");

        // Step 1: Login to the application
        loginPage.delay(10000);
        loginPage.enterUsername("Admin");
        extentTest.log(Status.INFO,"Entered valid username: Admin");
        loginPage.enterPassword("admin123");
        extentTest.log(Status.INFO,"Entered valid password");
        loginPage.clickLoginButton();
        extentTest.log(Status.INFO,"Clicked Login Button");
        loginPage.delay(6000);

        // Step 2: Initialize HomePage and Sidebar objects
        HomePage homePage = new HomePage();
        SideBar sideBar = new SideBar();
        loginPage.delay(6000);

        // Step 3: Toggle Sidebar to move left
        sideBar.clickSidebarToggle();
        extentTest.log(Status.INFO,"Clicked Sidebar to move Left");
        loginPage.delay(6000);

        // Step 4: Toggle Sidebar to move right
        sideBar.clickSidebarToggle();
        extentTest.log(Status.INFO,"Clicked Sidebar to move Right");

        // Step 5: Log test result in ExtentReports
        extentTest.log(Status.PASS,"Sidebar moved Right to Left and Left to Right successfully");

        // Step 6: Logout after test completion
        LogoutPage logoutPage = new LogoutPage();
        logoutPage.clickUserDropdown();
        logoutPage.clickLogout();
    }
}
