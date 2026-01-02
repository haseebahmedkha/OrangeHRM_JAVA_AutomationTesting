package com.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * WaitUtility
 * ------------
 * This utility class provides reusable explicit wait methods
 * to handle dynamic elements and synchronization issues in Selenium.
 *
 * It extends Utility class to reuse the shared WebDriver instance.
 */
public class WaitUtility extends Utility {

    /**
     * Waits until an element becomes visible on the page.
     *
     * @param timeInSeconds Maximum wait time in seconds
     * @param locator By locator of the target element
     */
    public static void waitForElementVisible(int timeInSeconds, By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
