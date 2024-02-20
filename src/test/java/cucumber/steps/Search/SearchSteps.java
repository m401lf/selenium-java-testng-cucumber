package cucumber.steps.Search;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.IndexPage;
import pages.SearchPage;
import pages.SearchResultPage;

import java.io.IOException;

public class SearchSteps extends BaseTest {

    WebDriver driver;
    IndexPage indexPage;
    SearchResultPage searchResultPage;
    SearchPage searchPage;


    @Given("I landed on an e-commerce index page")
    public void iLandedOnAnECommerceIndexPage() throws IOException {
        indexPage = new IndexPage(driver);
        indexPage = launchApplication();
    }

    @Given("User search for a valid product with keyword {string}")
    public void user_search_for_a_valid_product_with_keyword(String validKeyword) {
        indexPage.searchWithValidKeyword(validKeyword);
    }

    @Given("User search for an invalid product with keyword {string}")
    public void user_search_for_an_invalid_product_with_keyword(String invalidKeyword) {
        indexPage.SearchWithInvalidKeyword(invalidKeyword);
    }


    @When("User clicks on Search button")
    public void user_clicks_on_search_button() throws IOException {
        searchPage = indexPage.clickOnSearchButton();

    }

    @Then("User should get valid product displayed in search results")
    public void user_should_get_valid_product_displayed_in_search_results() {
        Assert.assertTrue(searchResultPage.displayStatusOfValidProduct());

    }


    /*@Then("User should get a message about no product matching")
    public void user_should_get_a_message_about_no_product_matching() {
        Assert.assertEquals("There is no product that matches the search criteria.", searchResultPage.getMessageText());

    }*/

    @When("User dont enter any product name into Search box field")
    public void user_dont_enter_any_product_name_into_search_box_field() throws IOException {
        indexPage = new IndexPage(driver);

    }

    @Given("Navigate to tutorialsninja search page")
    public void navigate_to_tutorialsninja_search_page() {


    }

    @When("Enter valid product name {string} into searchbox field")
    public void enter_valid_product_name_into_searchbox_field(String validProduct) {
        indexPage.enterProductIntoSearchBox(validProduct);
    }

    @And("Click on the Search button")
    public void click_on_the_search_button() {
        searchResultPage = indexPage.clickOnSearchBtn();
    }

    @Then("User should get valid product displayed in the search result")
    public void user_should_get_valid_product_displayed_in_the_search_result() {
        Assert.assertTrue(searchResultPage.verifyValidHPProductStatus());
    }

    @When("Enter invalid product name {string} into searchbox field")
    public void enter_invalid_product_name_into_searchbox_field(String invalidProduct) {
        indexPage.enterProductIntoSearchBox(invalidProduct);
    }

    @Then("User should get a message about no product matching")
    public void user_should_get_a_message_about_no_product_matching() {
        Assert.assertEquals("There is no product that matches the search criteria.",
                searchResultPage.getNoMatchWarningMsg());
    }

    @When("Do not enter any product name into searchbox field")
    public void do_not_enter_any_product_name_into_searchbox_field() throws IOException {
        indexPage = new IndexPage(driver);
    }


}
