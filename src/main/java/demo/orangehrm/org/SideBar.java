package demo.orangehrm.org;
import com.base.BasePage;
import demo.orangehrm.org.sidebar.*;
import org.openqa.selenium.By;

import java.rmi.dgc.Lease;
import java.sql.Time;

public class SideBar extends BasePage {

    // sidebar Variables
    final private By sideBarElement = By.xpath("//button[@role='none']");
    final private By sideBarAdmin = By.xpath("//li[1]//a[1]//span[1]");
    final private By pimElement = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']");
    final private By leaveElement = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Leave']");
    final private By timeElement = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Time']");
    final private By recruitmentElement = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Recruitment']");
    final private By myInfoElement = By.xpath("//span[normalize-space()='My Info']");

    // click on Sidebar for left and Right
    public void clickOnSideBar(){
        click(sideBarElement);
    }

    // click Admin on a SideBar
    public Admin clickOnAdmin(){
        click(sideBarAdmin);
        return new Admin();
    }

    // click PIM on a SideBar
    public Pim clickOnPim(){
        click(pimElement);
        return new Pim();
    }

    // click Leave on a SideBar
    public Leave clickOnLeave(){
        click(leaveElement);
        return new Leave();
    }

    // click Time on a SideBar
    public TimeSideBar clickOnTime(){
        click(timeElement);
        return new TimeSideBar();
    }

    // click Recruitment on a SideBar
    public Recruitment clickOnRecruitment(){
        click(recruitmentElement);
        return new Recruitment();
    }

    // click My Info on a SideBar
    public MyInfo clickOnMyInfo(){
        click(myInfoElement);
        return new MyInfo();
    }




}
