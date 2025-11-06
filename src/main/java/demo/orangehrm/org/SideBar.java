package demo.orangehrm.org;

import com.base.BasePage;
import demo.orangehrm.org.sidebar.Admin;
import demo.orangehrm.org.sidebar.Pim;
import org.openqa.selenium.By;

public class SideBar extends BasePage {

    // sidebar Variables
    private By sideBarElement = By.xpath("//button[@role='none']");
    private By sideBarAdmin = By.xpath("//li[1]//a[1]//span[1]");
    private By pimElement = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']");

    // click on Sidebar for left and Right
    public void clickOnSideBar(){
        click(sideBarElement);
    }

    // click Admin on a SideBar
    public Admin clickOnAdmin(){
        click(sideBarAdmin);
        return new Admin();
    }

    public Pim clickOnPim(){
        click(pimElement);
        return new Pim();
    }


}
