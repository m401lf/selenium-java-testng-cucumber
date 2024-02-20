package pages;

import base.BasePage;
import helper.assertion.VerificationHelper;
import helper.javaScript.JavaScriptHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.utils.GlobalVars;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class RegisterPage extends BasePage {
    private final Logger log = LogManager.getLogger(RegisterPage.class);
    String email = System.currentTimeMillis() + "@gmail.com";
    WebDriver driver;
    IndexPage indexPage;
    SuccessPage successPage;

    //====================@FindBy(name = "")===============================//

    By SectionHeaderTxt = By.xpath("//legend[normalize-space()='Newsletter']");
    @FindBy(xpath = "/html/body/div[2]/div/div/form/fieldset[3]/div/div/label/input")
    List<WebElement> radioButtons;
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;
    @FindBy(name = "firstname")
    private WebElement txtFirstname;
    @FindBy(name = "lastname")
    private WebElement txtLastname;
    @FindBy(name = "email")
    private WebElement txtEmail;
    @FindBy(name = "telephone")
    private WebElement txtTelephone;
    @FindBy(name = "password")
    private WebElement txtPassword;
    @FindBy(name = "confirm")
    private WebElement txtConfirmPassword;
    @FindBy(name = "agree")
    private WebElement chkdPolicy;
    @FindBy(css = "input.btn btn-primary")
    WebElement continueBtn;

    @FindBy(css = "input[value='Continue']")
    private WebElement continueButton; // editPage, registrationPage

    @FindBy(xpath = "//li[3]/a[@innertext='Register']")
    private WebElement registerSubMenu;
    @FindBy(css = "div[id='content'] h1")
    private WebElement registerAccountHeader;
    @FindBy(css = "div[id='content'] p")
    private WebElement ifYouAlreadyHaveAnAccountWithUs;
    //===================================================//
    @FindBy(id = "input-firstname")
    private WebElement firstNameField;
    @FindBy(id = "input-lastname")
    private WebElement lastNameField;
    @FindBy(id = "input-email")
    private WebElement emailField;
    @FindBy(id = "input-telephone")
    private WebElement telephoneField;
    @FindBy(id = "input-password")
    private WebElement passwordField;
    @FindBy(id = "input-confirm")
    private WebElement passwordConfirmField;
    @FindBy(name = "agree")
    private WebElement privacyPolicyOption;
    @FindBy(xpath = "//input[@name='newsletter'][@value='1']")
    private WebElement yesNewsletterOption;
    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
    private WebElement youMustAgreePrivacyPolicyWarningMessage;
    @FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
    private WebElement firstNameWarning;
    @FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
    private WebElement lastNameWaring;
    @FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
    private WebElement emailWarning;
    @FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
    private WebElement telephoneWarning;
    @FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
    private WebElement passwordWarning;
    @FindBy(css = "#form-register")
    private WebElement form;
    //**************Your Personal Details**************//
    @FindBy(css = "class='col-sm-2 col-form-label'")
    private List<WebElement> labels;
    @FindBy(xpath = "//legend[normalize-space()='Your Personal Details']")
    private WebElement yourPersonalDetailsSection;
    @FindBy(xpath = "//legend[normalize-space()='Your Password']")
    private WebElement yourPasswordSection;
    @FindBy(xpath = "//legend[normalize-space()='Newsletter']")
    private WebElement newsletterSection;
    @FindBy(id = "input-firstname")
    private WebElement firstName;
    @FindBy(id = "input-lastname")
    private WebElement lastName;
    @FindBy(id = "input-email")
    private WebElement emailAddress;

    @FindBy(css = "input#input-email")
    private WebElement emailAdd;

    @FindBy(id = "input-telephone")
    private WebElement telephone;
    @FindBy(xpath = "fieldset:nth-of-type(2) > legend")
    private WebElement yourPasswordTxt;
    @FindBy(id = "input-password")
    private WebElement password;

    //**************Newsletter**********************//



    @FindBy(id = "input-telephone")
    private WebElement telephoneNumField;


    @FindBy(id = "input-confirm")
    private WebElement confirmPasswordField;

    @FindBy(name = "agree")
    private WebElement privacyPolicyCheckbox;


    @FindBy(xpath = "//input[@name='newsletter'][@value='1']")
    private WebElement YesNewsLetterOption;

    @FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
    private WebElement duplicateAccountWarningMsg;


    //**************Your Password*****************//
    @FindBy(id = "input-confirm")
    private WebElement confirmPassword;
    @FindBy(css = "/html/body/div[2]/div/div/form/fieldset[3]/div/div/label/input")
    private List<WebElement> SubscribeRadioButtonList;
    @FindBy(css = "fieldset:nth-of-type(3) > legend")
    private WebElement newsletterHeader;
    @FindBy(xpath = "//label[@innertext='Subscribe']")
    private WebElement SubscribeLabel;
    @FindBy(xpath = "//label[normalize-space()='Yes']")
    private WebElement subscribeYesRadioButtonLabel;
    @FindBy(name = "newsletter")
    private WebElement newsletterSubscribeYesButton;
    @FindBy(css = "[checked='checked']")
    private WebElement newsletterSubscribeNoButton;
    @FindBy(css = "div[class='pull-right']")
    private WebElement agreeToPrivacyPolicy;
    @FindBy(css = "a[class='agree'] b")
    private WebElement privacyPolicy;
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement agreeToPrivacyPolicyButton;

    @FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
    private WebElement firstnameRedMessage;

    //**********ERRORS ********************//
    @FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
    private WebElement lastNameRedMessage;
    @FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
    private WebElement emailRedMessage;
    @FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
    private WebElement passwordRedMessage;
    @FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
    private WebElement telephoneRedMessage;
    @FindBy(css = ".alert-dismissible")
    private WebElement privacyPolicyError;
    @FindBy(xpath = "/html/body/div/div/div/form/fieldset/div/label")
    private List<WebElement> labelList;
    @FindBy(css = ".form-group.required")
    private List<WebElement> requiredFieldsList;

    public RegisterPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String fname) {
        txtFirstname.sendKeys(fname);

    }

    public void setLastName(String lname) {
        txtLastname.sendKeys(lname);

    }

    public void setEmail(String email) {
        txtEmail.sendKeys(email);

    }

    public void setTelephone(String tel) {
        txtTelephone.sendKeys(tel);

    }

    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);

    }

    public void setConfirmPassword(String pwd) {
        txtConfirmPassword.sendKeys(pwd);

    }

    public void setPrivacyPolicy() {
        chkdPolicy.click();

    }

    public void clickContinue() {
        new JavaScriptHelper(driver).scrollIntoViewAndClick(continueButton);
        log.info("Successfully clicked on Continue Button navigating :: " + getClass());
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page heading :: " + getCurrentPageTitle());
    }

    public String getConfirmationMsg() {
        try {
            return (msgConfirmation.getText());
        } catch (Exception e) {
            return (e.getMessage());

        }

    }

    public String getSubscribeYesRadioButtonLabel() {
        return new VerificationHelper(driver).getText(subscribeYesRadioButtonLabel);

    }

    public void clickOnAgreeToPrivacyPolicyButton() {
        agreeToPrivacyPolicyButton.click();

    }

    public List<WebElement> getLabels() {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicit_Wait())).until(ExpectedConditions.visibilityOfAllElements(labels));
    }

    public List<WebElement> getLabelListText() {
        for (WebElement label : labels) {
            if (label.isDisplayed()) {
                String labelName = label.getText();
                System.out.println(labelName);
            }
        }
        return labels;
    }

    public String getAgreeToPrivacyPolicyText() {
        return new VerificationHelper(driver).getText(agreeToPrivacyPolicy);

    }

    public WebElement getForm() {
        return form;

    }

    public void assertLabels_size_positions(int labelCourt, String firstname, String subscribe) {
        int size = labels.size();
        System.out.println("Size of labels: " + size);
        log.info("Size of labels: " + size);
        for (WebElement label : labels) {
            String labelsText = label.getText();
            log.info(labelsText);
            System.out.println(labelsText);
            if (labels.get(0).getText().trim().contains(firstname) || labels.get(5).getText().trim().contains(subscribe)) {
                Assert.assertEquals(size, labelCourt);

            }

        }

    }

    public int getLabelResultsCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until((d) -> this.labels.size() > 4);
        return this.labels.size();
    }

    public String getIfYouAlreadyHaveAnAccountWithUs() {
        return new VerificationHelper(driver).getText(ifYouAlreadyHaveAnAccountWithUs);
    }

    public String getYourPersonalDetailsTxt() {
        return new VerificationHelper(driver).getText(yourPersonalDetailsSection);
    }

    public boolean assertYourPersonalDetailsIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(yourPersonalDetailsSection);
    }

    public void inputFirstName(String fname) {
        firstName.clear();
        firstName.sendKeys(fname);
        log.info("inputted >> " + fname);
    }

    public void inputLastName(String lName) {
        lastName.clear();
        lastName.sendKeys(lName);
        log.info("inputted >> " + lName);
    }

    public void inputTelephone(String tel) {
        telephone.clear();
        telephone.sendKeys(tel);
        log.info("inputted >> " + tel);
    }

    public void inputPersonalDetails(String firstName, String lastName, String tel) {
        log.info("Entering personal details....");
        inputFirstName(firstName);
        inputLastName(lastName);
        inputEmailAddress(email);
        inputTelephone(tel);
        log.info("Finalised entering personal details....");
    }

    public void inputPersonalDetailsSection(String firstName, String lastName, String emailAddr, String tel) {
        log.info("Entering personal details....");
        inputFirstName(firstName);
        inputLastName(lastName);
        inputEmail(emailAddr);
        inputTelephone(tel);
        log.info("Finalised entering personal details....");
    }

    public void inputEmailAddress(String email) {
        waitAndSendKeys(emailAddress, email);
    }

    public void inputEmail(String emailAddr) {
        waitAndSendKeys(emailAddress, emailAddr);
        log.info("entered existing email :: " +emailAddr);
    }

    public String getPasswordSectionTxt() {
        return new VerificationHelper(driver).getText(yourPasswordSection);

    }

    public void inputPassword(String pass) {
        password.clear();
        password.sendKeys(pass);
        log.info("inputted password >> " + pass);

    }

    public void inputConfirmPassword(String confirmPass) {
        confirmPassword.clear();
        confirmPassword.sendKeys(confirmPass);
        log.info("inputted confirm password>> " + confirmPass);
    }


    public void inputPasswordAndConfirmPassword(String pass, String confirmPass) {
        inputPassword(pass);
        inputConfirmPassword(confirmPass);
    }

    public boolean assertNewsletterHeaderTextDisplayed() {
        return new VerificationHelper(driver).isDisplayed(newsletterHeader);

    }

    public boolean assertSubscribeLabelDisplayed() {
        return new VerificationHelper(driver).isDisplayed(SubscribeLabel);

    }

    public boolean assertNoRadioButtonSelected() {
        return radioButtons.get(1).isSelected();

    }

    public boolean assertYesRadioButtonSelected() {
        return radioButtons.get(0).isSelected();

    }

    public boolean assertSubscribeButtonSelected() {
        return new VerificationHelper(driver).isSelected(newsletterSubscribeYesButton);

    }

    public void tickOnYesSubscribeRadioButton() {
        newsletterSubscribeYesButton.click();

    }

    public void tickOnNewsletterSubscribeNoButton() {
        newsletterSubscribeNoButton.click();

    }

    public int getCountOfAllRequiredFields() {
        int size = requiredFieldsList.size();
        System.out.println("Size of labels: " + size);
        log.info("Size of labels: " + size);
        return size;
    }


    public String getPrivacyPolicyText() {
        return new VerificationHelper(driver).getText(privacyPolicy);

    }

    public boolean assertPrivacyPolicyRadioBtnSelected() {
        return new VerificationHelper(driver).isSelected(agreeToPrivacyPolicyButton);

    }


    public boolean assertContinueBtnIsEnabled() {
        return new VerificationHelper(driver).isEnabled(continueBtn);

    }

    public void assertContinueButton(WebElement element) {
        assertElementIsDisplayedAndEnabled(continueButton);

    }

    public String getYourPasswordSectionTxt() {
        return new VerificationHelper(driver).getText(yourPasswordSection);

    }

    public String getYourNewsletterTxt() {
        return new VerificationHelper(driver).getText(newsletterSection);

    }

    public String assertRegisterAccountHeader() {
        return new VerificationHelper(driver).getText(registerAccountHeader);

    }

    public String getYouMustAgreeToPrivacyPolicyTxt() {
        return new VerificationHelper(driver).getText(privacyPolicyError);

    }


    public String getEmailRedMessage() {
        return new VerificationHelper(driver).getText(emailRedMessage);

    }

    public String getFirstnameRedMessage() {
        return new VerificationHelper(driver).getText(firstnameRedMessage);

    }

    public String getLastnameRedMessage() {
        return new VerificationHelper(driver).getText(lastNameRedMessage);

    }

    public String getTelephoneRedMessage() {
        return new VerificationHelper(driver).getText(telephoneRedMessage);

    }

    public String getPasswordRedMessage() {
        return new VerificationHelper(driver).getText(passwordRedMessage);

    }

    public List<WebElement> getLabelList() {
        return labelList;

    }

    public List<WebElement> getRequiredFieldsList() {
        return requiredFieldsList;

    }

    public boolean assertContinueButtonIsEnabledAndDisplayed() {
        return new VerificationHelper(driver).assertElementEnabledAndDisplayed(continueButton);
    }

    public long assertRequiredFields() {
        return requiredFieldsList.size();

    }

    public boolean assertPasswordWarningIsDisplayed() {
        return passwordRedMessage.isDisplayed();
    }

    public boolean assertTelephoneWarningIsDisplayed() {
        return telephoneRedMessage.isDisplayed();
    }

    public boolean assertEmailWarningIsDisplayed() {
        return emailRedMessage.isDisplayed();

    }

    public boolean assertLastNameWarningIsDisplayed() {
        return lastNameRedMessage.isDisplayed();
    }

    public boolean assertFirstNameWarningIsDisplayed() {
        return firstnameRedMessage.isDisplayed();
    }

    public boolean assertPrivacyPolicyWarningIsDisplayed() {
        return privacyPolicyError.isDisplayed();

    }


    public SuccessPage registerWithMandatoryFields(String firstNameText, String lastNameText, String telephoneText, String passwordText, String confirmPass) throws IOException {
        firstName.sendKeys(firstNameText);
        lastName.sendKeys(lastNameText);
        emailAddress.sendKeys(email);
        telephone.sendKeys(telephoneText);
        password.sendKeys(passwordText);
        confirmPassword.sendKeys(confirmPass);
        agreeToPrivacyPolicyButton.click();
        continueButton.click();
        log.info("Successfully clicked on Continue Button");
        return new SuccessPage(driver);

    }

    public SuccessPage registerWithAllFields(String firstNameText, String lastNameText, String emailText, String telephoneText, String passwordText,String conPassword) throws IOException {
        firstName.sendKeys(firstNameText);
        lastName.sendKeys(lastNameText);
        emailAddress.sendKeys(emailText);
        telephone.sendKeys(telephoneText);
        password.sendKeys(passwordText);
        confirmPassword.sendKeys(conPassword);
        newsletterSubscribeYesButton.click();
        privacyPolicy.click();
        continueButton.click();
        log.info("Successfully clicked on Continue Button");
        return new SuccessPage(driver);

    }

    //public boolean displayStatusOfWarningMessages(String expectedPrivacyPolicyWarning, String expectedFirstNameWarning, String expectedLastNameWarning, String expectedEmailWarning, String expectedTelephoneWarning, String expectedPasswordWarning) {
    public boolean assertWarningMessagesAreDisplayed() {
        boolean  privacyPolicyWarningStatus = assertPrivacyPolicyWarningIsDisplayed();
        boolean firstNameWarningStatus = assertFirstNameWarningIsDisplayed();
        boolean lastNameWarningStatus = assertLastNameWarningIsDisplayed();
        boolean emailWarningStatus = assertEmailWarningIsDisplayed();
        boolean telephoneWarningStatus = assertTelephoneWarningIsDisplayed();
        boolean passwordWarningStatus = assertPasswordWarningIsDisplayed();
        return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus && telephoneWarningStatus && passwordWarningStatus;
    }

    public boolean displayStatusOfWarningMessages(String expectedPrivacyPolicyWarning, String expectedFirstNameWarning, String expectedLastNameWarning, String expectedEmailWarning, String expectedTelephoneWarning, String expectedPasswordWarning) {
        boolean  privacyPolicyWarningStatus = Boolean.parseBoolean(String.valueOf(passwordRedMessage.getText().contains(expectedPrivacyPolicyWarning)));
        boolean firstNameWarningStatus = Boolean.parseBoolean(String.valueOf(firstnameRedMessage.getText().contains(expectedFirstNameWarning)));
        boolean lastNameWarningStatus = Boolean.parseBoolean(String.valueOf(lastNameRedMessage.getText().contains(expectedLastNameWarning)));
        boolean emailWarningStatus = Boolean.parseBoolean(String.valueOf(emailRedMessage.getText().contains(expectedEmailWarning)));
        boolean telephoneWarningStatus = Boolean.parseBoolean(String.valueOf(telephoneRedMessage.getText().contains(expectedTelephoneWarning)));
        boolean passwordWarningStatus = Boolean.parseBoolean(String.valueOf(passwordRedMessage.getText().contains(expectedPasswordWarning)));
        return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus && telephoneWarningStatus && passwordWarningStatus;
    }






    public void assertContinueButtonIsEnabled() {
        Assert.assertTrue(continueButton.isEnabled(), "Continue Button not enabled");
    }

    public boolean isNewsletterSubscribeNoButtonSelected() {
        return new VerificationHelper(driver).isSelected(newsletterSubscribeNoButton);

    }

    //================================================================
    public void enterFirstName(String firstNameText) {
        firstNameField.sendKeys(firstNameText);

    }

    public void enterLastName(String lastNameText) {
        lastNameField.sendKeys(lastNameText);

    }

    public void enterEmailAddress(String emailText) {
        emailField.sendKeys(emailText);

    }

    public void enterTelephoneNumber(String telephoneText) {
        telephoneField.sendKeys(telephoneText);

    }

    public void enterPassword(String passwordText) {
        passwordField.sendKeys(passwordText);

    }

    public void enterConfirmPassword(String passwordText) {
        passwordConfirmField.sendKeys(passwordText);

    }

    public void selectPrivacyPolicy() {
        privacyPolicyOption.click();

    }

    public void selectYesNewsletterOption() {
        yesNewsletterOption.click();

    }

    public String getYouMustAgreePrivacyPolicyWarningMessage() {
        return new VerificationHelper(driver).getText(youMustAgreePrivacyPolicyWarningMessage);

    }

    public String getFirstNameWarning() {
        return new VerificationHelper(driver).getText(firstNameWarning);

    }


    public String getEmailWarning() {
        return new VerificationHelper(driver).getText(emailWarning);

    }

    public String getTelephoneWarning() {
        return new VerificationHelper(driver).getText(telephoneWarning);

    }

    public String getPasswordWarning() {
        return new VerificationHelper(driver).getText(passwordWarning);

    }


    public void enterEmail(String email) {
        typeTextIntoElement(emailField, email, GlobalVars.EXPLICIT_WAIT_BASIC_TIME);
    }


    public void confirmPassword(String password) {
        typeTextIntoElement(confirmPasswordField, password, GlobalVars.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void selectPrivacyPolicyCheckbox() {
        clickOnElement(privacyPolicyCheckbox, GlobalVars.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void selectYesForNewsLetterOption() {
        clickOnElement(YesNewsLetterOption, GlobalVars.EXPLICIT_WAIT_BASIC_TIME);
    }


    public String getAlreadyRegisteredAccountWarningMsg() {
        return getTextFromElement(duplicateAccountWarningMsg, GlobalVars.EXPLICIT_WAIT_BASIC_TIME);
    }


    public String getLastNameWarning() {
        return new VerificationHelper(driver).getText(lastNameRedMessage);
    }
}