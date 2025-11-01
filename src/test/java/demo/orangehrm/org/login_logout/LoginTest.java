package demo.orangehrm.org.login_logout;

import com.aventstack.extentreports.Status;
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
        extentTest = extentReports.createTest("login test with Invalid Credentials");
        String expectedResult = "Invalid credentials";
        loginPage.delay(15000);
        extentTest.log(Status.INFO,"Invalid User Name Entered");
        loginPage.setUserName("Adminjd");
        extentTest.log(Status.INFO,"Invalid User Password Entered");
        loginPage.setUserPassword("1234err");
        extentTest.log(Status.INFO,"Click on Login Button");
        loginPage.delay(4000);
        loginPage.clickLoginButton();
        loginPage.delay(8000);
        extentTest.log(Status.PASS,"login Not Successfully");
        String actualResult = loginPage.getErrorMessage();
        Assert.assertEquals(actualResult,expectedResult,"the Actual and Expected Do Not Matched");
    }

    // its test a particular login test without enter Username
    @Test
    public void testLoginWithOutEnterUserName(){
        extentTest = extentReports.createTest("login test without username Credentials");
        String expectedResult = "Required";
        loginPage.delay(10000);
        extentTest.log(Status.INFO,"Invalid User Password Entered");
        loginPage.setUserPassword("admin123");
        extentTest.log(Status.INFO,"Click on Login Button");
        loginPage.clickLoginButton();
        extentTest.log(Status.INFO,"login Not Successfully");
        loginPage.delay(6000);
        String actualResult = loginPage.showRequired();
        extentTest.log(Status.PASS,"Show user name Required Successfully");
        Assert.assertEquals(actualResult,expectedResult,"Actual And Expected Do not Matched");

    }

    // its test a particular login test without Entering user password
    @Test
    public void testLoginWithOutEnterUserPassword(){
        extentTest = extentReports.createTest("login test without Password Credentials");
        String expectedResult = "Required";
        loginPage.delay(10000);
        loginPage.setUserName("Admin");
        extentTest.log(Status.INFO,"Valid User Name Entered");
        loginPage.clickLoginButton();
        extentTest.log(Status.INFO,"login Not Successfully");
        loginPage.delay(6000);
        String actualResult = loginPage.showRequired();
        extentTest.log(Status.PASS,"Show user Password Required Successfully");
        Assert.assertEquals(actualResult,expectedResult,"Actual And Expected Do not Matched");
    }

    // its test a particular login test without Entering user name and password
    @Test
    public void testLoginWithOutEnterUserPasswordAndUserPassword(){
        extentTest = extentReports.createTest("login test without Username and Password Credentials");
        String expectedResult = "Required";
        loginPage.clickLoginButton();
        extentTest.log(Status.INFO,"login Not Successfully");
        loginPage.delay(6000);
        String actualResult = loginPage.showRequired();
        extentTest.log(Status.PASS,"Show username and  Password Required Successfully");
        Assert.assertEquals(actualResult,expectedResult,"Actual And Expected Do not Matched");

    }

    // its test a particular login test with Valid Credentials
    @Test
    public void testLoginWithValidCredential() {
        extentTest = extentReports.createTest("login test correct Username and Password Credentials");
        String expectedResult = "Dashboard";
        loginPage.delay(15000);
        loginPage.setUserName("Admin");
        extentTest.log(Status.INFO,"Valid User Name Entered");
        loginPage.setUserPassword("admin123");
        extentTest.log(Status.INFO,"Valid User Password Entered");
        loginPage.clickLoginButton();
        extentTest.log(Status.INFO,"Clicked Login Button");
        loginPage.delay(6000);
        HomePage homePage = new HomePage();
        String actualResult = homePage.returnHeaderText();
        extentTest.log(Status.PASS,"Login Successfully");
        Assert.assertEquals(actualResult,expectedResult,"Actual And Expected Do not Matched");
    }


}
