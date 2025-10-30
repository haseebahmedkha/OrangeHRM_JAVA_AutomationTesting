package demo.orangehrm.org;

import com.base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    // Home Page Elements Variables
    private By title = By.xpath("//h6[normalize-space()='Dashboard']");
    private By sideButton = By.xpath("//button[@role='none']");

    // to find Header is Displayed
    public String returnHeaderText(){
        return find(title).getText();
    }

    // to check is Header Displayed
    public boolean isHeaderDisplayed(){
        return find(title).isDisplayed();
    }

    // return to the SideBar Class
    public SideBar clickSideBarForShowHide(){
        click(sideButton);
        return new SideBar();
    }
}
