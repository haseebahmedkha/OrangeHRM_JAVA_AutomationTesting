package demo.orangehrm.org.sidebar;

import demo.orangehrm.org.HomePage;
import demo.orangehrm.org.LogoutPage;
import demo.orangehrm.org.SideBar;
import demo.orangehrm.org.base.BaseTest;
import org.testng.annotations.Test;

public class SideBarTest extends BaseTest {

    // test a sidebar test case
    @Test
    public void testSideBar(){
        loginPage.delay(10000);
        loginPage.setUserName("Admin");
        loginPage.setUserPassword("admin123");
        loginPage.clickLoginButton();
        loginPage.delay(6000);
        HomePage homePage = new HomePage();
        SideBar sideBar = new SideBar();
        loginPage.delay(6000);
        sideBar.clickOnSideBar();
        loginPage.delay(6000);
        sideBar.clickOnSideBar();
        LogoutPage logoutPage = new LogoutPage();
        logoutPage.clickOnDropDown();
        logoutPage.clickOnLogout();

    }
}
