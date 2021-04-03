package pages;

import foundation.BasePage;
import helpers.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AirbnbHome extends BasePage {
    public AirbnbHome(WebDriver driver){
        super(driver);
    }

    public WebElement getSearchField(){
        return driver.findElement(By.cssSelector(Constants.SEARCH_FIELD));
    }

    public WebElement getSearchButton(){
        return driver.findElement(By.cssSelector(Constants.SEARCH_BUTTON));
    }

    public WebElement getBeAHost(){
        return driver.findElement(By.cssSelector(Constants.BE_A_HOST));
    }

    public List<WebElement> getLocationsList(){
        return driver.findElements(By.cssSelector(Constants.LOCATIONS_LIST));
    }
}
