package demo.orangehrm.org;

import com.base.BasePage;
import com.utilities.DropDownUtility;
import com.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LogoutPage extends HomePage {
        private By dropDownElement = By.xpath("//p[@class='oxd-userdropdown-name']");
        private By logoutElement = By.xpath("//a[normalize-space()='Logout']");


        // to Click on DropDown
        public void clickOnDropDown(){
            click(dropDownElement);
        }

        // to click on Logout in a Dropdown
        public void clickOnLogout(){
            click(logoutElement);
        }


}
