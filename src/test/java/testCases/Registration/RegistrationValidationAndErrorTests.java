package testCases.Registration;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.SuccessPage;
import utilities.utils.GlobalVars;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class RegistrationValidationAndErrorTests extends TestBase {

	IndexPage indexPage;
	LoginPage loginPage;
	RegisterPage registerPage;
	SuccessPage successPage;


	@Test(description = "Registering An Account With Mandatory Fields with unique email via DataProvider", dataProvider = "getData", groups = {"Register"})
	public void verifyRegisteringAnAccountWithMandatoryFields(HashMap<String, String> input) throws IOException {
		indexPage = new IndexPage(driver);
		registerPage = indexPage.navigateToRegisterPage();
		Assert.assertTrue(registerPage.getCurrentPageTitle().contains(input.get("registerPageTitle")));
		Assert.assertTrue(registerPage.getCurrentPageUrl().contains(input.get("registerPageUrlPath")));
		Assert.assertTrue(registerPage.assertPageHeaderIsDisplayed());
		Assert.assertTrue(registerPage.assertYourPersonalDetailsIsDisplayed());
		successPage = registerPage.registerWithMandatoryFields(input.get("fName"),input.get("lName"),input.get("tel"),input.get("password"), input.get("confirmPassword"));
		Assert.assertTrue(successPage.assertPageHeaderIsDisplayed());
		Assert.assertTrue(successPage.assertContinueButtonIsEnabledAndDisplayed());
	}

	@Test(description = "Registering Account By Providing All Fields with unique email via DataProvider", dataProvider = "getData", groups = {"Register"})
	public void verifyRegisteringAccountByProvidingAllFields(HashMap<String, String> input) throws IOException {
		indexPage = new IndexPage(driver);
		Assert.assertEquals(indexPage.getCurrentPageTitle(), (input.get("pageTitle")));
		Assert.assertTrue(indexPage.assertLogoDisplayed());
		loginPage = indexPage.tapOnAnItemFromTopMenuAndclickItemFromDropdownList("My Account", "Login");
		registerPage = loginPage.clickContinueButton();
		Assert.assertTrue(registerPage.getCurrentPageTitle().contains(input.get("registerPageTitle")));
		Assert.assertTrue(registerPage.getCurrentPageUrl().contains(input.get("registerPageUrlPath")));
		Assert.assertTrue(registerPage.assertPageHeaderIsDisplayed());
		Assert.assertTrue(registerPage.assertYourPersonalDetailsIsDisplayed());
		registerPage.inputPersonalDetails(input.get("fName"), input.get("lName"), input.get("tel"));
		registerPage.inputPassword(input.get("password"));
		registerPage.inputConfirmPassword(input.get("password"));
		registerPage.tickOnYesSubscribeRadioButton();
		registerPage.clickOnAgreeToPrivacyPolicyButton();
		successPage = registerPage.clickOnContinueButton();
		Assert.assertTrue(successPage.assertPageHeaderIsDisplayed());
		Assert.assertTrue(successPage.assertContinueButtonIsEnabledAndDisplayed());
	}
	
	@Test(description = "Registering Account With Existing EmailAddress via DataProvider", dataProvider = "getData", groups = {"Register"})
	public void verifyRegisteringAccountWithExistingEmailAddress(HashMap<String, String> input) throws IOException {
	
//		registerPage.registerWithAllFields(input.get("firstName"),input.get("lastName"),prop.getProperty("validEmail"),input.get("telephoneNumber"),prop.getProperty("validPassword"));
		indexPage = new IndexPage(driver);
		Assert.assertEquals(indexPage.getCurrentPageTitle(), (input.get("pageTitle")));
		Assert.assertTrue(indexPage.assertLogoDisplayed());
		loginPage = indexPage.tapOnAnItemFromTopMenuAndclickItemFromDropdownList("My Account", "Register");
		registerPage = loginPage.clickContinueButton();
		Assert.assertTrue(registerPage.getCurrentPageTitle().contains(input.get("registerPageTitle")));
		Assert.assertTrue(registerPage.getCurrentPageUrl().contains(input.get("registerPageUrlPath")));
		Assert.assertTrue(registerPage.assertPageHeaderIsDisplayed());
		Assert.assertTrue(registerPage.assertYourPersonalDetailsIsDisplayed());
		//registerPage.inputPersonalDetailsSection(input.get("fName"), input.get("lName"),input.get("existingEmailAddr"), input.get("tel"));
		registerPage.inputPersonalDetailsSection(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),input.get("existingEmailAddr"), input.get("tel"));
		registerPage.inputPassword(input.get("password"));
		registerPage.inputConfirmPassword(input.get("password"));
		registerPage.tickOnYesSubscribeRadioButton();
		registerPage.clickOnAgreeToPrivacyPolicyButton();
		successPage = registerPage.clickOnContinueButton();
		Assert.assertTrue(registerPage.getAlreadyRegisteredAccountWarningMsg().contains(input.get("alreadyRegisteredEmailWarning")),"Warning message regarding duplicate email address is not displayed");

	}

	@Test(description = "Registering Account Without Filling Any Details via DataProvider", dataProvider = "getData", groups = {"Register"})
	public void verifyRegisteringAccountWithoutFillingAnyDetails(HashMap<String, String> input) throws IOException {
		indexPage = new IndexPage(driver);
		registerPage = indexPage.navigateToRegisterPage();
		registerPage.clickContinue();
		Assert.assertTrue(registerPage.assertWarningMessagesAreDisplayed(), "Warning messages are not displayed");

		Assert.assertEquals(registerPage.getYouMustAgreePrivacyPolicyWarningMessage(), input.get("privacyPolicyWarning"));
		Assert.assertEquals(input.get("firstNameWarning"), registerPage.getFirstNameWarning());
		Assert.assertEquals(input.get("lastNameWarning"), registerPage.getLastNameWarning());
		Assert.assertEquals(input.get("emailWarning"), registerPage.getEmailWarning());
		Assert.assertEquals(input.get("telephoneWarning"), registerPage.getTelephoneWarning());
		Assert.assertEquals(input.get("passwordWarning"), registerPage.getPasswordWarning());

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(GlobalVars.getDataProviderJsonPath());
		return new Object[][]{{data.get(1)}};
		//return new Object[][]{{testData.data.get(0)}, {testData.data.get(1)}, {testData.data.get(2)}}; //for array multiple testData.data set in the json file
	}
}
