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

public class RegistrationTest_Using_Properties_File extends TestBase {

    IndexPage indexPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    SuccessPage successPage;



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
        registerPage.inputPersonalDetailsSection(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),dataProp.getProperty("existingEmailAddr"), dataProp.getProperty("telephone"));
        registerPage.inputPassword(dataProp.getProperty("password"));
        registerPage.inputConfirmPassword(dataProp.getProperty("password"));
        registerPage.tickOnYesSubscribeRadioButton();
        registerPage.clickOnAgreeToPrivacyPolicyButton();
        successPage = registerPage.clickOnContinueButton();
        Assert.assertTrue(registerPage.getAlreadyRegisteredAccountWarningMsg().contains(input.get("alreadyRegisteredEmailWarning")),"Warning message regarding duplicate email address is not displayed");

    }


    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(GlobalVars.getDataProviderJsonPath());
        return new Object[][]{{data.get(1)}};
        //return new Object[][]{{testData.data.get(0)}, {testData.data.get(1)}, {testData.data.get(2)}}; //for array multiple testData.data set in the json file
    }
}
