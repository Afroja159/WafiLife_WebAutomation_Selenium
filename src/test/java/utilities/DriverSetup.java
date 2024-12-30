package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class DriverSetup {
    private static String browser_name = System.getProperty("browser", "Edge");
    private static final ThreadLocal<WebDriver> LOCAL_DRIVER = new ThreadLocal<>();

    public static void setDriver(WebDriver driver){
        DriverSetup.LOCAL_DRIVER.set(driver);
    }

    public static WebDriver getDriver(){
        return LOCAL_DRIVER.get();
    }

    @BeforeMethod
    public void openABrowser(){
        WebDriver driver = getBrowser(browser_name);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        setDriver(driver);
    }
    @AfterMethod
    public void closeBrowser(){
        // close browser
        getDriver().quit();
    }

    public WebDriver getBrowser(String browser_name){
        if (browser_name.equalsIgnoreCase("chrome"))
            return new ChromeDriver();
        else if (browser_name.equalsIgnoreCase("edge"))
            return new EdgeDriver();
        else {
            throw new RuntimeException("Browser is not currently available with the given name:" +browser_name);
        }
    }
}
