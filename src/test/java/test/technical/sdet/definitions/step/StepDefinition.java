package test.technical.sdet.definitions.step;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.technical.sdet.com.pages.test.HomePageObject;

import java.util.concurrent.TimeUnit;

/**
 * Created by Gabi on 6/28/2017.
 */
public class StepDefinition {

    WebDriver driver;

    HomePageObject homePageObject;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("^that I am on the sportsbook homepage$")
    public void that_I_am_on_the_sportsbook_homepage() throws Throwable {
        homePageObject = new HomePageObject(driver);
        homePageObject.navigateTo();

    }

    @When("^I log in$")
    public void i_log_in() throws Throwable {
        homePageObject.login();
    }

    @When("^navigate to the Football event$")
    public void navigate_to_Football_event() throws Throwable {
        homePageObject.navigateToTheFootballTab();

    }

    @When("^navigate to the Tennis event$")
    public void navigate_to_the_Tennis_event() throws Throwable {
        homePageObject.navigateToTheTennisTab();
    }

    @When("^place a \\\"([^\\\"]*)\\\" bet$")
    public void place_a_bet(double arg1) throws Throwable {
        homePageObject.placeBet(arg1);
    }

    @Then("^the bet should be successfully placed and the balance updated$")
    public void the_bet_should_be_successfully_placed_and_the_balance_updated() throws Throwable {
        homePageObject.checkBalance();
    }

}
