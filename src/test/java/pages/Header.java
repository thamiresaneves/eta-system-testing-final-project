package pages;

import foundation.BasePage;
import helpers.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header extends BasePage{

    public Header(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchExperiencesButton() {
        return driver.findElement(By.cssSelector(Constants.SEARCH_EXPERIENCES_BUTTON));
    }

    public WebElement getLanguageAndCurrencyButton() throws InterruptedException {
        Thread.sleep(Constants.ONE_SECOND);
        return driver.findElement(By.cssSelector(Constants.LANGUAGE_AND_CURRENCY_BUTTON));
    }

    public WebElement getCurrencyButton() throws InterruptedException {
        Thread.sleep(Constants.ONE_SECOND);
        return driver.findElement(By.cssSelector(Constants.CURRENCY_BUTTON));
    }

    public WebElement getCurrencyEuroButton() throws InterruptedException {
        Thread.sleep(Constants.ONE_SECOND);
        return driver.findElement(By.xpath(Constants.CURRENCY_EURO_BUTTON));
    }
}
