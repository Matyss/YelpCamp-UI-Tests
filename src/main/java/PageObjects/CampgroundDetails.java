package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CampgroundDetails {

    //Driver declaration
    public WebDriver driver;

    //Page elements
    @FindBy(how = How.ID, using = "map")
    public WebElement googleMap;

    @FindBy(how = How.CLASS_NAME, using = "img-responsive")
    public WebElement image;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div[2]/div[1]/div/h4[2]/a")
    public WebElement title;

    @FindBy(how = How.XPATH, using = "//div[@class='caption-full']/p")
    public WebElement description;

    @FindBy(how = How.CSS, using = "body > div:nth-child(3) > div > div.col-md-9 > div.thumbnail > div > h4.pull-right")
    public WebElement price;

    @FindBy(how = How.TAG_NAME, using = "em")
    public WebElement author;

    //Constructor for driver
    public CampgroundDetails(WebDriver driver) {
        this.driver = driver;
    }
}
