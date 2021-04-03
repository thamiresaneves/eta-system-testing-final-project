package stepDefinitions;

import foundation.InitProcess;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.AirbnbHome;

public class SearchSteps {
    private WebDriver driver;
    private AirbnbHome airbnbHome;
    private InitProcess initProcess;


    @Before
    public void setup() {
        initProcess = new InitProcess();
        driver = initProcess.getDriver();
        airbnbHome = new AirbnbHome(driver);
    }


    @Given("The user is in airbnb home page")
    public void airbnbHome() {
        initProcess.createBrowser();
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