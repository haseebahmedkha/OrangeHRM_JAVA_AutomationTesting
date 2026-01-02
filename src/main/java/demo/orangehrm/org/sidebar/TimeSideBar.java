package demo.orangehrm.org.sidebar;

import com.base.BasePage;
import org.openqa.selenium.By;

/**
 * TimeSideBar
 * -----------
 * This Page Object represents the "Time" page and its sidebar sections in OrangeHRM.
 *
 * Responsibilities:
 * - Verify visibility of the Time page title
 * - Retrieve the text of the Time page title
 * - Retrieve the text of the Timesheet section title
 *
 * Extends BasePage to reuse common Selenium actions like `find()`.
 */
public class TimeSideBar extends BasePage {

    // Locator for the main Time page title
    private final By timeTitleElement = By.xpath(
            "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"
    );

    // Locator for the Timesheet section title
    private final By timeSheetElement = By.xpath(
            "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-level']"
    );

    /**
     * Checks if the Time page title is displayed.
     *
     * @return true if Time page title is visible, false otherwise
     */
    public boolean isTimeTitleDisplayed(){
        return find(timeTitleElement).isDisplayed();
    }

    /**
     * Returns the text of the Time page title.
     *
     * @return String - text of the Time page title
     */
    public String getTimeTitleText(){
        return find(timeTitleElement).getText();
    }

    /**
     * Returns the text of the Timesheet section title.
     *
     * @return String - text of the Timesheet section
     */
    public String getTimeSheetTitleText(){
        return find(timeSheetElement).getText();
    }
}
