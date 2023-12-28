package testcase;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P04_PimPage;
import pages.P05_AddEmployeePage;
import util.Utility;

import java.io.IOException;

public class TC05_AddEmployee extends TestBase {
    String userName = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/loginData.json", "userName");
    String password = Utility.getExcelData(0, 0, "loginData");
    String firstNameInputField = faker.name().firstName();
    String middleNameInputField = faker.name().lastName();
    String lastNameInputField = faker.name().lastName();

    public TC05_AddEmployee() throws IOException, ParseException {
    }

    @Test(priority = 1)
    public void addEmployee() throws InterruptedException {
        Thread.sleep(2000);
        new P01_LoginPage(driver).fillUsername(userName).fillPassword(password).clickLoginButton();
        Thread.sleep(2000);

        new P04_PimPage(driver).clickOnPimTab();
        Thread.sleep(1000);

        new P05_AddEmployeePage(driver).clickOnAddBtn();
        Thread.sleep(1000);

        new P05_AddEmployeePage(driver).fillFirstName(firstNameInputField).fillMiddleName(middleNameInputField).
                fillLastName(lastNameInputField).clickOnSaveBtn();
        Thread.sleep(7000);

        //capture screenSHot
        Utility.captureScreenshot(driver,"AddNewEmployee");

        //assertion
        String actualNameAdded = firstNameInputField + " " + lastNameInputField; //which already added by user
        Assert.assertTrue(new P05_AddEmployeePage(driver).validateEmployeeAdded(actualNameAdded)); //compare it with actual display in employee list
    }
}
