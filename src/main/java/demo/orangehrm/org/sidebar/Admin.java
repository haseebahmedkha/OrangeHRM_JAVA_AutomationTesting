package demo.orangehrm.org.sidebar;

import com.base.BasePage;
import demo.orangehrm.org.HomePage;
import demo.orangehrm.org.SideBar;
import org.openqa.selenium.By;

public class Admin extends BasePage {
    private By adminTitle = By.xpath("//h6[normalize-space()='Admin']");
    private By userManagementTitle = By.xpath("//h6[normalize-space()='User Management']");


    public boolean isAdminTitleDisplayed(){
        return find(adminTitle).isDisplayed();
    }

    public String isUserManagementTitleDisplayed(){
        return find(userManagementTitle).getText();
    }

}
