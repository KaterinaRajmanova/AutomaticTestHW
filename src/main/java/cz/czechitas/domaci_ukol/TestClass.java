package cz.czechitas.domaci_ukol;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class TestClass {
    WebDriver browser;

    @Before
    public void SetUp() {

        System.setProperty(
                "webdriver.gecko.driver",
                "/Users/Katerina/DA_Testovani/Teorie/Automatizovane_testovani/SeleniumDrivers/geckodriver"
        );

        browser = new FirefoxDriver();
    }

    @Test
    public void FailedLoginTest() throws InterruptedException {

        browser.navigate().to("https://czechitas-shopizer.azurewebsites.net/shop/customer/customLogon.html");

        HomePage homepage = new HomePage(browser);

        homepage.findAndFillCustomerEmailField("NonExistingCustomer");

        homepage.findAndFillCustomerPassword("FakePass");

        homepage.findAndClickSignIn();

        Thread.sleep(2000);

        Assert.assertTrue(homepage.isInvalidUserAlertPresent());
    }

    @After
    public void CleanUp(){
        browser.quit();
    }
}
