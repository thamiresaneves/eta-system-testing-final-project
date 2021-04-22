package commons;

import foundation.BasePage;
import helpers.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Methods extends BasePage {

    public Methods(WebDriver driver) {
        super(driver);
    }

    public static void click(WebElement element) throws InterruptedException {
        Thread.sleep(Constants.THREE_SECONDS);
        element.click();
    }

    public static void fillIn(WebElement element, String text) throws InterruptedException {
        Thread.sleep(Constants.ONE_SECOND);
        element.sendKeys(text);
    }
}
