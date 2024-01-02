package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P07_EmployeeListForPimPage {

    WebDriver driver;

    public P07_EmployeeListForPimPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By personalDetailsBtn = By.xpath("//a[@class='orangehrm-tabs-item --active']");
    private final By nickNameField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    public P07_EmployeeListForPimPage waitUntilPageLoad(){
        longWait(driver).until(ExpectedConditions.elementToBeClickable(this.personalDetailsBtn));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return this;
    }


}
