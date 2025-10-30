package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    // declare a Driver Class
    public static WebDriver driver;

    // set a Driver
    public void setDriver(WebDriver driver){
        BasePage.driver = driver;

    }

    // for finding any locator
    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    // for sending keys
    protected void set(By locator,String text){
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    // click on any locator
    protected void click(By locator){
        find(locator).click();
    }

    // method for delay when elements takes times
    public void delay(int milliSeconds){
        try {
            Thread.sleep(milliSeconds);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }


}
