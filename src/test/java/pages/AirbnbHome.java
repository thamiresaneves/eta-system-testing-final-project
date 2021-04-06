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
    public AirbnbHome(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchField() {
        return driver.findElement(By.cssSelector(Constants.SEARCH_FIELD));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.cssSelector(Constants.SEARCH_BUTTON));
    }

    public WebElement getHomeMenuButton() {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Constants.HOME_MENU_BUTTON)));
        return element;

    }

    public AirbnbHost clickOnBecomeHostBtn() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Constants.BE_A_HOST_BUTTON)));
        element.click();
        return new AirbnbHost(driver);
    }

    public List<WebElement> getLocationsList() {
        return driver.findElements(By.cssSelector(Constants.LOCATIONS_LIST));
    }

    public WebElement getFieldGuestButton() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Constants.FIELD_GUESTS_BUTTON)));
        return element;
    }

    public WebElement getSteeper(String steeperType){
        String steeper = Constants.STEEPERS + "'" + steeperType + "'" + "]";
        return driver.findElement(By.cssSelector(steeper));
    }

    public WebElement getSteeperValue(String steeperType){
        String steeperValue = Constants.STEEPER_VALUE + "'" + steeperType + "'" + "]";
        return driver.findElement(By.cssSelector(steeperValue));
    }
}
