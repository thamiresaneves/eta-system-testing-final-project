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

    @When("the user clicks on guest option")
    public void clicksOnGuestOption() {
        airbnbHome.getFieldGuestButton().click();
    }

    @When("adds a baby")
    public void the_user_adds_a_baby_in_the_guests_option() {
        airbnbHome.getSteeper("infants-increase").click();
    }

    @Then("the Adults should be incremented without allowing to remove it")
    public void the_adults_should_be_incremented_without_allowing_to_remove_it() {
        airbnbHome.getSteeper("adults-decrease").click();
        Assert.assertEquals("1", airbnbHome.getSteeperValue("adults-value").getText());

    }

    @Then("removes a baby and an adult")
    public void removes_a_baby_and_an_adult() {
        airbnbHome.getSteeper("adults-decrease").click();
        airbnbHome.getSteeper("infants-decrease").click();
    }

    @Then("adds a child")
    public void adds_a_child() {
        airbnbHome.getSteeper("children-increase").click();
    }

    @Then("the adults should be incremented without allowing to remove the adult")
    public void the_adults_should_be_incremented_without_allowing_to_remove_the_adult() {
        airbnbHome.getSteeper("adults-decrease").click();
        Assert.assertEquals("1", airbnbHome.getSteeperValue("adults-value").getText());
    }

}