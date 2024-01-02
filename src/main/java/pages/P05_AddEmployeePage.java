package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P05_AddEmployeePage {
    WebDriver driver;

    public P05_AddEmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By addBtn = By.xpath("(//button[@type='button'])[4]");
    private final By firstNameInputField = By.xpath("//input[@name='firstName']");
    private final By middleNameInputField = By.xpath("//input[@name='middleName']");
    private final By lastNameInputField = By.xpath("//input[@name='lastName']");
    private final By saveBtn = By.xpath("//button[@type='submit']");
    public final By employeeAddedName = By.xpath("//h6[@class='oxd-text oxd-text--h6 --strong']");

    public P05_AddEmployeePage clickOnAddBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.addBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.addBtn).click();
        return this;
    }

    public P05_AddEmployeePage fillFirstName(String firstName) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.firstNameInputField));
        driver.findElement(this.firstNameInputField).sendKeys(firstName);
        return this;
    }

    public P05_AddEmployeePage fillMiddleName(String middleName) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.middleNameInputField));
        driver.findElement(this.middleNameInputField).sendKeys(middleName);
        return this;
    }

    public P05_AddEmployeePage fillLastName(String lastName) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.lastNameInputField));
        driver.findElement(this.lastNameInputField).sendKeys(lastName);
        return this;
    }

    public P05_AddEmployeePage clickOnSaveBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.saveBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.saveBtn).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

    public boolean validateEmployeeAdded(String employeeName){
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.employeeAddedName));
        String expectedUserAddedName = driver.findElement(this.employeeAddedName).getText();
        System.out.println("employee added is " + expectedUserAddedName);
        return expectedUserAddedName.equals(employeeName);
    }
}
