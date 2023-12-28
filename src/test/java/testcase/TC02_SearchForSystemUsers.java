package testcase;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_AdminPage;
import util.Utility;

import java.io.IOException;

public class TC02_SearchForSystemUsers extends TestBase{

    String userName = Utility.getSingleJsonData(System.getProperty("user.dir")+"/src/test/resources/data_driven/loginData.json" ,  "userName");
    String password=Utility.getExcelData(0,0,"loginData");
    String userNameInputField = "Linda.Anderson";
    String employeeName = "Linda Anderson";
    public TC02_SearchForSystemUsers() throws IOException, ParseException {
    }

    @Test(priority = 1 , description = " Logged user search at admin page " )
    public void searchAtSystemUsers() throws InterruptedException {
        Thread.sleep(2000);
        new P01_LoginPage(driver).fillUsername(userName).fillPassword(password).clickLoginButton();
        Thread.sleep(3000);

        new P02_AdminPage(driver).clickOnAdminTab();
        Thread.sleep(1000);
        new P02_AdminPage(driver).fillUserNameInputField(userNameInputField).selectUserRole().
                fillEmployeeNameInputField(employeeName);
        Thread.sleep(1500);
        new P02_AdminPage(driver).selectUserStatus().clickOnSearchBtn();
        Thread.sleep(2000);

        // capture screen shot
        Utility.captureScreenshot(driver,"SearchForSystemUser");

        //Assert search work
        Assert.assertTrue(new P02_AdminPage(driver).validateIfSearchSuccess());



    }
}
