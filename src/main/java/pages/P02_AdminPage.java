package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class P02_AdminPage {

    WebDriver driver;

    public P02_AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By adminTab = By.xpath("(//a[@class='oxd-main-menu-item'])[1]");
    private final By userNameInputField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private final By userRoleDropDown = By.xpath("(//div[@tabindex='0'])[1]");
    private final By employeeNameInputField = By.xpath("//input[@placeholder='Type for hints...']");
    private final By userStatus = By.xpath("(//div[@tabindex='0'])[2]");
    private final By searchBtn = By.xpath("//button[@type='submit']");
    private final By oneRecordDisplayElement = By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]");

    public P02_AdminPage clickOnAdminTab() {
        driver.findElement(this.adminTab).click();
        return this;
    }

    public P02_AdminPage fillUserNameInputField(String userName) {
        driver.findElement(this.userNameInputField).sendKeys(userName);
        return this;
    }

    public P02_AdminPage selectUserRole() {
        driver.findElement(userRoleDropDown).click();
        driver.findElement(userRoleDropDown).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(userRoleDropDown).sendKeys(Keys.ENTER);
        return this;
    }

    public P02_AdminPage fillEmployeeNameInputField(String employeeName) throws InterruptedException {
        driver.findElement(employeeNameInputField).sendKeys(employeeName);
        Thread.sleep(2000);
        driver.findElement(employeeNameInputField).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(employeeNameInputField).sendKeys(Keys.ENTER);
        return this;
    }

    public P02_AdminPage selectUserStatus() {
        driver.findElement(userStatus).click();
        driver.findElement(userStatus).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(userStatus).sendKeys(Keys.ENTER);
        return this;
    }

    public P02_AdminPage clickOnSearchBtn() {
        driver.findElement(this.searchBtn).click();
        return this;
    }

    public boolean validateIfSearchSuccess() {
        if (driver.findElement(oneRecordDisplayElement).getText().equals("(1) Record Found"))
            return driver.findElement(oneRecordDisplayElement).getText().equals("(1) Record Found");
        else
            return driver.findElement(oneRecordDisplayElement).getText().equals("No Records Found");
    }
}
