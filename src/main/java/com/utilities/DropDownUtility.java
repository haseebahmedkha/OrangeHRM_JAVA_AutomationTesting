package com.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

/**
 * DropDownUtility
 * ----------------
 * This utility class provides reusable methods for handling
 * HTML <select> dropdowns in Selenium.
 * It extends Utility class to access the shared WebDriver instance.
 * All methods are static so they can be called directly
 * without creating an object.
 */
public class DropDownUtility extends Utility {

    /**
     * Finds a dropdown element and returns a Select object.
     *
     * @param locator By locator of the dropdown element
     * @return Select object
     */
    private static Select findDropDown(By locator){
        return new Select(driver.findElement(locator));
    }

    /**
     * Selects a dropdown option using visible text.
     *
     * @param locator By locator of the dropdown
     * @param text Visible text to select
     */
    public static void selectByVisibleText(By locator, String text){
        findDropDown(locator).selectByVisibleText(text);
    }

    /**
     * Selects a dropdown option using index.
     *
     * @param locator By locator of the dropdown
     * @param index Index of the option (starts from 0)
     */
    public static void selectVisibleByIndex(By locator, int index){
        findDropDown(locator).selectByIndex(index);
    }

    /**
     * Selects a dropdown option using value attribute.
     *  BUG FIX:
     * Previously used deselectByValue(), which is incorrect
     * for selecting an option.
     *
     * @param locator By locator of the dropdown
     * @param value Value attribute of the option
     */
    public static void selectVisibleByValue(By locator, String value){
        findDropDown(locator).selectByValue(value);
    }

    /**
     * Returns all selected options from a dropdown.
     * Useful for multi-select dropdown validation.
     *
     * @param locator By locator of the dropdown
     * @return List of selected option texts
     */
    public static List<String> getAllSelectedOptions(By locator){
        List<WebElement> allSelectedOptions = findDropDown(locator).getAllSelectedOptions();
        return allSelectedOptions
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
