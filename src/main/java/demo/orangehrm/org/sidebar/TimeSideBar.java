package demo.orangehrm.org.sidebar;

import com.base.BasePage;
import org.openqa.selenium.By;

public class TimeSideBar extends BasePage {

    private By timeTitleElement = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
    private final By timeSheetElement = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-level']");


    // to check its return true
    public boolean isTimeTitleDisplayed(){
        return find(timeTitleElement).isDisplayed();
    }

    // to check its return Time
    public String isReturnTimeTitle(){
        return find(timeTitleElement).getText();
    }

    // to check its return TimeSheet
    public String isReturnTimeSheetTitle(){
        return find(timeSheetElement).getText();
    }


}
