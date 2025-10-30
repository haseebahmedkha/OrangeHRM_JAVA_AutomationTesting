package demo.orangehrm.org.login;

import com.utilities.WaitUtility;
import demo.orangehrm.org.HomePage;
import demo.orangehrm.org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


// its test all the testSuite
@Test
public class LoginTest extends BaseTest {


    // its test a particular login test with InValid Credentials
    @Test
    public void testInValidLoginCredential(){
        String expectedResult = "Invalid credentials";
        loginPage.delay(15000);
        loginPage.setUserName("Adminjd");
        loginPage.setUserPassword("1234err");
        loginPage.clickLoginButton();
        loginPage.delay(4000);
        String actualResult = loginPage.getErrorMessage();
        Assert.assertEquals(actualResult,expectedResult,"the Actual and Expected Do Not Matched");
    }

    // its test a particular login test without enter Username
    @Test
    public void testLoginWithOutEnterUserName(){
        String expectedResult = "Required";
        loginPage.delay(10000);
        loginPage.setUserPassword("admin123");
        loginPage.clickLoginButton();
        loginPage.delay(6000);
        String actualResult = loginPage.showRequired();
        Assert.assertEquals(actualResult,expectedResult,"Actual And Expected Do not Matched");

    }

    // its test a particular login test without Entering user password
    @Test
    public void testLoginWithOutEnterUserPassword(){
        String expectedResult = "Required";
        loginPage.delay(10000);
        loginPage.setUserName("Admin");
        loginPage.clickLoginButton();
        loginPage.delay(6000);
        String actualResult = loginPage.showRequired();
        Assert.assertEquals(actualResult,expectedResult,"Actual And Expected Do not Matched");
    }

    // its test a particular login test without Entering user name and password
    @Test
    public void testLoginWithOutEnterUserPasswordAndUserPassword(){
        String expectedResult = "Required";
        loginPage.clickLoginButton();
        loginPage.delay(6000);
        String actualResult = loginPage.showRequired();
        Assert.assertEquals(actualResult,expectedResult,"Actual And Expected Do not Matched");

    }

    // its test a particular login test with Valid Credentials
    @Test
    public void testLoginWithValidCredential() {
        String expectedResult = "Dashboard";
        loginPage.delay(15000);
        loginPage.setUserName("Admin");
        loginPage.setUserPassword("admin123");
        loginPage.clickLoginButton();
        loginPage.delay(6000);
        HomePage homePage = new HomePage();
        String actualResult = homePage.returnHeaderText();
        Assert.assertEquals(actualResult,expectedResult,"Actual And Expected Do not Matched");
    }


}
