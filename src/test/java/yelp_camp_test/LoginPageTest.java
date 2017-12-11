package yelp_camp_test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.Base;


public class LoginPageTest extends Base{

    public static Logger logs = LogManager.getLogger(Base.class.getName());

    LandingPage landingPageElements;
    LoginPage loginPageElements;

    @BeforeClass
    public void initElements() {
        landingPageElements = PageFactory.initElements(driver, LandingPage.class);
        loginPageElements = PageFactory.initElements(driver, LoginPage.class);
    }


    @Test
    public void checkNavigation() {
        Assert.assertTrue(landingPageElements.navbar.isDisplayed());
        Assert.assertTrue(landingPageElements.footer.isDisplayed());
        logs.info("Navbar and footer are present");
    }

    @Test(dataProvider = "loginData")
    public void userLogin(String userName, String password) {
        Assert.assertTrue(loginPageElements.userNameInput.isDisplayed());
        loginPageElements.userNameInput.sendKeys(userName);
        logs.info("Provided user login");
    }

    @Test(dataProvider = "loginData")
    public void userPass(String userName, String password) {
        Assert.assertTrue(loginPageElements.passwordInput.isDisplayed());
        loginPageElements.passwordInput.sendKeys(password);
        logs.info("Provided user password");
    }

    @Test
    public void clickLoginButton() {
        Assert.assertTrue(loginPageElements.loginSubmit.isDisplayed());
        loginPageElements.loginSubmit.click();
        logs.info("Clicking on login button");
    }

    @Test
    public void checkRouteChange() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://morning-wildwood-15402.herokuapp.com/campgrounds");
        logs.info("Correctly redirected to main page");
    }

    @Test
    public void checkAlertDisplay() {
        Assert.assertTrue(landingPageElements.alert.isDisplayed());
        Assert.assertEquals(landingPageElements.getAlertText(), "Welcome!");
        logs.info("Login alert on main page is displayed");
    }

    @DataProvider
    public Object[][] loginData() {

        Object[][] data = new Object[1][2];

        data[0][0] = "admin";
        data[0][1] = "admin";

        return data;
    }

}
