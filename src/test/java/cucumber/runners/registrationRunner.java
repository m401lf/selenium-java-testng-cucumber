package cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//cucumber->  TestNG, junit

@CucumberOptions(features = "src/test/java/cucumber/features/",
        glue = "cucumber/steps",
        monochrome = true,
        //dryRun = true,
        //name = "",
        tags = "@RegistrationDT",
        //tags = "@RegistrationFunctionality",
        //tags = "@Register",
        //tags = "@Registration",
        //tags = "@verifyCompulsoryFields",
        //tags = "@Login",
        //tags = "@Homepage_E2E",
        //tags = "@Loginname",
        //tags = "@Search_E2E",
        //tags = "@contactusPositive",
        //tags = "@contactus",
        //tags = "@LoginWithDataTable",
        //tags = "@RecoveryForgottenPassword",
        //tags = "@RecoveryForgottenLoginname",
        //tags = "@AccountRegistration",
        //tags = "@RegistrationFunctionality",
        //tags = "@Login",
        //tags = "@BrowserTabs",
        //tags = "@LoginPositive",
        //tags = "@Homepage_E2E",
        //tags = "Search_E2E",

        plugin = {
                "pretty",
                "json:target/json_output/cucumber.json",
                "junit:target/junit_xml_output/cucumber.xml",
                "html:target/html_output/cucumber.html"
        })

public class registrationRunner extends AbstractTestNGCucumberTests {
  /* @Override
	@DataProvider(parallel=true)
	public Object[][] scenarios() {
		return super.scenarios();
	}*/

}
