package pages;

import foundation.BasePage;
import helpers.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import javax.print.DocFlavor;
import javax.sound.midi.Soundbank;
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

    public WebElement getCheckInButton(){
        return driver.findElement(By.cssSelector(Constants.CHECK_IN_DATE_BUTTON));
    }

    public WebElement getFlexibleOption(){
        return driver.findElement(By.cssSelector(Constants.FLEXIBLE_OPTION));
    }

    public WebElement getMonthByIndex(int monthIndex){
       return driver.findElements(By.cssSelector(Constants.MONTH_LIST)).get(monthIndex);
    }

    public String getMonthName(int monthIndex){
        return driver.findElements(By.cssSelector(Constants.MONTHS_SELECTED)).get(monthIndex).getText();
    }

    public String getMonthsMessage(){
        return driver.findElement(By.xpath(Constants.MONTHS_MESSAGE)).getText();
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

    public WebElement getPriceButton(){
        return driver.findElement(By.cssSelector(Constants.PRICE_BUTTON));
    }



    public void fillPriceField(int price){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "document.querySelector" + "(" + "'" + Constants.MAX_PRICE_FIELD + "'" + ").value = " + price;
        js.executeScript(script);
        driver.findElement(By.cssSelector("[data-testid=\"menuBarPanel-price_range\"]")).click();
    }

    public WebElement getClearButton(){
        return driver.findElement(By.cssSelector(Constants.CLEAR_BUTTON));
    }
}
