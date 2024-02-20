package cucumber.steps.general;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RadioButtonSteps {

    @When("^I select the \"([^\"]*)\" radio button on the candidate page$")
    public void i_select_the_radio_button_on_the_candidate_page(String radioButton, String pageName) throws Throwable {

    }

    @When("^I select the \"([^\"]*)\" radio button on the \"([^\"]*)\" candidate page$")
    @And("^I select \"([^\"]*)\" as immigration status on \"([^\"]*)\" candidate page$")
    @Then("^I select \"([^\"]*)\" on the \"([^\"]*)\" candidate page$")
    public void i_select_the_radio_button_on_the_specific_candidate_page(String radioButton, String pageName)
            throws Throwable {
        i_select_the_radio_button_on_the_candidate_page(radioButton, pageName);
    }


}
