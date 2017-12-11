package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewCampground {

    public WebDriver driver;

    @FindBy(how = How.NAME, using = "name")
    public WebElement campNameInput;

    @FindBy(how = How.NAME, using = "price")
    public WebElement campPriceInput;

    @FindBy(how = How.NAME, using = "location")
    public WebElement campLocationInput;

    @FindBy(how = How.NAME, using = "image")
    public WebElement campImageInput;

    @FindBy(how = How.TAG_NAME, using = "textarea")
    public WebElement campDescriptionInput;

    @FindBy(how = How.CSS, using = "body > div:nth-child(3) > div > div > form > div:nth-child(9) > button")
    public WebElement submitCampButton;

    @FindBy(how = How.TAG_NAME, using = "form")
    public WebElement campForm;

    public String submitButtonText() {
        return submitCampButton.getText();
    }

    //Constructor for WebDriver
    public NewCampground(WebDriver driver) {
        this.driver = driver;
    }
}
