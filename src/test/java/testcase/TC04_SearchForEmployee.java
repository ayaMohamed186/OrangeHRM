package testcase;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_AdminPage;
import pages.P04_PimPage;
import util.Utility;

import java.io.IOException;

import static util.Utility.captureScreenshot;

public class TC04_SearchForEmployee extends TestBase{
    String userName = Utility.getSingleJsonData(System.getProperty("user.dir")+"/src/test/resources/data_driven/loginData.json" ,  "userName");
    String password=Utility.getExcelData(0,0,"loginData");

    String employeeName = faker.regexify("[a-z]{1}");
    int randomNumber = faker.number().numberBetween(1, 99);
    String randomEmployeeNumber = String.format("%04d", randomNumber);
    String supervisorName = faker.regexify("[a-z]{1}");

    public TC04_SearchForEmployee() throws IOException, ParseException {
    }

    @Test(priority = 1)
    public void searchForEmployee() throws InterruptedException {
        Thread.sleep(2000);
        new P01_LoginPage(driver).fillUsername(userName).fillPassword(password).clickLoginButton();
        Thread.sleep(2000);

        new P04_PimPage(driver).clickOnPimTab();
        Thread.sleep(1000);
        new P04_PimPage(driver).fillEmployeeName(employeeName).fillEmployeeID(randomEmployeeNumber).selectEmploymentStatus().
                fillSupervisorName(supervisorName).clickOnSearchBtn();
        Thread.sleep(5000);

        //screenSHot
        captureScreenshot(driver,"SearchForEmployee");

        //Assert search work
        Assert.assertTrue(new P02_AdminPage(driver).validateIfSearchSuccess());


    }

}
