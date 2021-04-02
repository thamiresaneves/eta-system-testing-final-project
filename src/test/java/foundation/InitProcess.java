package foundation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class InitProcess {
    public static WebDriver createBrowser() {
        String airBnbUrl = "https://www.airbnb.com.br";
        System.setProperty("webdriver.chrome.driver", "/home/dereck/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(airBnbUrl);
        return driver;
    }
}