package demo.orangehrm.org.login;

import com.base.BasePage;
import demo.orangehrm.org.HomePage;
import demo.orangehrm.org.LogoutPage;
import demo.orangehrm.org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Time;

public class LogoutTest extends BaseTest {


    // its test a particular logout test Case
    @Test
    public void testLogout(){
        loginPage.delay(10000);
        loginPage.setUserName("Admin");
        loginPage.setUserPassword("admin123");
        loginPage.clickLoginButton();
        loginPage.delay(6000);
        HomePage homePage = new HomePage();
        LogoutPage logoutPage = new LogoutPage();
        loginPage.delay(4000);
        logoutPage.clickOnDropDown();
        loginPage.delay(2000);
        logoutPage.clickOnLogout();

    }


}
