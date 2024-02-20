package cucumber.steps.general;


public class ErrorAssertionSteps {

    // generic error message steps

	/*@Then("^I should see the following field error message \"([^\"]*)\" on the candidate page for \"([^\"]*)\"$")
	public void i_should_view_a_field_error_message_on_the_candidate_page_for_a_particular_field(
		String fieldErrorMessage, String fieldErrorMessageId) throws Throwable {
		FieldErrorMessagePage errorMessagePage =  (FieldErrorMessagePage) CandidatePageCollection.getCurrentPage();
		errorMessagePage.assertOnFieldErrorMessage(fieldErrorMessage, fieldErrorMessageId);
	}*/

    // TODO this is the latest iteration of the above field error method - I'm not
    // including the
    // field error id parameter in the
    // feature file after a discussion with Sadhesh about passing in ids from
    // feature file as a bad idea
	/*@Then("^I should see the following field error message \"([^\"]*)\" on the candidate page$")
	public void i_should_view_a_field_error_message_on_the_candidate_page(String fieldErrorMessage) throws Throwable {
		FieldErrorMessagePage errorMessagePage = (FieldErrorMessagePage) CandidatePageCollection.getCurrentPage();
		errorMessagePage.assertOnFieldErrorMessage(fieldErrorMessage);
	}

	@Then("^I should see a field error on the candidate page for \"([^\"]*)\"$")
	public void i_should_see_a_field_error_message_on_the_page_for_a_particular_field(String invalidField)
			throws Throwable {
		FieldErrorMessagePage errorMessagePage = (FieldErrorMessagePage) CandidatePageCollection.getCurrentPage();
		errorMessagePage.assertOnFieldErrorMessage(invalidField);
	}

	@Then("^I should see a field error on the \"([^\"]*)\" candidate page for \"([^\"]*)\"$")
	public void i_should_see_a_field_error_message_on_the_page_for_a_particular_field(String pageName,
			String invalidField) throws Throwable {
		i_should_see_a_field_error_message_on_the_page_for_a_particular_field(invalidField);
	}

	@Then("^I should see the following summary error message \"([^\"]*)\" on the candidate page for \"([^\"]*)\"$")
	public void i_should_view_a_summary_error_message_on_the_page_for_a_particular_field(String summaryErrorMessage,
			String invalidField) throws Throwable {
		SummaryErrorMessagePage errorMessagePage = (SummaryErrorMessagePage) CandidatePageCollection.getCurrentPage();
		if (invalidField == null || invalidField.equals("")) {
			errorMessagePage.assertOnSummaryErrorMessage(summaryErrorMessage);
		} else {
			errorMessagePage.assertOnSummaryErrorMessage(summaryErrorMessage, invalidField);
		}
	}

	@Then("^I should see the following summary error message \"([^\"]*)\" on the candidate page$")
	public void i_should_view_a_summary_error_message_on_the_page(String summaryErrorMessage) throws Throwable {
		SummaryErrorMessagePage errorMessagePage = (SummaryErrorMessagePage) CandidatePageCollection.getCurrentPage();
		errorMessagePage.assertOnSummaryErrorMessage(summaryErrorMessage);
	}

	@Then("^I should see a summary error on the candidate page for \"([^\"]*)\"$")
	public void i_should_see_a_summary_error_message_on_the_page_for_a_particular_field(String invalidField)
			throws Throwable {
		SummaryErrorMessagePage errorMessagePage = (SummaryErrorMessagePage) CandidatePageCollection.getCurrentPage();
		errorMessagePage.assertOnSummaryErrorMessage(invalidField);
	}

	@Then("^I should see a summary error on the \"([^\"]*)\" candidate page for \"([^\"]*)\"$")
	public void i_should_see_a_summary_error_message_on_the_page_for_a_particular_field(String pageName,
			String invalidField) throws Throwable {
		i_should_see_a_summary_error_message_on_the_page_for_a_particular_field(invalidField);
	}
*/
}
