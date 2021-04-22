package stepDefinitions;

import commons.Methods;
import foundation.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;

public class SearchSteps {

    private Home home = new Home(DriverManager.getDriver());
    private Header header = new Header(DriverManager.getDriver());
    private Footer footer = new Footer(DriverManager.getDriver());
    private ExperiencesResults experiencesResults = new ExperiencesResults(DriverManager.getDriver());
    private OnlineExperiencesResults onlineExperiencesResults = new OnlineExperiencesResults(DriverManager.getDriver());


    @Given("the search panel is being displayed")
    public void searchPanelDisplayed() {
        Assert.assertTrue(home.getSearchField().isDisplayed());
    }

    @When("fills the search field with {string}")
    public void fillsSearchField(String location) throws InterruptedException {
        Methods.fillIn(home.getSearchField(), location);
    }

    @When("clicks on search button")
    public void clickOnSearchButton() throws InterruptedException {
        Methods.click(home.getSearchButton());
    }

    @Then("a list with {int} accommodations should be displayed per page")
    public void displayLocation(int accommodations) {
        Assert.assertEquals(accommodations, home.getLocationsList().size());
    }

    @When("the user clicks on guest option")
    public void clicksOnGuestOption() throws InterruptedException {
        Methods.click(home.getFieldGuestButton());
    }

    @When("adds a baby")
    public void addBaby() throws InterruptedException {
        Methods.click(home.getSteeper("infants-increase"));
    }

    @Then("the adults should be incremented without allowing to remove it")
    public void incrementAdults() throws InterruptedException {
        Methods.click(home.getSteeper("adults-decrease"));
        Assert.assertEquals("1", home.getSteeperValue("adults-value").getText());
    }

    @Then("removes a baby and an adult")
    public void removeBabyAndAdult() throws InterruptedException {
        Methods.click(home.getSteeper("adults-decrease"));
        Methods.click(home.getSteeper("infants-decrease"));
    }

    @Then("adds a child")
    public void addChild() throws InterruptedException {
        Methods.click(home.getSteeper("children-increase"));
    }

    @When("clicks on price button")
    public void clicksOnPriceButton() throws InterruptedException {
        Methods.click(home.getPriceButton());
    }

    @When("fills max price field with {int}")
    public void fillsMaxPriceField(int price) {
        home.fillPriceField(price);
    }

    @When("the clear button should be disabled")
    public void clearButtonDisabled() {
        Assert.assertFalse(home.getClearButton().isEnabled());
    }

    @When("clicks on the check in option")
    public void clicksOnDateOption() throws InterruptedException {
        Methods.click(home.getCheckInButton());
    }

    @When("clicks on 'I am flexible' button")
    public void clicksOnFlexibleOptionButton() throws InterruptedException {
        Methods.click(home.getFlexibleOption());
    }

    @When("selects more than one month")
    public void selectMonths() throws InterruptedException {
        Methods.click(home.getMonthByIndex(0));
        Methods.click(home.getMonthByIndex(2));
    }

    @Then("all months selected should be displayed")
    public void selectedMonthsDisplayed() {
      Assert.assertTrue(home.getMonthsMessage().contains(home.getMonthName(0)));
      Assert.assertTrue(home.getMonthsMessage().contains(home.getMonthName(2)));
    }

    @When("clicks on more filters button")
    public void clicksOnMoreFiltersButton() throws InterruptedException {
       Methods.click( home.getMoreFiltersButton());
    }

    @When("adds a beds")
    public void addsABed() throws InterruptedException {
        Methods.click(home.getFiltersOption("beds"));
    }

    @When("adds a bathrooms")
    public void addsABathroom() throws InterruptedException {
        Methods.click(home.getFiltersOption("bathrooms"));
    }

    @When("clicks on clear all button")
    public void clicksOnClearAllButton() throws InterruptedException {
        Methods.click(home.getClearAllButton());
    }

    @Then("all filters applied should be cleared")
    public void emptyFilters() {
        Assert.assertEquals("0", home.getFiltersOptionsCleared("beds").getText());
        Assert.assertEquals("0", home.getFiltersOptionsCleared("bathrooms").getText());
    }

    @When("clicks on experiences")
    public void clicksOnExperiences() throws InterruptedException  {
        Methods.click(header.getSearchExperiencesButton());
    }

    @When("changes the currency")
    public void changesCurrency() throws InterruptedException {
        Methods.click(header.getLanguageAndCurrencyButton());
        Methods.click(header.getCurrencyButton());
        Methods.click(header.getCurrencyEuroButton());
    }

    @Then("the currency should be updated for the experiences prices and on the page footer")
    public void currencyUpdated() throws InterruptedException {
        Assert.assertTrue(experiencesResults.getPlacesCurrencyValue().size() > 0);
        footer.scrollToFooter();
        Assert.assertEquals("EUR", footer.getCurrencyInfo().getText());
    }

    @Then("the {string} message should be displayed")
    public void noResultsMessageDisplayed(String message) {
        Assert.assertEquals(message, experiencesResults.getNoResultsMessage().getText());
    }

    @When("clicks on online experiences")
    public void clickOnOnlineExperiences() throws InterruptedException {
        Methods.click(home.getOnlineExperiencesButton());
    }

    @When("clicking on the first experience")
    public void clickOnFirstExperience() throws InterruptedException {
        Methods.click(onlineExperiencesResults.getOnlineExperiencesList().get(0));
    }

    @When("clicking on save button")
    public void clickOnSave() throws InterruptedException {
        onlineExperiencesResults.clickOnSaveButton();
    }

    @Then("the login panel should be displayed")
    public void loginPanelDisplayed() {
        Assert.assertTrue(onlineExperiencesResults.getLoginPanel().isDisplayed());
    }
}
