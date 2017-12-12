package yelp_camp_test;

import PageObjects.LandingPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;

public class SandboxTesting extends Base {

    LandingPage landingPageElements;

    @BeforeClass
    public void initBrowser() throws IOException {
        driver = initializeDriver();
        landingPageElements = PageFactory.initElements(driver, LandingPage.class);
    }

    @Test(priority = 0)
    public void config() {
        driver.get(rootURL);
        landingPageElements.viewCampgroundsButton.click();
    }

    @Test
    public void someTest() {
        Assert.assertTrue(landingPageElements.getCampground("New Test"));
    }
}
