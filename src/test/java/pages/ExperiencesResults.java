package pages;

import foundation.BasePage;
import helpers.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ExperiencesResults extends BasePage {

    public ExperiencesResults(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getPlacesCurrencyValue() {
        return driver.findElements(By.cssSelector(Constants.PLACES_CURRENCY_VALUE));
    }

    public WebElement getNoResultsMessage() {
        return driver.findElement(By.cssSelector(Constants.NO_RESULTS_MESSAGE));
    }
}
