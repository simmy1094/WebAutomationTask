package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class Driver {

    protected static WebDriver driver;

    public static WebDriver initialize(String browser) {
        try {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--ignore-certificate-errors");
                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
                return driver;

            }
        }
        catch(Exception e){
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }
