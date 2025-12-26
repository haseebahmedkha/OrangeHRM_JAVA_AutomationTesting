package demo.orangehrm.org.sidebar;

import com.base.BasePage;
import org.openqa.selenium.By;

public class Leave extends BasePage {

    private By leaveTitleElement = By.xpath("//h6[normalize-space()='Leave']");

    public boolean isLeaveTitleDisplayed(){
        return find(leaveTitleElement).isDisplayed();
    }

    public String returnLeaveTitle(){
        return find(leaveTitleElement).getText();
    }
}
