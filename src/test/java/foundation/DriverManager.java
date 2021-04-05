package foundation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "/home/dereck/Documents/chromedriver");

        if(driver == null){
            driver = new ChromeDriver();
        }

        return driver;
    }

    public static void endSession() {
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }


}