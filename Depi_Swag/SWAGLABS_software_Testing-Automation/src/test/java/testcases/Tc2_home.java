package testcases;

import common.PageBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P02_HomePage;
import pages.P03_CartPage;
import pages.P04_CheckoutStepOnePage;
import util.Utility;

public class Tc2_home extends TestBase {

    // Using this variable in assertion
    static double totalPrice;

    @Test(priority = 2)
    public void getSelectedData() {
        totalPrice = new P02_HomePage(driver)
                .addItemToCart()
                .enterCartPage()
                .getTotalPrice();
        PageBase.captureScreenshot(driver, "AddToCart");

    }

    @Test(priority =6)
    public void validateRemovingItemFromCart() {
        totalPrice = new P02_HomePage(driver).removeItemFromCart().getTotalPrice();
        PageBase.captureScreenshot(driver, "RemoveFromCart");

    }

}
