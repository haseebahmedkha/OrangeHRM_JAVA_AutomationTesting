package demo.orangehrm.org.sidebar;

import com.base.BasePage;
import org.openqa.selenium.By;

/**
 * Recruitment
 * -----------
 * This Page Object represents the "Recruitment" page in OrangeHRM.

 * Responsibilities:
 * - Verify the visibility of the Recruitment page title
 * - Retrieve the text of the Recruitment page title

 * Extends BasePage to reuse common Selenium actions like `find()`.
 */
public class Recruitment extends BasePage {

    // Locator for the Recruitment page title
    private final By recruitmentTitleElement = By.xpath(
            "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"
    );

    /**
     * Checks if the Recruitment page title is displayed.
     * Useful for asserting that the Recruitment page is loaded successfully.
     *
     * @return true if Recruitment title is visible, false otherwise
     */
    public boolean isRecruitmentTitleDisplayed(){
        return find(recruitmentTitleElement).isDisplayed();
    }

    /**
     * Returns the text of the Recruitment page title.
     * Useful for validating the page header.
     *
     * @return String - text of Recruitment page header
     */
    public String getRecruitmentTitleText(){
        return find(recruitmentTitleElement).getText();
    }
}
