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

public class LoginPage extends BasePage {
    private final Logger log = LogManager.getLogger(LoginPage.class);
    WebDriver driver;
    RegisterPage registerPage;
    AccountPage accountPage;
    @FindBy(css = "//a[normalize-space()='Edit your account information']")
    WebElement editAccountInformationLink;
    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
    private WebElement emailPasswordNotMatchingWarning;
    @FindBy(xpath = "///a[@innertext='Account']")
    private WebElement accountTxt;
    @FindBy(xpath = "//li[3]/a[@innertext='Login']")
    private WebElement loginTxt;
    @FindBy(css = ".alert.alert-success")
    private WebElement alertAlertSuccessMsg;
    @FindBy(id = "input-email")
    private WebElement email;
    @FindBy(id = "input-password")
    private WebElement password;
    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginBtn;
    @FindBy(linkText = "input[value='Continue']")
    private WebElement continueButton;
    // successful Login Variables declaration //
    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div[1]")
    private WebElement loginWithBlanksCredentialsTxt;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div[1]/text()")
    private WebElement loginWithBadPasswordTxt;
    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")
    private WebElement errorIncorrectLoginOrPasswordProvidedTxt;
    @FindBy(xpath = "//h2[contains(text(),'New Customer')]")
    private WebElement newCustomer;
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    private WebElement returningCustomer;
    @FindBy(xpath = "//*[@id='content']/div/div[2]/div/form/div[2]/a")
    private WebElement forgotYourPasswordLink;
    @FindBy(xpath = "//strong[contains(text(),'Register Account')]")
    private WebElement registerAccount;

    @FindBy(css = ".alert-dismissible")
    private WebElement errorLoginMsg;

    @FindBy(css = ".well > p:nth-of-type(2)")
    private WebElement byCreatingAccountToShopFaster;

    //============================================================
    @FindBy(id = "input-email")
    private WebElement emailField;
    @FindBy(id = "input-password")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;
    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
    private WebElement warningMessage;

    @FindBy(id = "input-email")
    private WebElement inputEmailField;

    @FindBy(id = "input-password")
    private WebElement inputPasswordField;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement login_Button;

    @FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
    private WebElement warningMsg;

    public LoginPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //============================================================

    public String assertPageIsLoginPage() {
        return new VerificationHelper(driver).getCurrentPageUrl();

    }

    public void inputEmail(String emailAddress) {
        email.click();
        email.sendKeys(emailAddress);
        log.info("Sent :: " + emailAddress);
    }

    public void inputPassword(String pass) {
        password.clear();
        password.sendKeys(pass);
        log.info("Sent :: " + pass);
    }

    public String getLoginBtn() {
        return new VerificationHelper(driver).getText(loginBtn);

    }

    public void inputLoginApplication(String emailAddress, String pass) {
        inputEmail(emailAddress);
        inputPassword(pass);

    }

    public AccountPage login(String emailText, String passwordText) throws IOException {
        email.sendKeys(emailText);
        password.sendKeys(passwordText);
        log.info("clicked :: " + loginBtn.getText());
        loginBtn.click();
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new AccountPage(driver);
    }

    public String retrieveEmailPasswordNotMatchingWarningMessageText() {
        return emailPasswordNotMatchingWarning.getText();

    }

    public AccountPage loginInApplication(String emailAddress, String pass) throws IOException {
        email.sendKeys(emailAddress);
        password.sendKeys(pass);
        loginBtn.click();
        log.info("Successfully clicked on Login button navigating >> " + getClass());
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new AccountPage(driver);
    }

    public void logon(String emailAddr, String passWord) {
        email.clear();
        email.sendKeys(emailAddr);
        password.clear();
        password.sendKeys(passWord);
        loginBtn.click();
    }

    public void setEmail(String emailAddress) {
        log.info("Sent :: " + emailAddress);
        email.sendKeys(emailAddress);

    }

    public void setPassword(String pwd) {
        log.info("Sent :: " + pwd);
        password.sendKeys(pwd);

    }

    public void clickLogin() {
        log.info("Clicked :: " + loginBtn);
        loginBtn.click();

    }

    public AccountPage clickOnLoginBtnInAccountLoginPage() throws IOException {
        log.info("clicked :: " + loginBtn.getText());
        //loginBtn.sendKeys(Keys.RETURN);
        loginBtn.click();
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new AccountPage(driver);
    }

    public void clickLoginBtnInAccountLoginPage() {
        log.info("clicked :: " + loginBtn.getText());
        loginBtn.click();
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
    }

    public String getForgotYourPasswordLink() {
        return new VerificationHelper(driver).getText(forgotYourPasswordLink);

    }

    public String getRegisterAccount() {
        return new VerificationHelper(driver).getText(registerAccount);

    }

    public boolean assertRegisterAccount() {
        return new VerificationHelper(driver).isDisplayed(registerAccount);

    }


    public ForgottenPasswordPage clickForgotYourPasswordLink() {
        log.info("clicked :: " + forgotYourPasswordLink.getText());
        forgotYourPasswordLink.click();
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new ForgottenPasswordPage(driver);
    }


    public void clickLoginBtn() {
        log.info("Clicked on :: " + loginBtn.getText());
        loginBtn.click();
    }

    public boolean assertWarningConfirmationMsg() {
        return new VerificationHelper(driver).isDisplayed(errorLoginMsg);

    }

    public String getErrorWarningConfirmationMsg() {
        return new VerificationHelper(driver).getText(errorLoginMsg);

    }

    public String getNewCustomer() {
        return new VerificationHelper(driver).getText(newCustomer);

    }

    public String getReturningCustomer() {
        return new VerificationHelper(driver).getText(returningCustomer);

    }

    //========================================================
    public void enterEmailAddress(String emailText) {
        emailField.sendKeys(emailText);
    }

    public void enterPassword(String passwordText) {
        passwordField.sendKeys(passwordText);

    }

    public String getWarningMessageText() {
        return new VerificationHelper(driver).getText(warningMessage);

    }


    public String getWarningMsg() {
        return getTextFromElement(warningMsg, GlobalVars.EXPLICIT_WAIT_BASIC_TIME);
    }

}

//========================================================

