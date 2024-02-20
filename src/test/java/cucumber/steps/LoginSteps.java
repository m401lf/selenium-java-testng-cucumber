package cucumber.steps;

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

public class LoginSteps extends BaseTest {
    String email = System.currentTimeMillis() + "@aol.com";
    String wrongPassword = "Gen" + System.currentTimeMillis();


    IndexPage indexPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    AccountPage accountPage;
    SuccessPage successPage;
    EditPage editPage;
    LogoutPage logoutPage;

    @Given("I landed on an e-commerce page")
    public void iLanded0nAnECommercePage() throws IOException {
        indexPage = launchApplication();
    }

    @And("navigate to Login page")
    public void navigateToLoginPage() throws IOException {
        loginPage = new LoginPage(driver);
        loginPage = indexPage.navigateToLoginPage();
    }

    @And("I can see {string} and {string} sub headings texts")
    public void iCanSeeAndSubHeadingsTexts(String newCustomer, String returnCustomer) {
        boolean statusForNewCustomer = loginPage.getNewCustomer().contains(newCustomer);
        AssertionHelper.updateTestStatus(statusForNewCustomer);
        boolean statusForReturnCustomer =
                loginPage.getReturningCustomer().contains(returnCustomer);
        AssertionHelper.updateTestStatus(statusForReturnCustomer);
    }

    @And("I should see aside widget displayed list contains {string}")
    public void iShouldSeeAsideWidgetDisplayedListContains(String item) throws IOException {
        indexPage = new IndexPage(driver);
        AssertionHelper.updateTestStatus(loginPage.getAsideWidgetList().contains(item));
    }

    @And("I login in login page as a returning customer")
    public void iLoginInLoginPageAsAReturningCustomer(DataTable dataTable) throws IOException {
        loginPage.inputEmail(dataTable.cell(1, 0));
        loginPage.inputPassword(dataTable.cell(1, 1));
    }

    @When("^User enters valid email address (.+) into email field$")
    public void User_enters_valid_email_address_into_email_field(String emailText) {
        loginPage.enterEmailAddress(emailText);

    }

    @And("^User enters valid password (.+) into password field$")
    public void user_enters_valid_password_into_password_field(String passwordText) {
        loginPage.enterPassword(passwordText);

    }

    @And("User clicks on Login button")
    public void user_clicks_on_login_button() throws IOException {
        accountPage = loginPage.clickLoginButton();

    }


    @When("User enters invalid email address into email field")
    public void user_enters_invalid_email_address_into_email_field() {
        loginPage.enterEmailAddress("admin@admin.com");

    }

    @Given("I login in login page as a returning customer with invalid credential")
    public void i_login_in_login_page_as_a_returning_customer_with_invalid_credential(DataTable dataTable) throws IOException {
        loginPage.inputEmail(dataTable.cell(1, 0));
        loginPage.inputPassword(dataTable.cell(1, 1));

    }

    @And("I login in login page as a returning customer with email {string} and password {string}")
    public void iLoginInLoginPageAsAReturningCustomerWithValidLoginCredentials(String email, String pass)
            throws IOException {
        loginPage.inputEmail(email);
        loginPage.inputPassword(pass);
    }

    @Then("should be presented with the following validation message as {string}")
    public void shouldBePresentedWithTheFollowingValidationMessageAs(String myAccount) {
        AssertionHelper.updateTestStatus(accountPage.getMyAccountTxt().contains(myAccount));
    }

    @And("I tap on Your Edit Account Information link in aside widget")
    public void iTapOnEditAccountLinkInAsideWidget() throws IOException {
        accountPage = new AccountPage(driver);
        editPage = accountPage.clickOnYourEditAccountInformationLink();
    }

    @And("{string} header is displayed in edit account page")
    public void headerIsDisplayedInEditAccountPage(String myAccountInformationHeadingTxt) {
        AssertionHelper.updateTestStatus(editPage.assertMyAccountInformationHeadingTxt());
        AssertionHelper.updateTestStatus(
                editPage
                        .getMyaccountInformationHeadingTxt()
                        .contains(myAccountInformationHeadingTxt));
    }

    @And("Updated account information excluding email with the following details below:")
    public void updatedAccountInfoExcludingEmailWithTheFollowingDetailsBelow(DataTable dataTable) {
        editPage.enterFirstName(dataTable.cell(0, 0));
        editPage.enterLastName(dataTable.cell(0, 1));
        editPage.enterTelephone(dataTable.cell(0, 2));
    }

    @And("Updated Your Personal Details excluding email with the following details below:")
    public void updatedYourPersonalDetailExcludingEmailWithTheFollowingDetailsBelow(
            DataTable dataTable) {
        editPage.enterFirstName(dataTable.cell(0, 0));
        editPage.enterLastName(dataTable.cell(0, 1));
        editPage.enterTelephone(dataTable.cell(0, 2));
    }

    @And("Updated {string} excluding email with the following details below:")
    public void updatedYourPersonalDetailExcludingEmailWithTheFollowingDetails(
            DataTable dataTable, String myPersonalDetails) {
        AssertionHelper.updateTestStatus(
                editPage.getMyPersonalDetailsTxt().contains(myPersonalDetails));
        editPage.enterFirstName(dataTable.cell(0, 0));
        editPage.enterLastName(dataTable.cell(0, 1));
        editPage.enterTelephone(dataTable.cell(0, 2));
    }

    @And("click edit account Continue button")
    public void clicksOnContinueButton() throws IOException {
        accountPage = editPage.clickContinue_Button();
    }

    @And("I should see confirmation message {string}")
    public void iShouldSeeConfirmationMessage(String successMsg) {
        boolean statusForSuccessMsg = accountPage.getSuccessYourAccountSuccessfullyUpdatedTxt().contains(successMsg);
        AssertionHelper.updateTestStatus(statusForSuccessMsg);
    }

    @When("I clicks on Logout link in aside Widget")
    public void i_clicks_on_logout_link_in_aside_widget() throws IOException, InterruptedException {
        logoutPage = accountPage.clickOnLogoutSideWidgetLink();
    }

    @And("{string} text is displayed")
    public void textIsDisplayed(String accountLogout) {
        AssertionHelper.updateTestStatus(
                logoutPage.getAccountLogoutTxt().contains(accountLogout));
    }

    public void backToLandingPageTitleYourStore(String yourStore) {
        AssertionHelper.updateTestStatus(indexPage.getCurrentPageTitle().contains(yourStore));
        driver.quit();
    }

    @Then("should be presented with the following Error validation message as {string}")
    public void shouldBePresentedWithTheFollowingErrorValidationMessageAs(
            String loginValidationErrorMessage) {
        AssertionHelper.updateTestStatus(
                loginPage
                        .getErrorWarningConfirmationMsg()
                        .contains(loginValidationErrorMessage));
    }

    @When("User enters invalid password {string} into password field")
    public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {
        loginPage.enterPassword(invalidPasswordText);

    }

    @Then("User should get a proper warning message about credentials mismatch")
    public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {

        Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));

    }

    @When("User dont enter email address into email field")
    public void user_dont_enter_email_address_into_email_field() {
        loginPage.enterEmailAddress("");

    }

    @When("User dont enter password into password field")
    public void user_dont_enter_password_into_password_field() {

        loginPage.enterPassword("");

    }


    @And("I tap on edit profile button")
    public void iTapOnEditProfileButton() {
    }

    @And("inputted the following details below:")
    public void inputtedTheFollowingDetailsBelow() {
    }

    @When("I clicks on logoff button")
    public void iClicksOnLogoffButton() {
    }

    @And("I tap logout Continue Button")
    public void iTapLogoutContinueButton() throws IOException, InterruptedException {
        indexPage = logoutPage.clickAccountLogoutContinueBtn();
    }

    @And("back to landing page")
    public void backToLandingPage() {
        AssertionHelper.updateTestStatus(
        indexPage.getCurrentPageTitle().equalsIgnoreCase("Your Store"));
        driver.quit();
    }

    @And("back to login page title as {string}")
    public void backToLoginPage(String pageTitle) throws IOException {
        loginPage = new LoginPage(driver);
        AssertionHelper.updateTestStatus(loginPage.getCurrentPageTitle().equalsIgnoreCase(pageTitle));
        driver.quit();
    }

    @And("{string} sub header is displayed")
    public void subHeaderIsDisplayed(String registerAccount) {
        AssertionHelper.updateTestStatus(loginPage.assertRegisterAccount());
        AssertionHelper.updateTestStatus(
                loginPage.getRegisterAccount().equalsIgnoreCase(registerAccount));
    }

    @And("back to index page title as {string}")
    public void backToLandingPageTitleAs(String yourStore) {
        AssertionHelper.updateTestStatus(indexPage.getCurrentPageTitle().equalsIgnoreCase(yourStore));
        driver.quit();
    }

    @And("I can see aside widget labels count as {string} first label {string} and last {string}")
    public void iCanSeeLabelsAsAsFirstLabelAsAndLastAs(
            String labels_Count, String login, String newsletter) throws IOException {
        /*NavigationPage navigationPage = new NavigationPage(driver);
        AssertionHelper.updateTestStatus(
                navigationPage.assertAsideWidgetAndLabelPosition(labels_Count, login, newsletter));*/
    }


    @And("I click on Login button")
    public void iClickOnLoginButton() throws IOException {
        accountPage = loginPage.clickOnLoginBtnInAccountLoginPage();
    }

    @And("I tap Login button")
    public void iTapLoginButton() throws IOException {
        loginPage.clickLoginBtnInAccountLoginPage();
    }

    @And("I login in login page as a returning customer with unique email and password {string}")
    public void iLoginInLoginPageAsAReturningCustomerWithUniqueEmailAndPassword(String pass) {
        loginPage.inputEmail(email);
        loginPage.inputPassword(pass);

    }

    @And("I login in login page as a returning customer with valid email {string} and invalid password")
    public void iLoginInLoginPageAsAReturningCustomerWithValidEmailAndInvalidPassword(String emailAddress) {
        loginPage.inputEmail(emailAddress);
        loginPage.inputPassword(wrongPassword);

    }

    /*@And("I login in login page as a returning customer with email {string} and password {string}")
    public void iLoginInLoginPageAsAReturningCustomerWithEmailAndPassword(String email, String pass) {
        loginPage.inputEmail(email);
        loginPage.inputPassword(pass);

    }*/
    @Given("Navigate to tutorialsninja login page")
    public void Navigate_to_tutorialsninja_login_page() throws IOException {

        indexPage.clickOnMyAccount();
        loginPage = indexPage.selectLoginOption();
    }
    @When("^Enter valid email address (.+) in email field$")
    public void enter_valid_email_address_in_email_field(String email) {
        loginPage.enterEmailAddress(email);
    }

    @And("^Enter valid password (.+) in password field$")
    public void enter_valid_password_in_password_field(String password) {
        loginPage.enterPassword(password);
    }

    @And("Click on the Login button")
    public void click_on_the_login_button() throws IOException {
        accountPage = loginPage.clickOnLoginBtn();
    }

    @Then("User should get successfully logged in")
    public void user_should_get_successfully_logged_in() {
        Assert.assertTrue(accountPage.assertSuccessYourAccountSuccessfullyUpdatedTxtIsDisplayed());
    }

    @When("Enter invalid email address {string} in email field")
    public void enter_invalid_email_address_in_email_field(String invalidEmail) {
        loginPage.enterEmailAddress(invalidEmail);
    }

    @And("Enter invalid password {string} in password field")
    public void enter_invalid_password_in_password_field(String invalidPassword) {
        loginPage.enterPassword(invalidPassword);
    }

    @Then("User should get a warning message as No match for E-Mail Address and\\/or Password.")
    public void user_should_get_a_warning_message_as_no_match_for_e_mail_address_and_or_password() {
        Assert.assertTrue(loginPage.getWarningMsg().contains("Warning: No match for E-Mail Address and/or Password."));
    }

    @When("Do not enter email address in email field")
    public void do_not_enter_email_address_in_email_field() {
        // Intentionally Kept Blank OR Pass Empty Data
    }

    @And("Do not enter password in password field")
    public void do_not_enter_password_in_password_field() {
        // Intentionally Kept Blank OR Pass Empty Data
    }
}
