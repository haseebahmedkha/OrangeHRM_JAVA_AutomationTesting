package demo.orangehrm.org.sidebar;

import com.base.BasePage;
import org.openqa.selenium.By;

/**
 * PIM
 * ---
 * This Page Object represents the "PIM" page in OrangeHRM.
 *
 * Responsibilities:
 * - Verify the visibility of the PIM page title
 * - Retrieve the text of the PIM page title
 *
 * Extends BasePage to reuse common Selenium actions like `find()`.
 */
public class Pim extends BasePage {

    // Locator for the PIM page title
    private final By pimTitleElement = By.xpath("//h6[normalize-space()='PIM']");

    /**
     * Checks if the PIM page title is displayed.
     * Useful for asserting that the PIM page is loaded successfully.
     *
     * @return true if PIM title is visible, false otherwise
     */
    public boolean isPimTitleDisplayed(){
        return find(pimTitleElement).isDisplayed();
    }

    /**
     * Returns the text of the PIM page title.
     * Useful for validating the page header.
     *
     * @return String - text of PIM page header
     */
    public String getPimTitleText(){
        return find(pimTitleElement).getText();
    }
}
