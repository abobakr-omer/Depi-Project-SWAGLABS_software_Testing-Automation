package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_CartPage {
    WebDriver driver;

    public P03_CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By checkout = By.xpath("(//a)[text()='CHECKOUT']");

    public void enterCheckoutStepOnePage() {
        driver.findElement(checkout).click();
    }

}
