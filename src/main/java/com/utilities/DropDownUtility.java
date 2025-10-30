package com.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropDownUtility extends Utility{

    // find Dropdown by locator
    private static Select findDropDown(By locator){
        return new Select(driver.findElement(locator));
    }

    // find dropdown by Text
    public static void selectByVisibleText(By locator,String text){
        findDropDown(locator).selectByVisibleText(text);
    }

    // find dropdown by Index
    public static void selectVisibleByIndex(By locator,int index){
        findDropDown(locator).selectByIndex(index);
    }

    // find dropdown by Value
    public static void selectVisibleByValue(By locator,String value){
        findDropDown(locator).deselectByValue(value);

    }

    // get all Selected Items in a dropdown
    public static List<String> getAllSelectedOptions(By locator){
        List<WebElement> allSelectedOptions = findDropDown(locator).getAllSelectedOptions();
        return allSelectedOptions.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
