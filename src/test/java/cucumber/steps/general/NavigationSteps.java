package cucumber.steps.general;

import helper.action.GlobalVarsHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class NavigationSteps {


    public static void navigateToPage(String pageToNavigateTo) throws Throwable {
        NavigationSteps navigationSteps = new NavigationSteps();
        //navigationSteps.should_be_taken_on_to_the_candidate_page(pageToNavigateTo);
    }

    // This method is used for initial background navigation to the main page in
    // question

    private String determineWhetherBaseUrlIsForCandidateOrEmployer(String route) {
        String baseUrl;

        if (route.startsWith("/candidate")) {
            baseUrl = GlobalVarsHelper.getInstance().getCandidateURL();
        } else {
            baseUrl = GlobalVarsHelper.getInstance().getURL();
        }

        return baseUrl;
    }

    // this method is used in error validation scenarios to ensure that the user
    // stays on a page after receiving an error and trying to navigate away from pg
    @Then("^I should stay on the \"([^\"]*)\" candidate page$")
    public void should_stay_on_the_candidate_page(String pageName) throws Throwable {
        //return Assert.assertEquals(
        //"The navigation to the next page has succeeded even though it should have remained on the current page due to the expected error.",
        //PageHeadings.getHeadingForPage(pageName),
        //WebDrv.getInstance().getWebDriver().findElement(By.id("heading")).getText());
        ;
    }

    // USE THESE STEPS FOR NON-SEQUENTIAL PAGE FLOW
    // The below steps should be used
    // when on a radio button page that leads to
    // differing pages based on what radio button is selected

    // This method is used for checking for correct subsequent navigation to pages
    // using save+continue and
    // back button
    @Then("^I should land on to the \"([^\"]*)\" candidate page$")
    public void should_land_on_to_the_page(String pageName) throws Throwable {
        //CandidatePageCollection.getCurrentPage().assertOnHeadingText(PageHeadings.getHeadingForPage(pageName));
    }

    @Given("^I click on the back button on the \"([^\"]*)\" candidate page$")
    public void i_click_on_the_back_button_with_pagename(String pageName) throws Throwable {
//		BasePage backButtonPage = CandidatePageCollection.getCurrentPage();
//		backButtonPage.clickOnGoBackLink();
    }

    // USE THESE STEPS FOR SEQUENTIAL PAGE FLOW

    @Given("^I click on the back button on the candidate page I should land on to the \"([^\"]*)\" candidate page$")
    public void i_click_on_the_back_button(String pageName) throws Throwable {
        //BasePage backButtonPage = CandidatePageCollection.getCurrentPage();
        //backButtonPage.clickOnBackButton();
        //should_be_taken_on_to_the_candidate_page(pageName);
    }

    @Given("^I click on the back button on the candidate page$")
    public void i_click_on_the_back_button() throws Throwable {
        //BasePage backButtonPage = CandidatePageCollection.getCurrentPage();
        //CandidatePageCollection.moveToPreviousPage();
        //backButtonPage.clickOnGoBackLink();
    }

    // NON sequential page flow

    @Given("^I click on the save and continue button on the candidate page$")
    public void i_click_on_the_save_and_continue_button() throws Throwable {
//		BasePage saveAndContinueButtonPage = CandidatePageCollection.getCurrentPage();
//		saveAndContinueButtonPage.clickOnSaveAndContinueButton();
//		//CandidatePageCollection.moveToNextPage();
    }

    @When("^I click on the save and continue button I should land on to the \"([^\"]*)\" candidate page$")
    public void i_click_on_the_save_and_continue_button_I_should_land_on_to_the_candidate_page(String pageName)
            throws Throwable {
//		BasePage saveAndContinueButtonPage = CandidatePageCollection.getCurrentPage();
//		saveAndContinueButtonPage.clickOnSaveAndContinueButton();
        //should_be_taken_on_to_the_candidate_page(pageName);
    }

    @Given("^I click on the save and continue button on the \"([^\"]*)\" candidate page$")
    public void i_click_on_the_save_and_continue_button_with_pagename(String pageName) throws Throwable {
//		BasePage saveAndContinueButtonPage = CandidatePageCollection.getCurrentPage();
//		saveAndContinueButtonPage.clickOnSaveAndContinueButton();
    }

    @Then("^I click save and comeback later button on the candidate page$")
    public void i_click_save_and_comeback_later_button_on_the_candidate_page() throws Throwable {
        //BasePage saveAndComebackLaterPage = CandidatePageCollection.getCurrentPage();
        //saveAndComebackLaterPage.clickOnSaveAndComeBackLaterButton();
        //CandidatePageCollection.moveToPage(CandidateApplicationsPage.class);
    }

    @Then("^I click save and comeback later button on the \"([^\"]*)\" candidate page$")
    public void i_click_save_and_comeback_later_button_on_the_candidate_page(String pageName) throws Throwable {
        i_click_save_and_comeback_later_button_on_the_candidate_page();
    }

    // deprecated
    @Then("^I click on the back button on the candidate page I should be taken to the last \"([^\"]*)\" page that I entered information into$")
    public void i_should_be_taken_to_the_last_page_that_I_entered_information_into(String pageName) throws Throwable {
        //BasePage page = CandidatePageCollection.getCurrentPage();
        //page.clickOnBackButton();
        //i_am_taken_to_the_section_of_the_page_that_I_pressed_edit_on(pageName);
    }

    @Then("^I should be taken to the last \"([^\"]*)\" page that I entered information into$")
    public void i_should_be_taken_to_the_last_page_that_I_entered_information_into_2(String pageName) throws Throwable {
        //i_am_taken_to_the_section_of_the_page_that_I_pressed_edit_on(pageName);
    }

    @Then("^a new tab should open with the \"([^\"]*)\" page$")
    public void i_should_be_taken_to_a_new_tab_with_pagename(String pageName) throws Throwable {
        //HyperlinkAssertor.assertNewTabIsOpenedWithExpectedPage(pageName);
    }

    @Then("^the page title should be \"([^\"]*)\"$")
    public void the_page_title_should_be(String pageTitle) {
        //HyperlinkAssertor.assertNewTabOpenedWithExpectedTitle(pageTitle);
    }
	
	/*public void clickContinueButton() throws IOException {
		BasePage page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), BasePage.class);
        page.clickOnContinueButton();
        CandidatePageCollection.moveToPage(CandidateEqualityAndDiversityGenderPage.class);
	}*/

}
