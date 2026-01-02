package com.utilities;

import com.base.BasePage;
import org.openqa.selenium.WebDriver;

/**
 * Utility
 * --------
 * This class acts as a base utility class for all utility helpers
 * such as JavaScriptUtility, DropDownUtility, WaitUtility, etc.
 *
 * It provides a shared WebDriver reference to all utility classes
 * by fetching it from BasePage.
 */
public class Utility {

    /**
     * Shared WebDriver instance for utility classes.
     */
    public static WebDriver driver;

    /**
     * Sets the WebDriver for utility classes.
     * This method should be called after driver initialization,
     * usually from BaseTest or test setup.
     */
    public static void setUtilityDriver(){
        driver = BasePage.driver;
    }
}
