package testCases.Registration;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

@Listeners(base.Listeners.class)

public class RegistrationTestViaRegisterLink extends BaseTest {
    IndexPage indexPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    SuccessPage successPage;
    AccountPage accountPage;
    EditPage editPage;
    LogoutPage logoutPage;

    @Test(description = "Registration Test By Register Link")
    public void RegistrationTestByRegisterLink() throws Exception {
        indexPage = new IndexPage(driver);
        registerPage = indexPage.tapOnItemFromAccountOptions("My Account", "Register");
        //registerPage.inputPersonalDetails("Firstname", "Lastname", "07405000000");
        registerPage.inputPersonalDetails(dataProp.getProperty("firstName"), "Lastname", "07405000000");

        registerPage.inputPasswordAndConfirmPassword("Password", "Password");
        registerPage.inputPassword("Password");
        registerPage.tickOnYesSubscribeRadioButton();
        registerPage.clickOnAgreeToPrivacyPolicyButton();
        successPage = registerPage.clickOnContinueButton();
        accountPage = successPage.clickOnAccountSuccessContinueBtn();
        editPage = accountPage.tapOnEditAsideWidgetLink();
        accountPage = editPage.clickContinue_Button();
        logoutPage = accountPage.tapOnSideWidgetLinkByName("Logout");
        indexPage = logoutPage.tapOnAccountLogoutContinueBtn();
        Assert.assertTrue(indexPage.assertLogoDisplayed());

    }

}
