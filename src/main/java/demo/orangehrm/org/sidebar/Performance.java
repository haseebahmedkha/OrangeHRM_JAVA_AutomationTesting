package demo.orangehrm.org.sidebar;

import com.base.BasePage;
import org.openqa.selenium.By;

/**
 * Performance
 * -----------
 * This Page Object represents the "Performance" page in OrangeHRM.

 * Responsibilities:
 * - Retrieve the Performance page title
 * - Retrieve the Manage Reviews section title
 * - Verify visibility of Performance and Manage Reviews titles

 * Extends BasePage to reuse common Selenium actions like `find()`.
 */
public class Performance extends BasePage {

    // Locators
    private final By performanceTitleElement = By.xpath(
            "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"
    );

    private final By manageReviewsTitleElement = By.xpath(
            "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-level']"
    );

    /**
     * Retrieves the text of the Performance page title.
     *
     * @return String - Performance title
     */
    public String getPerformanceTitle(){
        return find(performanceTitleElement).getText();
    }

    /**
     * Retrieves the text of the Manage Reviews section title.
     *
     * @return String - Manage Reviews title
     */
    public String getManageReviewTitle(){
        return find(manageReviewsTitleElement).getText();
    }

    /**
     * Checks if the Performance page title is displayed.
     *
     * @return true if Performance title is visible, false otherwise
     */
    public boolean isPerformanceTitleDisplayed(){
        return find(performanceTitleElement).isDisplayed();
    }

    /**
     * Checks if the Manage Reviews section title is displayed.
     *
     * @return true if Manage Reviews title is visible, false otherwise
     */
    public boolean isManageReviewTitleDisplayed(){
        return find(manageReviewsTitleElement).isDisplayed();
    }
}
