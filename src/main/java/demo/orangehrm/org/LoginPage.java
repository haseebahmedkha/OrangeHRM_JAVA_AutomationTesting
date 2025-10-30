package demo.orangehrm.org;

import com.base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    // sauce demo website Elements
//    private By userName = By.id("user-name");
//    private By userPassword = By.id("password");
//    private By userLoginButton = By.id("login-button");
//    private By errorMessage = By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]");

    // OrangeHRM website Elements
    private By userName = By.xpath("//input[@placeholder='Username']");
    private By userPassword = By.xpath("//input[@placeholder='Password']");
    private By userLoginButton = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
    private By requireError = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");

    // to send Username
    public void setUserName(String text){
        set(userName,text);

    }

    // to send Password
    public void setUserPassword(String password){
        set(userPassword,password);
    }

    // Click on Login Button
    public HomePage clickLoginButton(){
        click(userLoginButton);
        return new HomePage();
    }

    // get Error Message when login Failed
    public String getErrorMessage(){
        return find(errorMessage).getText();
    }

    // show required error when field is empty
    public String showRequired(){
        return driver.findElement(requireError).getText();
    }



}
