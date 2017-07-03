package test.technical.sdet.com.pages.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HomePageObject {
    private WebDriver driver;
    private WebDriverWait wait;

    //Page URL
    private static String PAGE_URL = "https://sports.williamhill.com/sr-admin-set-white-list-cookie.html";

    //Locators
    @FindBy(css = "#accountTabButton")
    private WebElement accountTab;
    @FindBy(css = "#loginButton")
    private WebElement loginButton;
    @FindBy(css = "#loginUsernameInput")
    private WebElement loginUsername;
    @FindBy(css = "#loginPasswordInput")
    private WebElement loginPassword;
    @FindBy(css = "#depositHeaderButtonLink")
    private WebElement depositHeaderButton;
    @FindBy(css = "#wh-global-overlay")
    private WebElement loadingOverlayElement;
    @FindBy(css = "#modalLogin")
    private WebElement modalLoginElement;
    @FindBy(css = ".c-list__item")
    private List<WebElement> categoryTabs;
    @FindBy(css = "button.btn.betbutton.oddsbutton")
    private WebElement betButtonElement;
    @FindBy(css = ".betslip-selection__event")
    private WebElement betSlipEventElement;
    @FindBy(css = ".betslip-selection__stake-input")
    private WebElement betSlipStakeInputElement;
    @FindBy(css = "#total-to-return-price")
    private WebElement toReturnPriceElement;
    @FindBy(css = "#total-stake-price")
    private WebElement totalStakePriceElement;
    @FindBy(css = ".betslip-selection__price")
    private WebElement betSlipSelectionPriceElement;
    @FindBy(css = "#place-bet-button")
    private WebElement placeButtonElement;
    @FindBy(css = "#receipt-notice-box")
    private WebElement betPlacedButtonElement;
    @FindBy(css = ".account-tab__text.-account")
    private WebElement balanceFromAccountTabElement;

    // variables
    private final int WAIT_TIME = 15;
    private double betAmount;
    private double balanceBeforeBet;
    private double balanceAfterBet;
    private double toReturnValue;
    private DecimalFormat decimalFormat = new DecimalFormat("#.00");


    //Constructor
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() {
        driver.get(PAGE_URL);
        assertEquals("Online Betting from William Hill - The Home of Betting", driver.getTitle());
    }

    public void login() {
        // wait for the loading overlay to finish
        wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlayElement));

        // click on the account tab to open the login tab
        accountTab.click();

        // enter credentials
        loginUsername.sendKeys("WHATA_FOG2");
        loginPassword.sendKeys("F0gUaTtest");

        // click on the login button and wait until the login is done
        loginButton.click();
        wait.until(ExpectedConditions.invisibilityOf(modalLoginElement));
    }

    public void navigateToTheFootballTab() {
        // wait until the loading overlay has finished
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlayElement));

        //click on the football tab
        categoryTabs.get(5).click();

        // wait until the loading overlay has finished
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlayElement));
    }

    public void navigateToTheTennisTab() {
        // wait until the loading overlay has finished
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlayElement));

        //click on the tennis tab
        categoryTabs.get(6).click();

        // wait until the loading overlay has finished
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlayElement));
    }

    public void placeBet(double bet) {
        // this will be used later
        betAmount = bet;

        //wait until the loading Overlay has finished and the bet button is visible
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlayElement));
        wait.until(ExpectedConditions.visibilityOf(betButtonElement));

        // click on the first active bet
        betButtonElement.click();

        //wait until the bet slip event opens
        wait.until(ExpectedConditions.visibilityOf(betSlipEventElement));

        // enter the bet amount that was entered in the scenario
        betSlipStakeInputElement.sendKeys(String.valueOf(bet));

        //logic to check whether the toReturn value from the UI matches with the one from the math formula
        // first we check if the bet is one with fractional odd
        if (betSlipSelectionPriceElement.getText().contains("/")) {
            // the fractional odd formula is: ((bet / denominator) x numerator ) + bet are the same
            toReturnValue = (bet / Double.parseDouble(betSlipSelectionPriceElement.getText().substring(betSlipSelectionPriceElement.getText().indexOf("/") + 1)))
                    * Double.parseDouble(betSlipSelectionPriceElement.getText().substring(0, betSlipSelectionPriceElement.getText().indexOf("/"))) + bet;

            // format the value so that it displays the value with 2 decimals e.g 0.05
            BigDecimal bigDecimal = new BigDecimal(toReturnValue);
            BigDecimal roundOff = bigDecimal.setScale(2, BigDecimal.ROUND_DOWN);
            toReturnValue = Double.parseDouble(String.valueOf(roundOff));

            // check that the to return value from the UI matches the fractional odd formula
            assertEquals("Return values are not correct", String.valueOf(toReturnValue), toReturnPriceElement.getText());
        } else {
            // if it's with decimal odd them check with this formula
            // format the value so that it displays the value with 2 decimals e.g 0.05
            BigDecimal bigDecimal = new BigDecimal(Double.parseDouble(betSlipSelectionPriceElement.getText()) * bet);
            BigDecimal toReturnValue = bigDecimal.setScale(2, BigDecimal.ROUND_DOWN);

            //check that toReturnValueElement is same as stake * odds
            assertEquals("Return values are not correct", String.valueOf(toReturnValue), toReturnPriceElement.getText());
        }
        // get the balance from the account tab without the currency
        balanceBeforeBet = Double.parseDouble(accountTab.getText().substring(1));
        // place the bet
        placeButtonElement.click();
        // wait until the bet place button is displayed
        wait.until(ExpectedConditions.visibilityOf(betPlacedButtonElement));
    }

    public void checkBalance() {
        // balanceAfterBet should be the balanceBeforeBet minus the betAmount
        balanceAfterBet = balanceBeforeBet - betAmount;
        //wait until the UI balance displays the correct amount
        wait.until(ExpectedConditions.textToBePresentInElement(balanceFromAccountTabElement, "£" + decimalFormat.format(balanceAfterBet)));
        //check that balance from the UI matches with balanceAfterBet
        assertEquals("Balance after is not correct", "£" + decimalFormat.format(balanceAfterBet), balanceFromAccountTabElement.getText());
    }

}