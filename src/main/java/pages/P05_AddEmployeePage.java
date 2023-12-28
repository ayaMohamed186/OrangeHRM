package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        driver.findElement(this.addBtn).click();
        return this;
    }

    public P05_AddEmployeePage fillFirstName(String firstName) {
        driver.findElement(this.firstNameInputField).sendKeys(firstName);
        return this;
    }

    public P05_AddEmployeePage fillMiddleName(String middleName) {
        driver.findElement(this.middleNameInputField).sendKeys(middleName);
        return this;
    }

    public P05_AddEmployeePage fillLastName(String lastName) {
        driver.findElement(this.lastNameInputField).sendKeys(lastName);
        return this;
    }

    public P05_AddEmployeePage clickOnSaveBtn() {
        driver.findElement(this.saveBtn).click();
        return this;
    }

    public boolean validateEmployeeAdded(String employeeName){
        String expectedUserAddedName = driver.findElement(this.employeeAddedName).getText();
        return expectedUserAddedName.equals(employeeName);
    }
}
