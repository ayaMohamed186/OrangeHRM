package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

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

    public P03_AddSystemUserPage addSystemUser(){
        driver.findElement(this.addUserBtn).click();
        return this;
    }

    public P03_AddSystemUserPage selectUserRole(String userRole) throws InterruptedException {
        driver.findElement(userRoleDropDown).sendKeys(userRole);
        Thread.sleep(2000);
        driver.findElement(userRoleDropDown).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(userRoleDropDown).sendKeys(Keys.ENTER);
        return this;
    }
    public P03_AddSystemUserPage addEmployeeName(String employeeName) throws InterruptedException {
        driver.findElement(employeeNameInputField).sendKeys(employeeName);
        Thread.sleep(2000);
        driver.findElement(employeeNameInputField).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(employeeNameInputField).sendKeys(Keys.ENTER);
        return this;
    }

    public P03_AddSystemUserPage selectStatus(String userStatus) throws InterruptedException {
       // driver.findElement(statusDropDown).sendKeys(userStatus);
        driver.findElement(statusDropDown).click();
        Thread.sleep(2000);
        driver.findElement(statusDropDown).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(statusDropDown).sendKeys(Keys.ENTER);
        return this;
    }

    public P03_AddSystemUserPage addUserName(String userName){
        driver.findElement(this.userNameInputField).sendKeys(userName);
        return this;
    }
    public P03_AddSystemUserPage fillPassword(String Password){
        driver.findElement(this.passwordInputField).sendKeys(Password);
        return this;
    }
    public P03_AddSystemUserPage fillConfirmPassword(String ConfirmPassword){
        driver.findElement(this.confirmPasswordInputField).sendKeys(ConfirmPassword);
        return this;
    }
    public P03_AddSystemUserPage clickOnSaveBtn(){
        driver.findElement(this.saveBtn).click();
        return this;
    }

}
