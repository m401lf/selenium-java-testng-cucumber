package cucumber.steps;

import base.BasePage;
import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;


public class FooterSteps extends BaseTest {
    BasePage page = PageFactory.initElements(driver, BasePage.class);

    @When("^I click the Terms and Conditions link in the bottom footer$")
    public void i_click_the_Terms_and_Conditions_link_in_the_bottom_footer() throws Throwable {
        page.clickTermsAndConditionsLink();
    }

    @When("^I click the privacy policy link in the bottom footer$")
    public void i_click_the_privacy_policy_link_in_the_bottom_footer() throws Throwable {
        page.clickPrivacyPolicyLink();
    }

    @And("^the link should be labelled privacy policy\"([^\"]*)\"$")
    public void the_link_should_be_labelled_privacy_policy(String linkText) throws Throwable {
        page.assertPolicyPrivacyLinkIsDisplayed();

    }


}


