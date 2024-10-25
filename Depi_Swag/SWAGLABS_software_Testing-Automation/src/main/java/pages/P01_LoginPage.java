package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    WebDriver driver;

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By userName = By.xpath("(//input)[@data-test='username']");
    private final By password = By.xpath("(//input)[@data-test='password']");
    private final By loginButton = By.id("login-button");

    public P01_LoginPage enterUserName(String userName){
        driver.findElement(this.userName).sendKeys(userName);
        return this;
    }

    public P01_LoginPage enterPassword(String password){
        driver.findElement(this.password).sendKeys(password);
        return this;
    }

    public void login(){
        driver.findElement(this.loginButton).click();
    }
}
