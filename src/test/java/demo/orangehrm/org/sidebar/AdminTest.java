package demo.orangehrm.org.sidebar;
import com.aventstack.extentreports.Status;
import demo.orangehrm.org.HomePage;
import demo.orangehrm.org.SideBar;
import demo.orangehrm.org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.utilities.WaitUtility.explicitWaitUntilWait;

public class AdminTest extends BaseTest {

    @Test
    public void testAdminTitleAndUserManagementTitle() {
        String expectedResult = "User Management";
        extentTest = extentReports.createTest("Verify Admin and UserManagement Title");
        loginPage.delay(10000);
        loginPage.setUserName("Admin");
        extentTest.log(Status.INFO,"Valid User Name Entered");
        loginPage.setUserPassword("admin123");
        extentTest.log(Status.INFO,"Valid User Password Entered");
        loginPage.clickLoginButton();
        extentTest.log(Status.INFO,"Clicked Login Button");
        SideBar sideBar = new SideBar();
//        sideBar.clickOnAdmin().isAdminTitleDisplayed();
//        sideBar.clickOnAdmin().isUserManagementTitleDisplayed();
        loginPage.delay(10000);
        sideBar.clickOnAdmin();
        loginPage.delay(6000);
        Admin admin = new Admin();
        loginPage.delay(10000);
        boolean adminTitle = admin.isAdminTitleDisplayed();
        String userManagementTitle = admin.isUserManagementTitleDisplayed();
        Assert.assertTrue(adminTitle,"Admin Title Not Found" + adminTitle);
        extentTest.log(Status.PASS,"Admin title is Displayed");
        Assert.assertEquals(userManagementTitle,expectedResult,"Actual and Expected Do Not Matched");
        extentTest.log(Status.PASS,"User Management Title is: " + userManagementTitle);
    }
}
