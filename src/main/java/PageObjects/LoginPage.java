package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    //Driver declaration
    public WebDriver driver;

    @FindBy(how = How.NAME, using = "username")
    public WebElement userNameInput;

    @FindBy(how = How.NAME, using = "password")
    public WebElement passwordInput;

    @FindBy(how = How.CSS, using = "body > div:nth-child(3) > div.row.card-form > form > div:nth-child(3) > button")
    public WebElement loginSubmit;

    @FindBy(how = How.CSS, using = "body > div:nth-child(3) > div.row.card-form > h1")
    public WebElement loginInput;

    //Constructor for driver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

}
