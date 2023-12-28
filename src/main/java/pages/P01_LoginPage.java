package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.findElement(this.userName).sendKeys(username);
        return this;
    }

    public P01_LoginPage fillPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
        return this;
    }

    public P01_LoginPage clickLoginButton() {
        driver.findElement(this.loginButton).click();
        return this;
    }

    public boolean validateIfLoginSuccess(){
        return driver.findElement(timeAtWorkSection).getText().equals("Time at Work");
    }


}
