package yelp_camp_test;

import PageObjects.LandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;


public class LandingPageTest extends Base {

    public static Logger logs = LogManager.getLogger(Base.class.getName());

    LandingPage landingPageElements;

    @BeforeSuite
    public void initBrowser() throws IOException {
        driver = initializeDriver();
        landingPageElements = PageFactory.initElements(driver, LandingPage.class);
        logs.info("Driver is initialized");
    }

    @Test(priority = 0)
    public void rootPageNavigation() {
        driver.get(rootURL);

        //Assertions
        Assert.assertTrue(landingPageElements.getLandingPageTitle().contains("YelpCamp"));
        Assert.assertEquals(landingPageElements.getSlideshowSize(), 5);
        logs.info("Successfully navigated to landing page");
    }

    @Test(priority = 1)
    public void goToCampgrounds() {
        Assert.assertTrue(landingPageElements.viewCampgroundsButton.isDisplayed());
        landingPageElements.viewCampgroundsButton.click();
        logs.info("Navigation to /campgrounds");
    }

    @AfterSuite
    public void terminateSession() {
        driver.close();

        //Clear memory
        driver = null;
        logs.info("==================== END OF SUITE ====================");
    }

}