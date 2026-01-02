package com.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * BasePage
 * ----------
 * This class acts as a parent class for all Page Objects.
 * It contains common reusable methods for:
 *  - Finding elements
 *  - Sending input
 *  - Clicking elements
 *  - Handling delays
 *
 * By extending this class, child page classes can avoid code duplication.
 */
public class BasePage {

    /**
     * WebDriver instance shared across page classes.
     * Declared static so the same driver reference
     * is accessible throughout the framework.
     */
    public static WebDriver driver;

    /**
     * Sets the WebDriver instance.
     * This method is usually called from test setup or BaseTest class.
     *
     * @param driver WebDriver instance
     */
    public void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }

    /**
     * Finds and returns a WebElement using a given locator.
     *
     * @param locator By locator (id, name, xpath, css, etc.)
     * @return WebElement found on the page
     */
    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    /**
     * Clears existing text and sends new text to an input field.
     *
     * @param locator By locator of the input field
     * @param text Text value to be entered
     */
    protected void set(By locator, String text){
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    /**
     * Clicks on a web element using the given locator.
     *
     * @param locator By locator of the clickable element
     */
    protected void click(By locator){
        find(locator).click();
    }

    /**
     * Provides a hard wait (static delay).
     * This should be avoided in favor of explicit waits,
     * but can be useful for debugging or temporary pauses.
     *
     * @param milliSeconds Time to wait in milliseconds
     */
    public void delay(int milliSeconds){
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
