package cz.czechitas.domaci_ukol;

import org.openqa.selenium.*;

public class HomePage {

    private WebDriver browser;

    private By userNameElement = By.id("signin_userName");

    public HomePage(WebDriver webDriver) {
        browser = webDriver;
    }

    public void findAndFillCustomerEmailField(String email) {
        System.out.println("fill customer email");
        WebElement emailField = browser.findElement(userNameElement);
        emailField.sendKeys(email);
    }

    public void findAndFillCustomerPassword(String password) {
        System.out.println("fill customer password");
        WebElement passwordField = browser.findElement(By.id("signin_password"));
        passwordField.sendKeys(password);
    }

    public void findAndClickSignIn() {
        System.out.println("click on Sign in");
        WebElement btnSignIn = browser.findElement(By.id("genericLogin-button"));
        btnSignIn.click();
    }

    public boolean isInvalidUserAlertPresent() {
        System.out.println("presence of invalid user alert");
        WebElement alert = browser.findElement(By.id("loginError"));
        return alert.isEnabled();
    }
}