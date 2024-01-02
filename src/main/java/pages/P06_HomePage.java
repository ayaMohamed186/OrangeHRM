package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P06_HomePage {

    WebDriver driver;

    public P06_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By dashboardBtn = By.xpath("//a[@class='oxd-main-menu-item active']");

    public P06_HomePage waitUntilHomePageLoad(){
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.dashboardBtn));
        return this;
    }
}
