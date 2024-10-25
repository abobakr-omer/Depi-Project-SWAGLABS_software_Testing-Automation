package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_CheckoutStepOnePage {
    WebDriver driver;

    public P04_CheckoutStepOnePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By submit = By.xpath("(//input)[@type='submit']");


    public P04_CheckoutStepOnePage enterFirstName(String firstName) {
        driver.findElement(this.firstName).sendKeys(firstName);
        return this;
    }

    public P04_CheckoutStepOnePage enterLastName(String lastName) {
        driver.findElement(this.lastName).sendKeys(lastName);
        return this;
    }

    public P04_CheckoutStepOnePage enterPostalCode(String postalCode) {
        driver.findElement(this.postalCode).sendKeys(postalCode);
        return this;
    }

    public void clickSubmit() {
        driver.findElement(submit).click();
    }

}
