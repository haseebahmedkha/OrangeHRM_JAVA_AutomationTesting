package demo.orangehrm.org.login_logout;

import com.aventstack.extentreports.Status;
import demo.orangehrm.org.HomePage;
import demo.orangehrm.org.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * LoginTest Class
 * ------------------------
 * - Contains all login test cases for OrangeHRM
 * - Covers positive and negative scenarios:
 *   1. Invalid credentials
 *   2. Missing username
 *   3. Missing password
 *   4. Missing both username and password
 *   5. Valid credentials
 * - Integrates ExtentReports for detailed reporting
 */
@Test
public class LoginTest extends BaseTest {

    /**
     * Test login with invalid username and password
     */
    @Test
    public void testInValidLoginCredential() {
        extentTest = extentReports.createTest("Login Test with Invalid Credentials");

        // Expected error message
        String expectedResult = "Invalid credentials";

        loginPage.delay(15000); // Wait for page load (replace with explicit wait in production)
        extentTest.log(Status.INFO, "Entering invalid username");
        loginPage.enterUsername("Adminjd");

        extentTest.log(Status.INFO, "Entering invalid password");
        loginPage.enterPassword("1234err");

        extentTest.log(Status.INFO, "Clicking Login Button");
        loginPage.delay(4000);
        loginPage.clickLoginButton();
        loginPage.delay(8000);

        extentTest.log(Status.PASS, "Login failed as expected");
        String actualResult = loginPage.getLoginErrorMessage();
        Assert.assertEquals(actualResult, expectedResult, "Actual and expected results do not match");
    }

    /**
     * Test login without entering username
     */
    @Test
    public void testLoginWithOutEnterUserName() {
        extentTest = extentReports.createTest("Login Test without Username");

        String expectedResult = "Required";

        loginPage.delay(10000); // Wait for page load
        extentTest.log(Status.INFO, "Entering password only");
        loginPage.enterPassword("admin123");

        extentTest.log(Status.INFO, "Clicking Login Button");
        loginPage.clickLoginButton();
        loginPage.delay(6000);

        String actualResult = loginPage.getRequiredFieldMessage();
        extentTest.log(Status.PASS, "Username required error displayed successfully");
        Assert.assertEquals(actualResult, expectedResult, "Actual and expected results do not match");
    }

    /**
     * Test login without entering password
     */
    @Test
    public void testLoginWithOutEnterUserPassword() {
        extentTest = extentReports.createTest("Login Test without Password");

        String expectedResult = "Required";

        loginPage.delay(10000);
        extentTest.log(Status.INFO, "Entering username only");
        loginPage.enterUsername("Admin");

        extentTest.log(Status.INFO, "Clicking Login Button");
        loginPage.clickLoginButton();
        loginPage.delay(6000);

        String actualResult = loginPage.getRequiredFieldMessage();
        extentTest.log(Status.PASS, "Password required error displayed successfully");
        Assert.assertEquals(actualResult, expectedResult, "Actual and expected results do not match");
    }

    /**
     * Test login without entering both username and password
     */
    @Test
    public void testLoginWithOutEnterUserPasswordAndUserPassword() {
        extentTest = extentReports.createTest("Login Test without Username and Password");

        String expectedResult = "Required";

        extentTest.log(Status.INFO, "Clicking Login Button without entering credentials");
        loginPage.clickLoginButton();
        loginPage.delay(6000);

        String actualResult = loginPage.getRequiredFieldMessage();
        extentTest.log(Status.PASS, "Username and password required error displayed successfully");
        Assert.assertEquals(actualResult, expectedResult, "Actual and expected results do not match");
    }

    /**
     * Test login with valid username and password
     */
    @Test
    public void testLoginWithValidCredential() {
        extentTest = extentReports.createTest("Login Test with Valid Credentials");

        String expectedResult = "Dashboard";

        loginPage.delay(15000); // Wait for page load
        extentTest.log(Status.INFO, "Entering valid username");
        loginPage.enterUsername("Admin");

        extentTest.log(Status.INFO, "Entering valid password");
        loginPage.enterPassword("admin123");

        extentTest.log(Status.INFO, "Clicking Login Button");
        loginPage.clickLoginButton();
        loginPage.delay(6000);

        HomePage homePage = new HomePage();
        String actualResult = homePage.getHeaderText();
        extentTest.log(Status.PASS, "Login successful, Dashboard displayed");
        Assert.assertEquals(actualResult, expectedResult, "Actual and expected results do not match");
    }

}
