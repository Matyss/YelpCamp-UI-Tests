package yelp_camp_test;

import PageObjects.CampgroundDetails;
import PageObjects.LandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;

public class DeleteCampground extends Base {

    public static Logger logs = LogManager.getLogger(Base.class.getName());

    LandingPage landingPageElements;
    CampgroundDetails campgroundDetailsElements;

    @BeforeClass
    public void initElements() throws IOException {
        driver = initializeDriver();
        driver.get("https://morning-wildwood-15402.herokuapp.com/campgrounds");
        landingPageElements = PageFactory.initElements(driver, LandingPage.class);
        campgroundDetailsElements = PageFactory.initElements(driver, CampgroundDetails.class);
    }

    @Test(dataProvider = "campName")
    public void goToDetails(String campName) {
        Assert.assertTrue(landingPageElements.isCampDisplayed(campName));
        landingPageElements.campMoreInfo(campName).click();
        logs.info("Navigating to test camp details page");
    }

    @Test
    public void checkCampInfo() {
        NewCampgroundTest dataProviderObject = new NewCampgroundTest();

        //Check if actual description equals the one in DataProvider object from NewCampgroundTest class
        Assert.assertEquals(campgroundDetailsElements.description.getText(), dataProviderObject.newCampData()[0][4]);

        //Check if image link was pasted
        Assert.assertTrue(campgroundDetailsElements.image.getAttribute("src").contains("http"));
    }

    //Data provider for camp name we want to delete
    //optionally you can use the name from NewCampgroundTest DataProvider object
    @DataProvider
    public Object[][] campName() {

        Object[][] data = new Object[1][1];

        data[0][0] = "Camp Test";

        return data;
    }
}
