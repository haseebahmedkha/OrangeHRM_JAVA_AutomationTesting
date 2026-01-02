package demo.orangehrm.org;

import com.base.BasePage;
import org.openqa.selenium.By;

/**
 * LogoutPage
 * ----------
 * This Page Object represents the Logout functionality in OrangeHRM.
 * Responsibilities:
 * - Click on the user dropdown menu
 * - Click on the logout link to log out of the application
 * Extends HomePage to reuse navigation and dashboard-related methods if needed.
 */
public class LogoutPage extends HomePage {

    // -------------------------------
    // Locators
    // -------------------------------
    private final By dropDownElement = By.xpath("//p[@class='oxd-userdropdown-name']");
    private final By logoutElement = By.xpath("//a[normalize-space()='Logout']");

    // -------------------------------
    // Page Actions
    // -------------------------------

    /**
     * Clicks on the user dropdown in the top bar to show logout option.
     */
    public void clickUserDropdown(){
        click(dropDownElement);
    }

    /**
     * Clicks on the "Logout" link from the user dropdown to log out of the application.
     */
    public void clickLogout(){
        click(logoutElement);
    }
}
