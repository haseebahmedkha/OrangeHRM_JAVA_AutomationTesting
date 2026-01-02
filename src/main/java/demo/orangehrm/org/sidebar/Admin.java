package demo.orangehrm.org.sidebar;

import com.base.BasePage;
import org.openqa.selenium.By;

/**
 * Admin
 * -----
 * This Page Object represents the "Admin" section of the OrangeHRM sidebar.
 *
 * Responsibilities:
 * - Verify Admin page title visibility
 * - Verify User Management section visibility and text
 *
 * Extends BasePage to inherit common Selenium actions like `find()`.
 */
public class Admin extends BasePage {

    // Locators
    final private By adminTitle = By.xpath("//h6[normalize-space()='Admin']");
    final private By userManagementTitle = By.xpath("//h6[normalize-space()='User Management']");

    /**
     * Checks if the Admin page title is displayed.
     * Useful for asserting that the Admin page is loaded.
     *
     * @return true if Admin title is visible, false otherwise
     */
    public boolean isAdminTitleDisplayed(){
        return find(adminTitle).isDisplayed();
    }

    /**
     * Returns the text of the User Management title.
     * Useful for validating that the section header is correct.
     *
     * @return String - text of User Management header
     */
    public String getUserManagementTitleText(){
        return find(userManagementTitle).getText();
    }
}
