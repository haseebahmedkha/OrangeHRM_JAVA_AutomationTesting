package demo.orangehrm.org.sidebar;

import com.base.BasePage;
import org.openqa.selenium.By;

public class Pim extends BasePage {

    private By pimTitle = By.xpath("//h6[normalize-space()='PIM']");

    public boolean isPimTitleDisplayed(){
        return find(pimTitle).isDisplayed();
    }
}
