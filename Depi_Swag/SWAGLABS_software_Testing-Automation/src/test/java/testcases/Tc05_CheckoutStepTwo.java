package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P02_HomePage;
import pages.P05_CheckoutStepTwo;

import static testcases.Tc2_home.totalPrice;

public class Tc05_CheckoutStepTwo extends TestBase
{
    @Test(priority = 7, dependsOnGroups = {"checkoutStepOne"})
    public void submitOrder()
    {
        System.out.println("HelloWorld" + totalPrice);
        Assert.assertTrue(new P05_CheckoutStepTwo(driver).checkTotalEqualToSum(totalPrice));
        new P05_CheckoutStepTwo(driver).clickFinishOrder();
    }

    @Test(priority = 5, dependsOnGroups = {"checkoutStepOne"})
    public void returnBackToHome()
    {
        new P05_CheckoutStepTwo(driver).clickCancelButton();
    }
}
