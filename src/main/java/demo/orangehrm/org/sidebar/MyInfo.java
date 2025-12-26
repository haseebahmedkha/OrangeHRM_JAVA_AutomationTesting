package demo.orangehrm.org.sidebar;

import com.base.BasePage;
import org.openqa.selenium.By;

public class MyInfo extends BasePage {

    final private By myInfoTitleElement = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");


    public boolean isMyInfoTitleDisplayed(){
        return find(myInfoTitleElement).isDisplayed();
    }

    public String returnMyInfoTitle(){
        return find(myInfoTitleElement).getText();
    }
}
