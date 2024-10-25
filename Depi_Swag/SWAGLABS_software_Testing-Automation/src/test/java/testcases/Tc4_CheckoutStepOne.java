package testcases;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.P04_CheckoutStepOnePage;

public class Tc4_CheckoutStepOne extends TestBase {
    Faker faker;

    @Test(priority = 4, groups = {"checkoutStepOne"})
    public void fillCheckoutStepOne() {
        faker = new Faker();
        new P04_CheckoutStepOnePage(driver)
                .enterFirstName(faker.name().firstName())
                .enterLastName(faker.name().lastName())
                .enterPostalCode(faker.address().zipCode())
                .clickSubmit();
    }
}
