package test.technical.sdet.com.pages.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HomePageObject {
    private WebDriver driver;

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
    @FindBy(css = ".btn.betbutton.oddsbutton")
    private WebElement betButtonElement;
    @FindBy(css = ".betslip-selection__event")
    private WebElement betSlipEventElement;
    @FindBy(css = ".betslip-selection__stake-input")
    private WebElement betSlipStakeInputElement;
    @FindBy(css = "#total-to-return-price")
    private WebElement totalReturnPriceElement;
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


    WebDriverWait wait;

    // variables
    private static final int WAIT_TIME = 15;
    double betAmount;
    double balanceBeforeBet;
    double balanceAfterBet;
    double toReturnValue;
    static DecimalFormat decimalFormat = new DecimalFormat("0.00");


    //Constructor
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void navigateTo() {
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
        wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.invisibilityOf(modalLoginElement));
    }

    public void navigateToTheFootballTab() {
        //click on the football tab
        categoryTabs.get(5).click();
        // wait until the loading overlay has finished
        wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlayElement));

    }

    public void navigateToTheTennisTab() {
        //click on the tennis tab
        categoryTabs.get(6).click();
        // wait until the loading overlay has finished
        wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlayElement));
    }

    public void placeBet(double bet) {
        // format the bet amount
        decimalFormat.format(betAmount = bet);
        //wait until the loading Overlay has finished
        wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlayElement));
        // click on the first active bet
        betButtonElement.click();
        //wait until the bet slip event opens
        wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOf(betSlipEventElement));
        // enter the bet ammount that was entered in the scenario
        betSlipStakeInputElement.sendKeys(String.valueOf(bet));

        //logic to check whether the toReturn value from the UI matches with the one from the math formula
        // first we check if the bet is one with fractional odd
        if (betSlipSelectionPriceElement.getText().contains("/")) {
           // the fractional odd formula is: ((bet / denominator) x numerator ) + bet are the same
            toReturnValue = Double.parseDouble(decimalFormat.format((bet / Double.parseDouble(betSlipSelectionPriceElement.getText().substring(2))) * Double.parseDouble(betSlipSelectionPriceElement.getText().substring(0, 1)) + bet));
            decimalFormat.format(toReturnValue);
            // check that the to Return value from the UI matches the fractional odd formula
            double toReturnValueFromUI = Double.parseDouble(totalReturnPriceElement.getText());
             assertEquals(toReturnValue,toReturnValueFromUI, 0D);
             // if it's with decimal odd them check with this formula
        } else {
            //check that toReturnValueElement is same as stake * odds
            assertEquals(totalReturnPriceElement.getText(), decimalFormat.format(Double.parseDouble(totalReturnPriceElement.getText()) * bet));
        }
        // get the balance from the account tab leaving the currency out
        balanceBeforeBet = Double.parseDouble(accountTab.getText().substring(1));
        // place the bet
        placeButtonElement.click();

    }

    public void checkBalance() {
        // wait until the bet place button is displayed
        wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOf(betPlacedButtonElement));
        // get the balance from the account tab without the currency
        balanceAfterBet = Double.parseDouble(accountTab.getText().substring(1));
        // add the balanceAfterBet with the betAmount
        balanceAfterBet = Double.parseDouble(decimalFormat.format(balanceAfterBet + betAmount));
        //check that the balance is updated correctly
        assertEquals(balanceBeforeBet, balanceAfterBet, 0D);
    }

}