package pages;

import foundation.BasePage;
import helpers.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Host extends BasePage {
    public Host(WebDriver driver) {
        super(driver);
    }

    public WebElement getComeceJaButton() {
        return driver.findElement(By.cssSelector(Constants.GET_STARTED_BUTTON));
    }
    public WebElement getPhoneField() {
        return driver.findElement(By.cssSelector(Constants.PHONE_NUMBER_FIELD));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.cssSelector(Constants.CONTINUE_BUTTON));
    }

    public WebElement getPhoneErrorMessage() {
        return driver.findElement(By.cssSelector(Constants.PHONE_ERROR_MESSAGE));
    }

}
