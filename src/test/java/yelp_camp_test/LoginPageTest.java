package yelp_camp_test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;

public class LoginPageTest extends Base{

    public static Logger logs = LogManager.getLogger(Base.class.getName());

    LandingPage landingPageElements;
    LoginPage loginPageElements;

    @BeforeClass
    public void initElements() {
        landingPageElements = PageFactory.initElements(driver, LandingPage.class);
        loginPageElements = PageFactory.initElements(driver, LoginPage.class);
    }


    @Test(priority = 3)
    public void checkNavigation() {
        Assert.assertTrue(landingPageElements.navbar.isDisplayed());
        Assert.assertTrue(landingPageElements.footer.isDisplayed());
        logs.info("Navbar and footer are present");
    }

    @Test(priority = 4)
    public void userLogin() {
        Assert.assertTrue(loginPageElements.userNameInput.isDisplayed());
        loginPageElements.userNameInput.sendKeys("HelloWorld");
        logs.info("Provided user login");
    }

    @Test(priority = 5)
    public void userPass() {
        Assert.assertTrue(loginPageElements.passwordInput.isDisplayed());
        loginPageElements.passwordInput.sendKeys("HelloWorld");
        logs.info("Provided user password");
    }

    @Test(priority = 6)
    public void clickLoginButton() {
        Assert.assertTrue(loginPageElements.loginSubmit.isDisplayed());
        loginPageElements.loginSubmit.click();
        logs.info("Clicking on login button");
    }

    @Test(priority = 7)
    public void checkRouteChange() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://morning-wildwood-15402.herokuapp.com/campgrounds");
    }

    @Test(priority = 8)
    public void checkAlertDisplay() {
        Assert.assertTrue(landingPageElements.alert.isDisplayed());
        Assert.assertEquals(landingPageElements.getAlertText(), "Welcome!");
    }

}
