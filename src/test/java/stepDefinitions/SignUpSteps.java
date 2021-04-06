
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

    @Given("the user is on the be a host page")
    public void mainNavMenuDisplayed() {
        airbnbHost = airbnbHome.clickOnBecomeHostBtn();
    }

    @When("he clicks on 'Get started' button")
    public void clickOnGetStartedButton() {
        airbnbHost.getComeceJaButton().click();

    }

    @When("types a {string} number")
    public void inputPhoneNumber(String phoneNumber) {
        airbnbHost.getPhoneField().sendKeys(phoneNumber);
    }

    @When("clicks on 'Continue' button")
    public void clicksOnContinueButton() {
        airbnbHost.getContinueButton().click();
    }

    @Then("The an {string} should be displayed")
    public void assertTheErrorMessage(String errorMessage) {
        Assert.assertEquals(errorMessage, airbnbHost.getPhoneErrorMessage().getText());
    }

}
