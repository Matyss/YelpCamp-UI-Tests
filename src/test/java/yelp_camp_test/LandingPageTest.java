package yelp_camp_test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import resources.Base;

import java.io.IOException;


public class LandingPageTest extends Base {

    public static Logger logs = LogManager.getLogger(Base.class.getName());

    LandingPage landingPageElements;
    LoginPage loginPageElements;

    @BeforeSuite
    public void initBrowser() throws IOException {
        driver = initializeDriver();
        landingPageElements = PageFactory.initElements(driver, LandingPage.class);
        loginPageElements = PageFactory.initElements(driver, LoginPage.class);
        logs.info("Driver is initialized");
    }

    @Test
    public void rootPageNavigation() {
        driver.get(rootURL);

        //Assertions
        Assert.assertTrue(landingPageElements.getLandingPageTitle().contains("YelpCamp"));
        Assert.assertEquals(landingPageElements.getSlideshowSize(), 5);
        logs.info("Successfully navigated to landing page");
    }

    @Test
    public void goToCampgrounds() {
        Assert.assertTrue(landingPageElements.viewCampgroundsButton.isDisplayed());
        landingPageElements.viewCampgroundsButton.click();
        logs.info("Navigation to /campgrounds");
    }

    @Test
    public void clickLogin() {
        Assert.assertTrue(landingPageElements.loginButton.isDisplayed());
        landingPageElements.loginButton.click();
        logs.info("Navigating to login page");
    }

    @AfterSuite
    public void terminateSession() {
        driver.close();

        //Clear memory
        driver = null;
        logs.info("==================== END OF SUITE ====================");
    }

}
