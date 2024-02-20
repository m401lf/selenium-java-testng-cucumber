package pages;

import base.BasePage;
import helper.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ForgottenPasswordPage extends BasePage {

    private final Logger log = LogManager.getLogger(ForgottenPasswordPage.class);
    WebDriver driver;
    LoginPage loginPage;
    @FindBy(id = "forgottenFrm_email")
    WebElement emailTxtField;
    @FindBy(id = "forgottenFrm_loginname")
    WebElement forgottenFrmLoginname;
    @FindBy(css = "a[title='Back']")
    WebElement backButton;
    @FindBy(css = ".maintext")
    WebElement heading;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div/form/h4")
    WebElement hintHeading;
    @FindBy(css = "button[title='Continue'] > .fa.fa-check")
    WebElement continueButton;

    public ForgottenPasswordPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHintHeadingText() {
        return new VerificationHelper(driver).getText(hintHeading);

    }

    public boolean isHeadingDisplayed() {
        return new VerificationHelper(driver).isDisplayed(heading);

    }

    public boolean isHintHeadingDisplayed() {
        return new VerificationHelper(driver).isDisplayed(hintHeading);

    }

    public String getContinueButtonTxt() {
        return new VerificationHelper(driver).getText(continueButton);

    }

    public void clickOnBackButton() {
        waitAndClick(backButton);

    }

    public boolean isContinueButtonDisplayed() {
        return new VerificationHelper(driver).isDisplayed(continueButton);

    }

    public void enterEmail(String email) {
        waitAndSendKeys(emailTxtField, email);

    }

    public void enterLoginname(String loginname) {
        waitAndSendKeys(forgottenFrmLoginname, loginname);

    }

    public LoginPage clicksOnContinueButton() throws IOException {
        waitAndClick(continueButton);
        loginPage = new LoginPage(driver);
        return loginPage;
    }


}
