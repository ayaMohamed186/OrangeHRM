package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static pages.PageBase.shortWait;
import static pages.PageBase.waitForPageLoad;

public class P03_AddSystemUserPage {
    WebDriver driver;

    public P03_AddSystemUserPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By addUserBtn = By.xpath("(//button[@type='button'])[5]");
    private final By userRoleDropDown = By.xpath("(//div[@tabindex='0'])[1]");
    private final By employeeNameInputField = By.xpath("(//input)[2]");
    private final By statusDropDown = By.xpath("(//div[@tabindex='0'])[2]");
    private final By userNameInputField = By.xpath("(//input[@autocomplete='off'])[1]");
    private final By passwordInputField = By.xpath("(//input[@type='password'])[1]");
    private final By confirmPasswordInputField = By.xpath("(//input[@type='password'])[2]");
    private final By saveBtn = By.xpath("//button[@type='submit']");

    public P03_AddSystemUserPage addSystemUser() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.addUserBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.addUserBtn).click();
        return this;
    }

    public P03_AddSystemUserPage selectUserRole(String userRole) throws InterruptedException {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.userRoleDropDown));

        driver.findElement(userRoleDropDown).sendKeys(userRole);
        Thread.sleep(2000);
        driver.findElement(userRoleDropDown).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(userRoleDropDown).sendKeys(Keys.ENTER);
        return this;
    }

    public P03_AddSystemUserPage addEmployeeName(String employeeName) throws InterruptedException {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.employeeNameInputField));
        driver.findElement(employeeNameInputField).sendKeys(employeeName);
        Thread.sleep(2000);
        driver.findElement(employeeNameInputField).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(employeeNameInputField).sendKeys(Keys.ENTER);
        return this;
    }

    public P03_AddSystemUserPage selectStatus(String userStatus) throws InterruptedException {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.statusDropDown));
        driver.findElement(statusDropDown).click();
        Thread.sleep(2000);
        driver.findElement(statusDropDown).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(statusDropDown).sendKeys(Keys.ENTER);
        return this;
    }

    public P03_AddSystemUserPage fillUserName(String userName) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.userNameInputField));
        driver.findElement(this.userNameInputField).sendKeys(userName);
        return this;
    }

    public P03_AddSystemUserPage fillPassword(String Password) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.passwordInputField));
        driver.findElement(this.passwordInputField).sendKeys(Password);
        return this;
    }

    public P03_AddSystemUserPage fillConfirmPassword(String ConfirmPassword) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.confirmPasswordInputField));
        driver.findElement(this.confirmPasswordInputField).sendKeys(ConfirmPassword);
        return this;
    }

    public P03_AddSystemUserPage clickOnSaveBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.saveBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.saveBtn).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return this;
    }

}
