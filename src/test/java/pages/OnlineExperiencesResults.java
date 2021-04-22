package pages;

import foundation.BasePage;
import helpers.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

import static java.lang.Thread.sleep;

public class OnlineExperiencesResults extends BasePage {

    public OnlineExperiencesResults(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getOnlineExperiencesList() {
        return driver.findElements(By.cssSelector(Constants.ONLINE_EXPERIENCES_LIST));
    }

    public void clickOnSaveButton() throws InterruptedException {
        waitForNewWindowAndSwitchToIt(driver);
        driver.findElement(By.cssSelector(Constants.SAVE_ONLINE_EXPERIENCE_BUTTON)).click();
    }

    public WebElement getLoginPanel() {
        return driver.findElement(By.cssSelector(Constants.LOGIN_PANEL));
    }

    //Support Method
    public void waitForNewWindowAndSwitchToIt(WebDriver driver) throws InterruptedException {
        String cHandle = driver.getWindowHandle();
        String newWindowHandle = null;
        Set<String> allWindowHandles = driver.getWindowHandles();

        //Waits for 5 seconds for the new window and throw exception if not found.
        for (int i = 0; i < 5; i++) {
            if (allWindowHandles.size() > 1) {
                for (String allHandlers : allWindowHandles) {
                    if (!allHandlers.equals(cHandle))
                        newWindowHandle = allHandlers;
                }
                driver.switchTo().window(newWindowHandle);
                break;
            } else {
                sleep(Constants.TWO_SECONDS);
            }
        }
        if (cHandle == newWindowHandle) {
            throw new RuntimeException("Error: No window found");
        }
    }
}
