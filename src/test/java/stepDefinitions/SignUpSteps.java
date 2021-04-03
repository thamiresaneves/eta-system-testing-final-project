
package stepDefinitions;

import foundation.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AirbnbHome;
import pages.AirbnbHost;

public class SignUpSteps {

    private AirbnbHome airbnbHome = new AirbnbHome(DriverManager.getDriver());
    private AirbnbHost airbnbHost;

    @Given("The user is be a host page")
    public void mainNavMenuDisplayed() {

       airbnbHost = airbnbHome.clickOnBecomeHostBtn();

    }

    @When("Clicks on Comece já button")
    public void clickOnComeceButton() {
        airbnbHost.getComeceJaButton().click();

    }
    @When("Clicks on Get started button")
    public void clicks_on_get_started_button() {
        System.out.println("balbla");
    }
    @When("Types a '' number")
    public void inputPhoneNumber() {
        airbnbHost.getPhoneField().sendKeys("");
    }
    @When("Clicks on Continue button")
    public void clicksOnContinueButton() {
        airbnbHost.getContinueButton().click();
    }

    @Then("The error message {string} should be displayed")
    public void assertTheErrorMessage(String errorMessage) {
        Assert.assertEquals(errorMessage, airbnbHost.getPhoneErrorMessage().getText());
    }

}
