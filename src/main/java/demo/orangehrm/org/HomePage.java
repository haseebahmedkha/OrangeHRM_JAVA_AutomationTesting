package demo.orangehrm.org;

import com.base.BasePage;
import org.openqa.selenium.By;

/**
 * HomePage
 * --------
 * This Page Object represents the Home/Dashboard page in OrangeHRM.

 * Responsibilities:
 * - Verify the visibility of the dashboard header
 * - Retrieve the text of the dashboard header
 * - Interact with the sidebar toggle button

 * Extends BasePage to reuse common Selenium actions like `find()` and `click()`.
 */
public class HomePage extends BasePage {

    // Locator for the Dashboard page header
    private final By title = By.xpath("//h6[normalize-space()='Dashboard']");

    // Locator for the sidebar toggle button
    private final By sideButton = By.xpath("//button[@role='none']");

    /**
     * Returns the text of the dashboard header.
     *
     * @return String - text of the Dashboard header
     */
    public String getHeaderText(){
        return find(title).getText();
    }

    /**
     * Checks if the dashboard header is displayed.
     *
     * @return true if header is visible, false otherwise
     */
    public boolean isHeaderDisplayed(){
        return find(title).isDisplayed();
    }

    /**
     * Clicks the sidebar toggle button to show or hide the sidebar.
     *
     * @return SideBar page object for further interactions
     */
    public SideBar clickSidebarToggle(){
        click(sideButton);
        return new SideBar();
    }
}
