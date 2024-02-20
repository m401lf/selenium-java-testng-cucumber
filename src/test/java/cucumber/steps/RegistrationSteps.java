package cucumber.steps;

import base.BasePage;
import base.BaseTest;
import helper.assertion.AssertionHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;

import java.io.IOException;
import java.util.Map;

import static base.BasePage.randomEmailAddress;

public class RegistrationSteps extends BaseTest {
    IndexPage indexPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    AccountPage accountPage;
    LogoutPage logoutPage;
    EditPage editPage;
    SuccessPage successPage;


    @Given("I landed on an e-commerce website {string}")
    public void iLandedOnAnECommercePageUrl(String url) throws IOException {
        indexPage = launchApplication();
    }

    @And("I navigate to account register page")
    public void i_navigate_to_account_register_page() throws IOException {
        registerPage = indexPage.clickMyAccountAndRegister();

    }

    @And("I input firstName {string}")
    public void i_input_first_name(String firstname) {
        registerPage.inputFirstName(firstname);

    }

    @And("I input lastName {string}")
    public void i_input_last_name(String lastname) {
        registerPage.inputLastName(lastname);

    }

    @And("I input unique email address")
    public void i_input_unique_email_address() {
        registerPage.enterEmailAddress(randomEmailAddress());

    }

    @And("I input telephone {string}")
    public void i_input_telephone(String tel) {
        registerPage.inputTelephone(tel);

    }

    @And("I input password {string}")
    public void i_input_password(String pass) {
        registerPage.inputPassword(pass);

    }

    @And("I input confirm password {string}")
    public void i_input_confirm_password(String conPass) {
        registerPage.inputConfirmPassword(conPass);

    }

    @And("I tick on subscription option Yes")
    public void i_tick_on_subscription_option_yes() {
        registerPage.tickOnYesSubscribeRadioButton();

    }

    @And("I can see Subscribe: {string} is ticked")
    public void i_can_see_subscribe_is_ticked(String yes) {
        AssertionHelper.updateTestStatus(registerPage.getSubscribeYesRadioButtonLabel().contains(yes));

    }

    @And("I tick on privacy policy radio button")
    public void i_tick_on_radio_button() {
        registerPage.clickOnAgreeToPrivacyPolicyButton();

    }

    @And("I tap on Continue button in account create page")
    public void i_tap_on_button_in_account_create_page() throws IOException {
        successPage = registerPage.clickOnContinueButton();
    }

    @And("I tap on Continue button in Account success page")
    public void i_tap_on_continue_button_in_account_success_page() throws IOException {
        accountPage = successPage.clickOnAccountSuccessContinueBtn();

    }

    @Then("I can see {string} in account page")
    public void i_can_see_and_in_account_page(String myAccount) {
        AssertionHelper.updateTestStatus(accountPage.getMyAccountTxt().contains(myAccount));
    }

    @And("I click on Logout Link from My Account dropdown list")
    public void iClickOnLogoutLinkFromMyAccountDropdownList() throws IOException {
        indexPage = new IndexPage(driver);
        logoutPage = accountPage.clickMyAccountAndLogout();
    }

    @And("I tap account logout Continue button")
    public void iTapAccountLogoutContinueButton() throws IOException {
        indexPage = logoutPage.clickAccountLogoutContinueBtn();

    }

    @And("{string} header is displayed")
    public void headerIsDisplayed(String registerAccount) {
        AssertionHelper.updateTestStatus(registerPage.getPageHeaderText().contains(registerAccount));
    }


    @Then("I should see red warning error message {string}")
    public void iShouldSeeRedWarningErrorMessage(String ppWarningTxt) {
        Assert.assertTrue(registerPage.getYouMustAgreeToPrivacyPolicyTxt().contains(ppWarningTxt), "Privacy Policy error does appear");
    }

    @And("I can see {string}")
    public void iCanSee(String fName) {
        AssertionHelper.updateTestStatus(registerPage.getFirstnameRedMessage().contains(fName));

    }

    @And("I should see {string}")
    public void iShouldSee(String lName) {
        AssertionHelper.updateTestStatus(registerPage.getLastnameRedMessage().contains(lName));

    }

    @And("{string} is displayed")
    public void emailDoesNotAppearToBeValidIsDisplayed(String email) {
        Assert.assertEquals(registerPage.getEmailRedMessage(), email);

    }

    @And("{string} must be between {string} and {string} characters!")
    public void mustBeBetweenAndCharacters(String tel, String mini, String max) {
        AssertionHelper.updateTestStatus(registerPage.getTelephoneRedMessage().contains(tel));
        AssertionHelper.updateTestStatus(registerPage.getTelephoneRedMessage().contains(mini));
        AssertionHelper.updateTestStatus(registerPage.getTelephoneRedMessage().contains(max));

    }


    @And("{string} must be between {string} and {string} characters! is displayed")
    public void mustBeBetweenAndCharactersIsDisplayed(String password, String mini, String max) {
        AssertionHelper.updateTestStatus(registerPage.getPasswordRedMessage().contains(password));
        AssertionHelper.updateTestStatus(registerPage.getPasswordRedMessage().contains(mini));
        AssertionHelper.updateTestStatus(registerPage.getPasswordRedMessage().contains(max));
    }


    @And("I should see {int} mandatory red icons")
    public void iShouldSeeMandatoryRedIcons(int count) {
        Assert.assertEquals(registerPage.assertRequiredFields(), count);
    }

    @Given("User navigates to login Account page")
    public void user_navigates_to_login_account_page() throws IOException {
        indexPage = new IndexPage(driver);
        loginPage = indexPage.clickOnMyAccountAndLoginLink();

    }

    @Given("User navigates to Register Account page")
    public void user_navigates_to_register_account_page() throws IOException {
        indexPage = new IndexPage(driver);
        indexPage = launchApplication();
        registerPage = indexPage.clickMyAccountAndRegister();

    }

    @When("User enters the details into below fields")
    public void user_enters_the_details_into_below_fields(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        registerPage.enterFirstName(dataMap.get("firstName"));
        registerPage.enterLastName(dataMap.get("lastName"));
        registerPage.enterEmailAddress(randomEmailAddress());
        registerPage.enterTelephoneNumber(dataMap.get("telephone"));
        registerPage.enterPassword(dataMap.get("password"));
        registerPage.enterConfirmPassword(dataMap.get("password"));

    }

    @When("User enters the details into below fields with duplicate email")
    public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        registerPage.enterFirstName(dataMap.get("firstName"));
        registerPage.enterLastName(dataMap.get("lastName"));
        registerPage.enterEmailAddress(dataMap.get("email"));
        registerPage.enterTelephoneNumber(dataMap.get("telephone"));
        registerPage.enterPassword(dataMap.get("password"));
        registerPage.enterConfirmPassword(dataMap.get("password"));

    }

    @When("User selects Privacy Policy")
    public void user_selects_privacy_policy() {
        registerPage.selectPrivacyPolicy();

    }

    @When("User clicks on Continue button")
    public void user_clicks_on_continue_button() throws IOException {
        successPage = registerPage.clickOnContinueButton();

    }

    /*@Then("User account should get created successfully")
    public void user_account_should_get_created_successfully() {
        Assert.assertEquals("Your Account Has Been Created!", successPage.getPageHeading());

    }*/

    @When("User selects Yes for Newsletter")
    public void user_selects_yes_for_newsletter() {
        registerPage.selectYesNewsletterOption();

    }

    @Then("User should get a proper warning about duplicate email")
    public void user_should_get_a_proper_warning_about_duplicate_email() {
        Assert.assertTrue(registerPage.getYouMustAgreePrivacyPolicyWarningMessage().contains("Warning: E-Mail Address is already registered!"));

    }

    @When("User dont enter any details into fields")
    public void user_dont_enter_any_details_into_fields() {

        registerPage.enterFirstName("");
        registerPage.enterLastName("");
        registerPage.enterEmailAddress("");
        registerPage.enterTelephoneNumber("");
        registerPage.enterPassword("");
        registerPage.enterConfirmPassword("");

    }

    @Then("User should get proper warning messages for every mandatory field")
    public void user_should_get_proper_warning_messages_for_every_mandatory_field() {

        Assert.assertTrue(registerPage.getYouMustAgreePrivacyPolicyWarningMessage().contains("Warning: You must agree to the Privacy Policy!"));
        Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.getFirstNameWarning());
        Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerPage.getLastNameWarning());
        Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.getEmailWarning());
        Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerPage.getTelephoneWarning());
        Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.getPasswordWarning());

    }

    @And("I can see the logo is displayed with {string} attribute equals {string}")
    public void iCanSeeTheLogoIsDisplayedWithAttributeEquals(String arg0, String arg1) {
    }

    @And("I can see {string} input sections")
    public void iCanSeeInputSections(String personalDetails) {
        //Assert.assertTrue(registerPage.getPageHeaderText().contains(personalDetails));
        AssertionHelper.updateTestStatus(registerPage.getYourPersonalDetailsTxt().equals(personalDetails));
    }

    @And("I can see {string} input sections label")
    public void iCanSeeInputSectionsLabel(String newsletter) {
        AssertionHelper.updateTestStatus(registerPage.getYourNewsletterTxt().equals(newsletter));
    }

    @And("I click subscription {string} option")
    public void iClickSubscriptionOption(String arg0) {
        registerPage.tickOnYesSubscribeRadioButton();

    }

    @And("I tick on {string} radio button")
    public void iTickOnRadioButton(String privacyPolicy) {
        AssertionHelper.updateTestStatus(registerPage.getAgreeToPrivacyPolicyText().contains(privacyPolicy));
        registerPage.clickOnAgreeToPrivacyPolicyButton();
    }

    @Then("I should see header text {string} and {string} message")
    public void iShouldSeeHeaderTextAndMessage(String successMsg, String congratMsg) {
        Assert.assertEquals(successPage.getPageHeaderText(), successMsg);
        Assert.assertTrue(successPage.getCongratulationsAccountSuccessfullyCreatedMsg().contains(congratMsg));
    }

    @And("I should see page title {string} and page url contains {string} in account page")
    public void iShouldSeePageTitleAndPageUrlContainsInAccountPage(String pageTitle, String pageUrl) {
        Assert.assertEquals(accountPage.getCurrentPageTitle(), pageTitle);
        Assert.assertTrue(accountPage.getCurrentPageUrl().contains(pageUrl));
    }

    @And("I tap on Edit account link")
    public void iTapOnEditAccountDetailsLink() throws Exception {
        editPage = accountPage.tapOnEditAsideWidgetLink();
    }

    @And("I can see page title {string} and url contains {string} in account edit page")
    public void iCanSeePageTitleAndUrlInAccountEditPage(String pageTitle, String pageUrl) {
        Assert.assertEquals(editPage.getCurrentPageTitle(), pageTitle);
        Assert.assertTrue(editPage.getCurrentPageUrl().contains(pageUrl));
    }

    @And("I input a unique email address")
    public void iUpdateAUniqueEmailAddress() {
        //editPage.enterFreshEmail();
        editPage.randomEmailAddress();
    }

    @And("I should see {string} in account page")
    public void iShouldSeeInAccountPage(String successfullyUpdated) {
        Assert.assertTrue(accountPage.getSuccessYourAccountSuccessfullyUpdatedTxt().contains(successfullyUpdated));
    }

    @And("I tap on {string} link from Aside Widget")
    public void iTapOnLinkFromAsideWidget(String logoutLink) throws IOException {
        Assert.assertTrue(accountPage.getLogoutAsideWidgetLink().contains(logoutLink));
        logoutPage = accountPage.tapLogoutLinkFromSideWidgetLinks();

    }

    @And("I should see page title {string} and page url contains {string} in account logout page")
    public void iShouldSeePageTitleAndPageUrlContainsInAccountLogoutPage(String pageTitle, String pageUrl) {
        Assert.assertTrue(logoutPage.getCurrentPageTitle().contains(pageTitle));
        Assert.assertTrue(logoutPage.getCurrentPageUrl().contains(pageUrl));
    }

    @And("click on {string} button")
    public void clickOnButton(String continueBtn) throws IOException {
        Assert.assertTrue(logoutPage.getContinueButton().contains(continueBtn));
        indexPage = logoutPage.clickAccountLogoutContinueBtn();
    }

    @And("I am taken back to index page url {string} and page title as {string}")
    public void iAmTakenBackToIndexPageUrlAndPageTitleAs(String pageUrl, String pageTitle) {
        Assert.assertTrue(indexPage.getCurrentPageUrl().contains(pageUrl));
        Assert.assertEquals(indexPage.getCurrentPageTitle(), pageTitle);
        driver.quit();
    }

    @And("I can see {string} section label")
    public void iCanSeeSectionLabel(String yourPassword) {
        AssertionHelper.updateTestStatus(registerPage.getPasswordSectionTxt().contains(yourPassword));
    }

    @Given("I input Your Personal Details and Your password sections with the following details:")
    public void i_input_your_personal_details_and_your_password_sections_with_the_following_details(DataTable dataTable) {
        registerPage.enterFirstName(dataTable.cell(1, 0));
        registerPage.enterLastName(dataTable.cell(1, 1));
        registerPage.enterTelephoneNumber(dataTable.cell(1, 2));
        registerPage.enterPassword(dataTable.cell(1, 3));
        registerPage.enterConfirmPassword(dataTable.cell(1, 4));
    }


    @And("I can see page title {string} and page url contains {string}")
    public void iCanSeePageTitleAndPageUrlContains(String pageTitle, String pageUrl) {
        Assert.assertEquals(indexPage.getCurrentPageTitle(), pageTitle);
        Assert.assertTrue(indexPage.getCurrentPageUrl().contains(pageUrl));
    }

    @And("I see page title {string} and page url contains {string}")
    public void iSeePageTitleAndPageUrlContains(String pageTitle, String pageUrl) {
        Assert.assertEquals(registerPage.getCurrentPageTitle(), pageTitle);
        Assert.assertTrue(registerPage.getCurrentPageUrl().contains(pageUrl));
    }

    @And("I should see page title {string} and url contains {string}")
    public void iShouldSeePageTitleAndUrlContains(String pageTitle, String pageUrl) {
        Assert.assertEquals(successPage.getCurrentPageTitle(), pageTitle);
        Assert.assertTrue(successPage.getCurrentPageUrl().contains(pageUrl));
    }

    @And("I can see page heading {string} and personal details {string} in account edit page")
    public void iCanSeePageTitleAndHeadingInAccountEditPage(String heading, String yourPersonalDetails) {
        Assert.assertEquals(editPage.getMyaccountInformationHeadingTxt(), heading);
        Assert.assertTrue(editPage.getMyPersonalDetailsTxt().equals(yourPersonalDetails));
    }


    @And("I click Continue button in edit account page")
    public void iClickButtonInEditAccountPage() throws IOException {
        accountPage = editPage.clickContinue_Button();

    }

    @And("I click {string} From My Account Dropdown options")
    public void iClickOptionFromMyAccountDropdownList(String option) throws IOException {
        BasePage page = new BasePage(driver);
        registerPage = page.clickMyAccountAndAnyOption(option);

    }

    @Given("Navigate to tutorialsninja Register Account page")
    public void navigate_to_tutorialsninja_register_account_page() throws IOException {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickOnMyAccount();
        registerPage = indexPage.selectRegisterOption();
    }

    @When("Enters the details into below fields")
    public void enters_the_details_into_below_fields(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        registerPage.enterFirstName(dataMap.get("firstName"));
        registerPage.enterLastName(dataMap.get("lastName"));
        registerPage.enterEmail(randomEmailAddress());
        registerPage.enterTelephoneNumber(dataMap.get("telephone"));
        registerPage.enterPassword(dataMap.get("password"));
        registerPage.confirmPassword(dataMap.get("password"));
    }

    @When("Enters the duplicate details into below fields")
    public void enters_the_duplicate_details_into_below_fields(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

        registerPage.enterFirstName(dataMap.get("firstName"));
        registerPage.enterLastName(dataMap.get("lastName"));
        registerPage.enterEmail(dataMap.get("email"));
        registerPage.enterTelephoneNumber(dataMap.get("telephone"));
        registerPage.enterPassword(dataMap.get("password"));
        registerPage.confirmPassword(dataMap.get("password"));
    }

    @And("Select privacy policy checkbox")
    public void select_privacy_policy_checkbox() {
        registerPage.selectPrivacyPolicyCheckbox();

    }

    @Then("User account should get created successfully")
    public void user_account_should_get_created_successfully() {
        Assert.assertEquals("Your Account Has Been Created!", successPage.getPageHeading());
    }

    @And("Select subscribe Yes for Newsletter")
    public void select_subscribe_yes_for_newsletter() {
        registerPage.selectYesForNewsLetterOption();
    }

    @Then("User should get a warning message like E-Mail Address is already registered")
    public void user_should_get_a_warning_message_like_e_mail_address_is_already_registered() {
        Assert.assertTrue(registerPage.getAlreadyRegisteredAccountWarningMsg()
                .contains("Warning: E-Mail Address is already registered!"));
    }

    @When("do not enters any details into all fields")
    public void do_not_enters_any_details_into_all_fields() {
        // Intentionally Kept Blank OR Pass Empty Data
    }

    @Then("User should get a warning message for every mandatory field including Privacy Policy")
    public void user_should_get_a_warning_message_for_every_mandatory_field_including_privacy_policy() {

        Assert.assertTrue(registerPage.getAlreadyRegisteredAccountWarningMsg()
                .contains("Warning: You must agree to the Privacy Policy!"));
        Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.getFirstNameWarning());
        Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerPage.getLastNameWarning());
        Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.getEmailWarning());
        Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerPage.getTelephoneWarning());
        Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.getPasswordWarning());
    }
}
