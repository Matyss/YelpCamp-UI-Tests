package resources;

//Selenium imports
import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

//Utilities
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public String rootURL;

    //Info method to print browser name
    public void chosenBrowser(String browserName) {
        System.out.println("Initializing " + browserName);
    }

    //Main init class to define driver config
    public WebDriver initializeDriver() throws IOException{

        //Create object for browser file configuration
        Properties props = new Properties();
        FileInputStream fileInput = new FileInputStream("C:\\Users\\m_szymajda\\IdeaProjects\\YelpCamp\\src\\main\\java\\resources\\configurationFile.properties");

        props.load(fileInput);
        String browserName = props
                .getProperty("browser")
                .toLowerCase();

        //Passing to public rootURL of website
        rootURL = props.getProperty("rootUrl");


        //Check for browser configuration file input
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Testing\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
                chosenBrowser(browserName);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Testing\\geckodriver-v0.19.1-win64\\geckodriver.exe");
                driver = new FirefoxDriver();
                chosenBrowser(browserName);
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", "C:\\Testing\\IEDriverServer_x64_3.7.0\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                chosenBrowser(browserName);
                break;
            default:
                System.out.println("Browser " + browserName + " is invalid, launching Chrome browser as default choice...");
                System.setProperty("webdriver.chrome.driver", "C:\\Testing\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
        }

        //Setup custom implicit wait for test methods
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Clear cookies and maximize window
        driver.manage().deleteAllCookies();
        System.out.println("All cookies deleted");
        driver.manage().window().maximize();
        System.out.println("Maximizing window");

        return driver;
    }

    public void takeScreenshots(String resultMethod, long endMillis) throws IOException {
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(source, new File("C://Users//m_szymajda//IdeaProjects//YelpCamp//"+resultMethod+"_"+endMillis+"_failScreen.png"));
    }

}