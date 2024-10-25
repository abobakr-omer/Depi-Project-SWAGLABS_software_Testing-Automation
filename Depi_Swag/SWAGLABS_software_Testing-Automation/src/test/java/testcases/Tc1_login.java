package testcases;

import common.PageBase;
import org.testng.annotations.Test;
import pages.P01_LoginPage;

public class Tc1_login extends TestBase {

    String userName = "standard_user";
    String password = "secret_sauce";

    @Test(priority = 1, description = "Login with valid data")
    public void login() {
        new P01_LoginPage(driver).enterUserName(userName).enterPassword(password).login();
        PageBase.captureScreenshot(driver, "Login");
    }

}
