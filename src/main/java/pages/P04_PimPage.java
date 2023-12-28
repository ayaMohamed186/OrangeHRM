package pages;

import junit.framework.Assert;
import org.openqa.selenium.*;

public class P04_PimPage {
    WebDriver driver;

    public P04_PimPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By PimTab = By.xpath("(//span)[2]");
    private final By employeeNameInputField = By.xpath("(//input)[2]");
    private final By employeeIdInputField = By.xpath("(//input)[3]");
    private final By employmentStatusSelect = By.xpath("(//div[@tabindex='0'])[1]");
    private final By supervisorNameInputField = By.xpath("(//input)[4]");
    private final By searchBtn = By.xpath("//button[@type='submit']");

    public P04_PimPage clickOnPimTab() {
        driver.findElement(this.PimTab).click();
        return this;
    }

    public P04_PimPage fillEmployeeName(String employeeName) throws InterruptedException {
        driver.findElement(employeeNameInputField).sendKeys(employeeName);
        Thread.sleep(2000);
        driver.findElement(employeeNameInputField).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(employeeNameInputField).sendKeys(Keys.ENTER);
        return this;
    }

    public P04_PimPage fillEmployeeID(String employeeID) {
        driver.findElement(this.employeeIdInputField).sendKeys(employeeID);
        return this;
    }

    public P04_PimPage selectEmploymentStatus() throws InterruptedException {
        driver.findElement(employmentStatusSelect).click();
        Thread.sleep(2000);
        driver.findElement(employmentStatusSelect).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(employmentStatusSelect).sendKeys(Keys.ENTER);
        return this;
    }

    public P04_PimPage fillSupervisorName(String supervisorName) throws InterruptedException {
        driver.findElement(supervisorNameInputField).sendKeys(supervisorName);
        Thread.sleep(2000);
        driver.findElement(supervisorNameInputField).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(supervisorNameInputField).sendKeys(Keys.ENTER);
        return this;
    }

    public P04_PimPage clickOnSearchBtn() {
        driver.findElement(this.searchBtn).click();
        return this;
    }




}
