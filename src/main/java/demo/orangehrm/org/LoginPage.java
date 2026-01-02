package demo.orangehrm.org;

import com.base.BasePage;
import org.openqa.selenium.By;

/**
 * LoginPage
 * ---------
 * This Page Object represents the Login page of OrangeHRM.
 *
 * Responsibilities:
 * - Enter username and password
 * - Click on login button
 * - Retrieve error messages when login fails
 * - Retrieve required field validation messages
 *
 * Extends BasePage to reuse common Selenium actions like `set()`, `click()`, and `find()`.
 */
public class LoginPage extends BasePage {

    // -------------------------------
    // Locators for OrangeHRM login page
    // -------------------------------
    private final By userName = By.xpath("//input[@placeholder='Username']");
    private final By userPassword = By.xpath("//input[@placeholder='Password']");
    private final By userLoginButton = By.xpath("//button[normalize-space()='Login']");
    private final By errorMessage = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
    private final By requireError = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");

    // -------------------------------
    // Page Actions
    // -------------------------------

    /**
     * Enter the username in the username input field.
     *
     * @param text - username string to be entered
     */
    public void enterUsername(String text){
        set(userName, text);
    }

    /**
     * Enter the password in the password input field.
     *
     * @param password - password string to be entered
     */
    public void enterPassword(String password){
        set(userPassword, password);
    }

    /**
     * Click on the login button to attempt login.
     *
     * @return HomePage object for successful login
     */
    public HomePage clickLoginButton(){
        click(userLoginButton);
        return new HomePage();
    }

    /**
     * Get the error message displayed when login fails.
     *
     * @return String - login error message
     */
    public String getLoginErrorMessage(){
        return find(errorMessage).getText();
    }

    /**
     * Get the "required field" error message when input fields are empty.
     *
     * @return String - required field error message
     */
    public String getRequiredFieldMessage(){
        return find(requireError).getText();
    }
}
