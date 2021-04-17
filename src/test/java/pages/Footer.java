package pages;

import foundation.BasePage;
import helpers.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Footer extends BasePage{

    public Footer(WebDriver driver) {
        super(driver);
    }

    public WebElement getCurrencyInfo() {
        return driver.findElement(By.cssSelector(Constants.FOOTER_CURRENCY_INFO));
    }


    public void scrollToFooter() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }


}
