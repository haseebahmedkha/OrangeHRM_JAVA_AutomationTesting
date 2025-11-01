package demo.orangehrm.org.login_logout;

import com.aventstack.extentreports.Status;
import demo.orangehrm.org.HomePage;
import demo.orangehrm.org.LogoutPage;
import demo.orangehrm.org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {


    // its test a particular logout test Case
    @Test
    public void testLogout(){
        try {
            extentTest = extentReports.createTest("Verify Logout Test Begin");
            loginPage.delay(10000);
            extentTest.log(Status.INFO,"putting user name Successfully");
            loginPage.setUserName("Admin");
            extentTest.log(Status.INFO,"putting user name Successfully");
            loginPage.setUserPassword("admin123");
            extentTest.log(Status.INFO,"Clicked Login Button Successfully");
            loginPage.clickLoginButton();
            loginPage.delay(6000);
            extentTest.log(Status.INFO,"Going to Home Page Successfully");
            HomePage homePage = new HomePage();
            LogoutPage logoutPage = new LogoutPage();
            loginPage.delay(4000);
            extentTest.log(Status.INFO,"Clicked Dropdown Successfully");
            logoutPage.clickOnDropDown();
            loginPage.delay(2000);
            extentTest.log(Status.INFO,"Clicked on Logout");
            logoutPage.clickOnLogout();
            extentTest.log(Status.PASS,"Logout Successfully ");
        }
        catch (Exception e){
            extentTest.log(Status.FAIL,"Logout Failed:" + e.getMessage());
            Assert.fail(e.getMessage());
        }



    }


}
