package demo.orangehrm.org;
import com.base.BasePage;
import demo.orangehrm.org.sidebar.*;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v138.filesystem.model.Directory;
import java.rmi.dgc.Lease; import java.sql.Time;

/**
 * SideBar Page Object
 * -------------------
 * Represents the left-hand sidebar in the OrangeHRM application.
 *
 * Responsibilities:
 * - Provide methods to click on each module in the sidebar.
 * - Return the respective page object after clicking a module.
 *
 * Extends BasePage to reuse generic Selenium actions.
 */
public class SideBar extends BasePage {

    // -------------------------------
    // Locators for sidebar items
    // -------------------------------
    private final By sideBarToggle = By.xpath("//button[@role='none']");
    private final By adminModule = By.xpath("//li[1]//a[1]//span[1]");
    private final By pimModule = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']");
    private final By leaveModule = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Leave']");
    private final By timeModule = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Time']");
    private final By recruitmentModule = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Recruitment']");
    private final By myInfoModule = By.xpath("//span[normalize-space()='My Info']");
    private final By performanceModule = By.xpath("//a[@class='oxd-main-menu-item active']//span[1]");
    private final By dashboardModule = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Dashboard']");
    private final By directoryModule = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Directory']");

    // -------------------------------
    // Sidebar Actions
    // -------------------------------

    /** Clicks the sidebar toggle to expand/collapse the sidebar */
    public void clickSidebarToggle() {
        click(sideBarToggle);
    }

    /** Clicks the Admin module and returns the Admin page object */
    public Admin clickOnAdmin() {
        click(adminModule);
        return new Admin();
    }

    /** Clicks the PIM module and returns the Pim page object */
    public Pim clickOnPim() {
        click(pimModule);
        return new Pim();
    }

    /** Clicks the Leave module and returns the Leave page object */
    public Leave clickOnLeave() {
        click(leaveModule);
        return new Leave();
    }

    /** Clicks the Time module and returns the TimeSideBar page object */
    public TimeSideBar clickOnTime() {
        click(timeModule);
        return new TimeSideBar();
    }

    /** Clicks the Recruitment module and returns the Recruitment page object */
    public Recruitment clickOnRecruitment() {
        click(recruitmentModule);
        return new Recruitment();
    }

    /** Clicks the My Info module and returns the MyInfo page object */
    public MyInfo clickOnMyInfo() {
        click(myInfoModule);
        return new MyInfo();
    }

    /** Clicks the Performance module and returns the Performance page object */
    public Performance clickOnPerformance() {
        click(performanceModule);
        return new Performance();
    }

    /** Clicks the Dashboard module and returns the Dashboard page object */
    public Dashboard clickOnDashboard() {
        click(dashboardModule);
        return new Dashboard();
    }

    /** Clicks the Directory module and returns the Directory page object */
    public DirectorySb clickOnDirectory() {
        click(directoryModule);
        return new DirectorySb();
    }

}
