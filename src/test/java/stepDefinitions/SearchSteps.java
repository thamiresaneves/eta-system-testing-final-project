package stepDefinitions;

import foundation.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AirbnbHome;

public class SearchSteps {

    private AirbnbHome airbnbHome = new AirbnbHome(DriverManager.getDriver());


    @Given("The search panel is being displayed")
    public void searchPanelDisplayed() {
        Assert.assertTrue(airbnbHome.getSearchField().isDisplayed());
    }

    @When("Fills the search field with {string}")
    public void fillsSearchField(String location) throws InterruptedException {
        Thread.sleep(1000);
        airbnbHome.getSearchField().sendKeys(location);
    }

    @When("Clicks on button")
    public void clicksOnBtn() {
        airbnbHome.getSearchButton().click();
    }

    @Then("A list with {int} accommodations should be displayed per page")
    public void displayLocation(int accomodations) {
        Assert.assertEquals(accomodations, airbnbHome.getLocationsList().size());
    }

}