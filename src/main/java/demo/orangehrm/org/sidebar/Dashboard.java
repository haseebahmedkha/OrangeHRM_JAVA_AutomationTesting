package demo.orangehrm.org.sidebar;

import com.base.BasePage;
import org.openqa.selenium.By;

/**
 * Dashboard
 * ---------
 * This Page Object represents the Dashboard page in OrangeHRM.
 * Responsibilities:
 * - Retrieve the title of the Dashboard page

 * Extends BasePage to reuse common Selenium actions like `find()`.
 */
public class Dashboard extends BasePage {

    // Locator for the Dashboard page title element
    private final By dashboardTitleElement = By.xpath(
            "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"
    );

    /**
     * Retrieves the title text of the Dashboard page.
     * Useful for asserting the correct page is loaded.
     *
     * @return String - text of the Dashboard title
     */
    public String getDashboardTitle(){
        return find(dashboardTitleElement).getText();
    }
}
