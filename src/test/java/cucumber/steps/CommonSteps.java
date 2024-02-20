package cucumber.steps;

import base.BasePage;
import base.BaseTest;
import helper.CheckPageIsLoaded;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CommonSteps extends BaseTest {

    BasePage page = PageFactory.initElements(driver, BasePage.class);
    IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    AccountPage accountPage = PageFactory.initElements(driver, AccountPage.class);
    SuccessPage successPage = PageFactory.initElements(driver, SuccessPage.class);
    RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
    EditPage editPage = PageFactory.initElements(driver, EditPage.class);
    LogoutPage logoutPage = PageFactory.initElements(driver, LogoutPage.class);
    FooterPage footerPage = PageFactory.initElements(driver, FooterPage.class);

    @Then("the page correct heading should be {string}")
    public void the_page_correct_heading_should_be(String heading) throws Throwable {
        //page.assertHeadingIsDisplayed();
    }

    @Then("the page sub-heading displayed should be {string}")
    public void the_page_heading_displayed_should_be(String subHeading) {
        page.assertOnSubHeadingTextt(subHeading);
    }

    @Then("I am on the {string} page")
    public void checkHeadingOnThePage(String heading) {
        // checkHeading(heading);
    }

    // ********* Back Buttons *****************//
    @Then("I tap on the back button")
    public void clickOnBackButton() {
        //page.clickOnGoBackLink();

    }

    @Then("I navigate to previous page")
    @When("I click on the Go back")
    public void i_click_on_the_Go_back() {
        BasePage page = PageFactory.initElements(driver, BasePage.class);
        //page.clickOnGoBackLink();
    }

    // ********* Browser Back *****************//
    @Then("I click the browser back button")
    public void clickOnBrowserBackButton() {
        page.clickOnBrowserBackButton();

    }

    // ************ Continue Button ********** //
    @And("I navigate to next page")
    @Then("I tap on the Continue button")
    public void clickOnContinueButton() throws InterruptedException, IOException {
        BasePage page = PageFactory.initElements(driver, BasePage.class);
        //page.clickOnContinueButton();
    }

    @And("I continue without entering my email address")
    @Then("^I click Continue button$")
    public void clickContinueButton() {
        BasePage page = PageFactory.initElements(driver, BasePage.class);
        //page.clickContinueButton();
    }

    // ************ Submit Button ********** //
    @And("I click on the Continue button")
    public void i_click_on_the_continue_button() throws Throwable {
        BasePage page = PageFactory.initElements(driver, BasePage.class);
        //page.clickOnContinueBtn();
    }

    // ************ Continue Button ********** //
    @And("I Continue to next page")
    @Then("I tap on continue button")
    public void clickOnSaveAndContinueButton() throws IOException {
        BasePage page = PageFactory.initElements(driver, BasePage.class);
        page.clickOnContinueButton();
    }

    // *********** Sign in and Sign out *********** //
    @And("I logout from my account")
    @Then("I tapped on the logout link")
    public void clickOnLogoutLink() throws IOException, InterruptedException {
        BasePage page = PageFactory.initElements(driver, BasePage.class);
        page.clickOnLogoutSideWidgetAccountLink();

    }

    @Then("I am currently login page")
    public void checkSignOutLinkIsDisplayed() {
        BasePage page = PageFactory.initElements(driver, BasePage.class);
        page.assertHeadingIsDisplayed();
    }


    // ********** Error Messages ************ //
    @Then("I should get an Error Message")
    public void i_should_get_an_Error_Message(DataTable data) throws Throwable {
        List<Map<String, String>> errorSummary = data.asMaps(String.class, String.class);
        BasePage page = PageFactory.initElements(driver, BasePage.class);
        page.assertHeadingErrorIdIsDisplayed();
        // page.assertOnErrorMessage(errorSummary.get(0).get("ErrorMessage"));

    }

    @Then("I should get an Error Message {string}")
    public void i_should_get_an_Error_Message(String errorMessage) throws Throwable {
        BasePage page = PageFactory.initElements(driver, BasePage.class);
        page.assertHeadingErrorIdIsDisplayed();
    }

    // ************* Radio buttons  ********************** //

    @And("^The Radio button selections should be unticked by default$")
    public void the_radio_button_selections_should_be_unticked_by_default() throws Throwable {
        BasePage page = PageFactory.initElements(driver, BasePage.class);
        page.assertRadioButtonsUnchecked();
    }

    @And("I have selected the {string} option")
    public void i_have_selected_the_something_option(String radioBtnOption) throws Throwable {
        switch (radioBtnOption) {
            case "Yes":
                page.clickRadioBtnOption(0);
                break;

            case "No":
                page.clickRadioBtnOption(1);
                break;

            default:
                System.out.println("No matching option");
        }
    }

    @And("I changed from Yes to No option")
    public void i_changed_from_yes_to_no_option() throws Throwable {
        BasePage page = PageFactory.initElements(driver, BasePage.class);
        page.clickRadioBtnOption(1);
    }

    @And("^I changed from No to Yes option$")
    public void i_changed_from_no_to_yes_option() throws Throwable {
        BasePage page = PageFactory.initElements(driver, BasePage.class);
        page.clickRadioBtnOption(0);
    }

    // ******** Input fields ***************** //
    @Then("I should have the following input fields")
    public void i_should_have_the_following_input_fields(List<String> inputLabels) throws Throwable {
        for (int i = 0; i < inputLabels.size(); i++) {
            BasePage page = PageFactory.initElements(driver, BasePage.class);
            page.assertInputLabel(i, inputLabels.get(i));
        }
    }

    @When("I have not completed the mandatory fields")
    public void i_have_not_completed_the_mandatory_fields() throws Throwable {
        BasePage page = PageFactory.initElements(driver, BasePage.class);
        // No implementation required, as it says -- not completed the (mandatory)
        // fields
    }

    // ******** pages is Displayed ******* //
    @When("the pages is displayed")
    public void the_Page_is_displayed() throws Throwable {
        CheckPageIsLoaded.checkPageIsReady(5);
        // checks for the page is loaded completely and displayed, 5 times with 2seconds wait in between
    }

    @Then("Link with text {string} does not exist")
    public void check_link_with_text_does_not_exist(String text) {
        String locator = "//a[contains(text()," + "'" + text + "')]";
        List<WebElement> links = driver.findElements(By.xpath(locator));
        Assert.assertEquals(0, links.size(), "The link was found on the page");
    }

    @And("Click on the Continue button")
    public void click_on_the_continue_button() {
        //successPage = registerPage.clickOnContinueBtn();
    }

    @Then("Link with text {string} exists")
    public void check_link_with_text_does_exists(String text) {
        String locator = "//a[contains(text()," + "'" + text + "')]";
        List<WebElement> links = driver.findElements(By.xpath(locator));
        Assert.assertFalse(links.isEmpty(), "The link was not found on the page");
    }


}

