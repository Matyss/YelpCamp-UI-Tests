package yelp_camp_test;

import PageObjects.LandingPage;
import PageObjects.NewCampground;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.Base;

public class NewCampgroundTest extends Base{

    public static Logger logs = LogManager.getLogger(Base.class.getName());

    LandingPage landingPageElements;
    NewCampground newCampgroundPageElements;


    @BeforeClass
    public void initElements() {
        landingPageElements = PageFactory.initElements(driver, LandingPage.class);
        newCampgroundPageElements = PageFactory.initElements(driver, NewCampground.class);
    }

    @Test
    public void addNewCampground() {
        Assert.assertTrue(landingPageElements.addCampgroundButton.isDisplayed());
        landingPageElements.addCampgroundButton.click();
        logs.info("Navigating to /new");
    }

    @Test(dataProvider = "newCampData")
    public void completeForm(String name, Integer price, String loc, String url, String desc) {
        Assert.assertTrue(newCampgroundPageElements.campForm.isDisplayed());
        Assert.assertTrue(newCampgroundPageElements.submitButtonText().contains("Submit!"));
        newCampgroundPageElements.campNameInput.sendKeys(name);
        newCampgroundPageElements.campPriceInput.sendKeys(String.valueOf(price));
        newCampgroundPageElements.campLocationInput.sendKeys(loc);
        newCampgroundPageElements.campImageInput.sendKeys(url);
        newCampgroundPageElements.campDescriptionInput.sendKeys(desc);

        newCampgroundPageElements.submitCampButton.click();
        logs.info("Added new test campground");
    }

    @DataProvider
    public Object[][] newCampData() {

        Object[][] data = new Object[1][5];

        data[0][0] = "Camp Test";
        data[0][1] = 25;
        data[0][2] = "Mackinac National Park, MI";
        data[0][3] = "https://www.nationalparks.org/sites/default/files/styles/large_list_image_2x/public/shutterstock_142351951.jpg?itok=Jr0mv7SL&timestamp=1474998760";
        data[0][4] = "Mackinac National Park was a United States National Park that existed from 1875 to 1895 on Mackinac Island in northern Michigan making it the second American National Park after Yellowstone National Park in the Rocky Mountains.";

        return data;
    }

}
