package foundation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class InitProcess {
    private WebDriver driver;

    public InitProcess(){
        System.setProperty("webdriver.chrome.driver", "/home/dereck/Documents/chromedriver");
        driver = new ChromeDriver();
    }

    public void createBrowser() {
        String airBnbUrl = "https://www.airbnb.com.br";
        this.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        this.driver.get(airBnbUrl);
    }

    public WebDriver getDriver(){
        return driver;
    }
}