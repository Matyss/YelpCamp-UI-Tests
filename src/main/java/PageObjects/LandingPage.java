package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class LandingPage {

    //Driver declaration
    public WebDriver driver;

    //Page elements
    @FindBy(how = How.CSS, using = "#landing-header > a")
    public WebElement viewCampgroundsButton;

    @FindBy(how = How.CSS, using = "body > ul")
    public  WebElement slideshowList;

    @FindBy(how = How.CSS, using = "#navbar > ul.nav.navbar-nav.navbar-right > li:nth-child(1) > a")
    public WebElement loginButton;

    @FindBy(how = How.CSS, using = "body > nav")
    public WebElement navbar;

    @FindBy(how = How.CSS, using = "body > footer")
    public WebElement footer;

    @FindBy(how = How.CSS, using = "body > div:nth-child(2) > div")
    public WebElement alert;

    @FindBy(how = How.CSS, using = "body > div:nth-child(3) > header > p:nth-child(3) > a")
    public WebElement addCampgroundButton;

    public WebElement campMoreInfo(String campName) {
        List<WebElement> camps = (List) driver.findElements(By.className("caption"));
        WebElement parentDiv = null;
        for(WebElement camp : camps) {
            if(camp.getText().contains(campName)) {
                parentDiv = camp.findElement(By.xpath("ancestor::node()[1]"));
            }
        }
        WebElement parentDivButton = parentDiv.findElement(By.tagName("a"));
        return parentDivButton;
    }

    public boolean isCampDisplayed(String campName) {
        List<WebElement> camps = (List) driver.findElements(By.className("caption"));

        for(WebElement camp : camps) {
            if(camp.getText().contains(campName)) return true;
        }
        return false;
    }

    public String getAlertText() {
        return alert.getText();
    }

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
