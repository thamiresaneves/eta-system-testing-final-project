package stepDefinitions;

import foundation.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setup(){
        WebDriver driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get("https://www.airbnb.com.br/");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        DriverManager.endSession();
    }
}
