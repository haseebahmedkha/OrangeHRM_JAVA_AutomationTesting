package demo.orangehrm.org.sidebar;

import com.base.BasePage;
import org.openqa.selenium.By;

public class Recruitment extends BasePage {

    final private By recruitmentTitleElement = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");

    // check title Displayed
    public boolean isRecruitmentTitleDisplayed(){
        return find(recruitmentTitleElement).isDisplayed();
    }

    // check Return Recruitment Title
    public String returnRecruitmentTitle(){
        return find(recruitmentTitleElement).getText();
    }


}
