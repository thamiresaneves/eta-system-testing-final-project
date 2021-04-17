package stepDefinitions;

import foundation.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AirbnbHome;

public class SearchSteps {

    private AirbnbHome airbnbHome = new AirbnbHome(DriverManager.getDriver());


    @Given("the search panel is being displayed")
    public void searchPanelDisplayed() {
        Assert.assertTrue(airbnbHome.getSearchField().isDisplayed());
    }

    @When("fills the search field with {string}")
    public void fillsSearchField(String location) throws InterruptedException {
        Thread.sleep(1000);
        airbnbHome.getSearchField().sendKeys(location);
    }

    @When("clicks on search button")
    public void clicksOnBtn() {
        airbnbHome.getSearchButton().click();
    }

    @Then("a list with {int} accommodations should be displayed per page")
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

    @When("clicks on price button")
    public void clicksOnPriceButton() throws InterruptedException {
        Thread.sleep(3000);
       airbnbHome.getPriceButton().click();
    }

    @When("fills max price field with {int}")
    public void fillsMaxPriceField(int price) {
        airbnbHome.fillPriceField(price);
    }

    @When("the clear button should be disabled")
    public void clearButtonDisabled() {
        Assert.assertFalse(airbnbHome.getClearButton().isEnabled());
    }

    @When("clicks on the check in option")
    public void clicksOnDateOption() {
        airbnbHome.getCheckInButton().click();
    }

    @When("clicks on 'I am flexible' button")
    public void clicksOnFlexibleOptionButton() {
        airbnbHome.getFlexibleOption().click();
    }

    @When("selects more than one month")
    public void selectMonths() {
        airbnbHome.getMonthByIndex(0).click();
        airbnbHome.getMonthByIndex(2).click();
    }

    @Then("all months selected should be displayed")
    public void selectedMonthsDisplayed() {
      Assert.assertTrue(airbnbHome.getMonthsMessage().contains(airbnbHome.getMonthName(0)));
      Assert.assertTrue(airbnbHome.getMonthsMessage().contains(airbnbHome.getMonthName(2)));
    }

    @When("clicks on more filters button")
    public void clicksOnMoreFiltersButton() {
       airbnbHome.getMoreFiltersButton().click();
    }

    @When("adds a beds")
    public void addsABeds() {
        airbnbHome.getFiltersOption("beds").click();
    }

    @When("adds a bathrooms")
    public void addsABathrooms() {
        airbnbHome.getFiltersOption("bathrooms").click();
    }

    @When("clicks on clear all button")
    public void clicksOnClearAllButton() {
        airbnbHome.getClearAllButton().click();
    }

    @Then("all filters applied should be cleared")
    public void emptyFilters() {
        Assert.assertEquals("0", airbnbHome.getFiltersOptionsCleared("beds").getText());
        Assert.assertEquals("0", airbnbHome.getFiltersOptionsCleared("bathrooms").getText());
    }
}