package com.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * JavaScriptUtility
 * ------------------
 * This utility class provides reusable JavaScript-based
 * Selenium operations.
 *
 * JavaScriptExecutor is mainly used when:
 *  - Normal Selenium click fails
 *  - Element is not visible in viewport
 *  - Page uses heavy JavaScript or dynamic UI
 *
 * Extends Utility class to reuse the shared WebDriver instance.
 */
public class JavaScriptUtility extends Utility {

    /**
     * Scrolls the page until the specified element is visible.
     * Useful when the element is not in the current viewport.
     *
     * @param locator By locator of the target element
     */
    public static void scrollToElementJS(By locator){
        WebElement element = driver.findElement(locator);
        String jsScript = "arguments[0].scrollIntoView(true);";
        ((JavascriptExecutor) driver).executeScript(jsScript, element);
    }

    /**
     * Performs click operation using JavaScript.
     * Used as a fallback when Selenium's click() fails
     * due to overlays, hidden elements, or intercept issues.
     *
     * @param locator By locator of the clickable element
     */
    public static void clickJS(By locator){
        WebElement element = driver.findElement(locator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }
}
