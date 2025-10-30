package demo.orangehrm.org.base;

import com.base.BasePage;
import demo.orangehrm.org.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    // its run before any test
    @BeforeMethod
    public void SetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        basePage = new BasePage();
        basePage.setDriver(driver);
        basePage.delay(5000);
        loginPage = new LoginPage();
    }

    // its run after excution of any testcase
    @AfterMethod
    public void driverClosed(){
        driver.close();
    }


}
