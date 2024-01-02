package testcase;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_LoginPage;
import pages.P06_HomePage;
import retryTest.Retry;
import util.Utility;

import java.io.IOException;

import static pages.PageBase.waitForPageLoad;
import static util.Utility.captureScreenshot;


public class TC01_Login extends TestBase {
    String userName = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/loginData.json", "userName");
    String password = Utility.getExcelData(0, 0, "loginData");

    public TC01_Login() throws IOException, ParseException {
    }

    @Test(priority = 1, description = " Login with register user data ", retryAnalyzer = Retry.class)
    public void loginWithRegisteredUser_P() {
        // waitForPageLoad(driver); // wait untill al DOM Js loaded
        new P01_LoginPage(driver).fillUsername(userName).fillPassword(password).clickLoginButton();

        new P06_HomePage(driver).waitUntilHomePageLoad();

        captureScreenshot(driver, "LoginSystem");

        Assert.assertTrue(new P01_LoginPage(driver).validateIfLoginSuccess());
    }

    @Test(priority = 2, description = "Check Login Functionality with Valid username and Invalid Password")
    public void loginWithValidUsernameAndWrongPassword_N() {
        password = "789";
        new P01_LoginPage(driver).fillUsername(userName).fillPassword(password).clickLoginButton();

        captureScreenshot(driver, "FailedLoginSystem");
    }

    @Test(priority = 3, description = "Check Login Functionality with Invalid username and Valid Password")
    public void loginWithValidPasswordAndInvalidMail_N() {
        password = Utility.getExcelData(0, 0, "loginData");
        userName = "ayaa";
        new P01_LoginPage(driver).fillUsername(userName).fillPassword(password).clickLoginButton();

        captureScreenshot(driver, "FailedLoginSystem2");
    }

    @Test(priority = 4, description = "Check Login Functionality with Invalid username and Invalid Password")
    public void loginWithInvalidCredentials_N() {
        password = "789";
        userName = "ayaa";
        new P01_LoginPage(driver).fillUsername(userName).fillPassword(password).clickLoginButton();

        captureScreenshot(driver, "FailedLoginSystem3");
    }


}
