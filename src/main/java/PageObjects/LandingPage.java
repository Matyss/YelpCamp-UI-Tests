package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LandingPage {

    //Driver declaration
    public WebDriver driver;

    @FindBy(how = How.CSS, using = "#landing-header > a")
    public WebElement viewCampgroundsButton;

    @FindBy(how = How.CSS, using = "body > ul")
    public  WebElement slideshowList;

    public String getLandingPageTitle() {
        return driver.getTitle();
    }

    public int getSlideshowSize() {
        return slideshowList.findElements(By.tagName("li")).size();
    }

    //Constructor for driver
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }
}
