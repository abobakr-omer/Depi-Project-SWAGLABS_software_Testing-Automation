package testcases;

import common.PageBase;
import org.testng.annotations.Test;
import pages.P03_CartPage;

public class Tc3_Cart extends TestBase
{
    @Test(priority = 3)
    public void enterCheckout()
    {
        new P03_CartPage(driver).enterCheckoutStepOnePage();
        PageBase.captureScreenshot(driver, "OpenCheckout");
    }
}
