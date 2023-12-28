package testcase;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_LoginPage;
import util.Utility;

import java.io.IOException;

import static util.Utility.captureScreenshot;


public class TC01_Login extends TestBase{
    String userName = Utility.getSingleJsonData(System.getProperty("user.dir")+"/src/test/resources/data_driven/loginData.json" ,  "userName");
    String password=Utility.getExcelData(0,0,"loginData");
    public TC01_Login() throws IOException, ParseException {
    }


    @Test(priority = 1 , description = " Login with register user data " )
    public void loginWithRegisteredUser_P() throws InterruptedException {
        Thread.sleep(2000);
        new P01_LoginPage(driver).fillUsername(userName).fillPassword(password).clickLoginButton();
        Thread.sleep(2500);

        //TODO: Capture ScreenShot
        captureScreenshot(driver,"LoginSystem");

        // TODO: assert if login successfully
        Assert.assertTrue(new P01_LoginPage(driver).validateIfLoginSuccess());
    }

    @Test(priority = 2,description = "Check Login Functionality with Valid username and Invalid Password")
    public void loginWithValidUsernameAndWrongPassword_N() throws InterruptedException {
        password="789";
        Thread.sleep(2000);
        new P01_LoginPage(driver).fillUsername(userName).fillPassword(password).clickLoginButton();
        Thread.sleep(2500);

        captureScreenshot(driver,"FailedLoginSystem");
    }

    @Test(priority = 3,description = "Check Login Functionality with Invalid username and Valid Password")
    public void loginWithValidPasswordAndInvalidMail_N() throws InterruptedException {
        password = Utility.getExcelData(0,0,"loginData");
        userName = "ayaa";
        Thread.sleep(2000);
        new P01_LoginPage(driver).fillUsername(userName).fillPassword(password).clickLoginButton();
        Thread.sleep(2500);

        captureScreenshot(driver,"FailedLoginSystem2");
    }

    @Test(priority = 4,description = "Check Login Functionality with Invalid username and Invalid Password")
    public void loginWithInvalidCredentials_N() throws InterruptedException {
        password = "789";
        userName = "ayaa";
        Thread.sleep(2000);
        new P01_LoginPage(driver).fillUsername(userName).fillPassword(password).clickLoginButton();
        Thread.sleep(2500);

        captureScreenshot(driver,"FailedLoginSystem3");
    }



}
