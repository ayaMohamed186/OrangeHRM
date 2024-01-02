package testcase;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_AdminPage;
import pages.P03_AddSystemUserPage;
import util.Utility;

import java.io.IOException;

import static pages.PageBase.waitForPageLoad;

public class TC03_AddSystemUser extends TestBase {
    String userName = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/loginData.json", "userName");
    String password = Utility.getExcelData(0, 0, "loginData");
    String userRole = "Admin";
    String employeeName = faker.regexify("[a-z]{1}");
    String userStatus = "Enabled";

    static String  userNameForAdd = faker.name().username();
    String passwordForAdd = faker.internet().password();

    public TC03_AddSystemUser() throws IOException, ParseException {
    }

    @Test(priority = 1)
    public void addNewSystemUser() throws InterruptedException {
        new P01_LoginPage(driver).fillUsername(userName).fillPassword(password).clickLoginButton();
        new P02_AdminPage(driver).clickOnAdminTab();
        new P03_AddSystemUserPage(driver).addSystemUser();
        new P03_AddSystemUserPage(driver).selectUserRole(userRole).addEmployeeName(employeeName).
                selectStatus(userStatus).fillUserName(userNameForAdd).fillPassword(passwordForAdd).fillConfirmPassword(passwordForAdd).
                clickOnSaveBtn();

        Utility.captureScreenshot(driver,"AddNewUser");

        // search that user added successfully
        new P02_AdminPage(driver).waitUntilPageLoad();
        new P02_AdminPage(driver).fillUserNameInputField(userNameForAdd).selectUserRole().
                fillEmployeeNameInputField(employeeName).selectUserStatus().clickOnSearchBtn();

        //Assert that new user added successfully
        Assert.assertTrue(new P02_AdminPage(driver).validateIfSearchSuccess());
    }
}
