package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;
    // Locators
    @FindBy(css = "input[type=text]")
    private WebElement usernameField;

    @FindBy(css = "input[type=password]")
    private WebElement passwordField;

    @FindBy(css = "button[type=submit]")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize page elements
    }

    public void navigateToLoginPage(String url) {
            driver.get(url);
    }

    public void enterEmail(String email){
        usernameField.sendKeys(email);
    }

    public void enterPassword(String pass){
        passwordField.sendKeys(pass);
    }

    public void verifyLoginPageElements(){
        Assert.assertTrue(usernameField.isDisplayed());
        Assert.assertTrue(passwordField.isDisplayed());
        Assert.assertTrue(loginButton.isDisplayed());
    }

    public void performLogin(){
        verifyLoginPageElements();
        loginButton.click();
    }
}
