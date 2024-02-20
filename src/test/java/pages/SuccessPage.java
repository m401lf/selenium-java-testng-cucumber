package pages;

import base.BasePage;
import helper.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.utils.GlobalVars;

import java.io.IOException;

public class SuccessPage extends BasePage {
    WebDriver driver;
    AccountPage accountPage;

    private static Logger log = LogManager.getLogger(SuccessPage.class);

    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement pageHeading;

    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement accountSuccessPageHeading;
    @FindBy(xpath = "//p[contains(text(),'Congratulations! Your new account has been success')]")
    private WebElement congratulationsMsg;
    @FindBy(css = "div[id='content'] h1")
    private WebElement accountSuccessfullyCreatedMsg;
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    private WebElement msgConfirmation;
    @FindBy(css = "a.btn.btn-primary") // logoutPage, loginPage, accoutSuccessPage
    private WebElement continueBtn;


    public SuccessPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getYourAccountHasBeenCreatedHeadingTxt() {
        return new VerificationHelper(driver).getText(accountSuccessfullyCreatedMsg);
    }

    public boolean assertYourAccountHasBeenCreatedHeadingTxtDisplayed()
            throws InterruptedException {
        Thread.sleep(4000);
        return new VerificationHelper(driver).isDisplayed(accountSuccessfullyCreatedMsg);
    }

    public boolean assertCongratulationsAccountSuccessfullyCreatedMsgDisplayed() {
        return new VerificationHelper(driver).isDisplayed(congratulationsMsg);
    }

    public String getCongratulationsAccountSuccessfullyCreatedMsg() {
        return new VerificationHelper(driver).getText(congratulationsMsg);
    }

    public String getConfirmationMsg() {
        try {
            return (msgConfirmation.getText());
        } catch (Exception e) {
            return (e.getMessage());

        }

    }

    public String getAccountSuccessPageHeading() {
        return getPageHeaderText();

    }

    public boolean assertContinueButtonIsEnabledAndDisplayed() {
        return new VerificationHelper(driver).assertElementEnabledAndDisplayed(continueBtn);
    }

    public String getPageHeading() {
        return getTextFromElement(pageHeading, GlobalVars.EXPLICIT_WAIT_BASIC_TIME);
    }
}
