package demo.orangehrm.org.sidebar;

import com.base.BasePage;
import org.openqa.selenium.By;

/**
 * MyInfo
 * ------
 * This Page Object represents the "My Info" page in OrangeHRM.

 * Responsibilities:
 * - Verify the visibility of the My Info page title
 * - Retrieve the text of the My Info page title

 * Extends BasePage to reuse common Selenium actions like `find()`.
 */
public class MyInfo extends BasePage {

    // Locator for the My Info page title
    private final By myInfoTitleElement = By.xpath(
            "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"
    );

    /**
     * Checks if the My Info page title is displayed.
     * Useful for asserting that the My Info page has loaded successfully.
     *
     * @return true if My Info title is visible, false otherwise
     */
    public boolean isMyInfoTitleDisplayed(){
        return find(myInfoTitleElement).isDisplayed();
    }

    /**
     * Returns the text of the My Info page title.
     * Useful for validating the page header.
     *
     * @return String - text of the My Info page header
     */
    public String getMyInfoTitleText(){
        return find(myInfoTitleElement).getText();
    }
}
