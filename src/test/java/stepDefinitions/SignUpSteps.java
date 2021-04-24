
package stepDefinitions;

import foundation.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Home;
import pages.Host;

public class SignUpSteps {

    private Home home = new Home(DriverManager.getDriver());
    private Host host;

    @Given("the user is on the be a host page")
    public void mainNavMenuDisplayed() {
        host = home.clickOnBecomeHostBtn();
    }

    @When("clicks on 'Get started' button")
    public void clickOnGetStartedButton() {
        host.getComeceJaButton().click();
    }

    @When("types a {string} number")
    public void inputPhoneNumber(String phoneNumber) {
        host.getPhoneField().sendKeys(phoneNumber);
    }

    @When("clicks on 'Continue' button")
    public void clicksOnContinueButton() {
        host.getContinueButton().click();
    }

    @Then("an {string} should be displayed")
    public void assertTheErrorMessage(String errorMessage) {
        Assert.assertEquals(errorMessage, host.getPhoneErrorMessage().getText());
    }

}
