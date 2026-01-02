package demo.orangehrm.org.sidebar;

import com.base.BasePage;
import org.openqa.selenium.By;

/**
 * Leave
 * -----
 * This Page Object represents the "Leave" page in OrangeHRM.
 *
 * Responsibilities:
 * - Verify the visibility of the Leave page title
 * - Retrieve the text of the Leave page title
 *
 * Extends BasePage to reuse common Selenium actions like `find()`.
 */
public class Leave extends BasePage {

    // Locator for the Leave page title
    private final By leaveTitleElement = By.xpath("//h6[normalize-space()='Leave']");

    /**
     * Checks if the Leave page title is displayed.
     * Useful for asserting that the Leave page is loaded.
     *
     * @return true if the Leave title is visible, false otherwise
     */
    public boolean isLeaveTitleDisplayed(){
        return find(leaveTitleElement).isDisplayed();
    }

    /**
     * Returns the text of the Leave page title.
     * Useful for validating that the section header is correct.
     *
     * @return String - text of Leave page header
     */
    public String getLeaveTitleText(){
        return find(leaveTitleElement).getText();
    }
}
