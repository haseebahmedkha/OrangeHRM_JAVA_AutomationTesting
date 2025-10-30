package demo.orangehrm.org;

import com.base.BasePage;
import org.openqa.selenium.By;

public class SideBar extends BasePage {

    // sidebar Variables
    private By sideBarElement = By.xpath("//button[@role='none']");

    // click on Sidebar for left and Right
    public void clickOnSideBar(){
        click(sideBarElement);
    }


}
