package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P01_LoginPage {
    WebDriver driver;

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By userName = By.xpath("//input[@name = 'username' and @placeholder = 'Username']");
    private final By password = By.xpath("//input[@type='password']");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By timeAtWorkSection = By.xpath("(//p[@class='oxd-text oxd-text--p'])[1]");

    public P01_LoginPage fillUsername(String username) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.userName));
        driver.findElement(this.userName).sendKeys(username);
        return this;
    }

    public P01_LoginPage fillPassword(String password) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.password));
        driver.findElement(this.password).sendKeys(password);
        return this;
    }

    public P01_LoginPage clickLoginButton() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.loginButton));
        }catch (TimeoutException ex){
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.loginButton).click();
        return this;
    }

    public boolean validateIfLoginSuccess(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.timeAtWorkSection));
        return driver.findElement(timeAtWorkSection).getText().equals("Time at Work");
    }


}
