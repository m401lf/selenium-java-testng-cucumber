package testCases.Demos.TestNGTests;

import base.BaseTest;
import helper.assertion.AssertionHelper;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.IndexPage;
import pages.LoginPage;
import utilities.utils.GlobalVars;

import java.io.IOException;

public class LoginRecoveryForgottenPasswordTest extends BaseTest {
    IndexPage indexPage;
    LoginPage loginPage;
    AccountPage accountPage;


    @Test
    public void loginForgottenPasswordTest() throws IOException {

        indexPage = new IndexPage(driver);
        indexPage.navigateToLoginPage();
        boolean status_url = indexPage.getCurrentPageUrl().equalsIgnoreCase(GlobalVars.getHomePageUrl());
        AssertionHelper.updateTestStatus(status_url);

        boolean status_title = indexPage.getCurrentPageTitle().equalsIgnoreCase(GlobalVars.getHomePageTitle());
        AssertionHelper.updateTestStatus(status_title);
        loginPage = indexPage.clickOnMyAccountAndLoginLink();

        boolean status_returningCustomer = loginPage.getReturningCustomer().equalsIgnoreCase(GlobalVars.getReturningCustomer());
        AssertionHelper.updateTestStatus(status_returningCustomer);

        boolean status_newCustomer = loginPage.getNewCustomer().equalsIgnoreCase(GlobalVars.getNewCustomer());
        AssertionHelper.updateTestStatus(status_newCustomer);

        loginPage.enterEmailAddress(GlobalVars.getUserName());
        loginPage.enterPassword(GlobalVars.getWrongPassword());
        accountPage = loginPage.clickOnLoginBtnInAccountLoginPage();

//        boolean status = loginPage.getErrorIncorrectLoginPasswordProvidedConfirmationMessageTxt().contains(GlobalVars.getIncorrectLoginPasswordProvidedTxt());
//        AssertionHelper.updateTestStatus(status);
//
//        boolean status_forgot_your_password = loginPage.getForgotYourPasswordLinkTxt().trim().contains(GlobalVars.getForgotYourPasswordTxt());
//        AssertionHelper.updateTestStatus(status_forgot_your_password);
//
//        boolean status_forgot_your_loginname = loginPage.getForgotYourLoginLinkTxt().contains(GlobalVars.getForgotYourLoginnameTxt());
//        AssertionHelper.updateTestStatus(status_forgot_your_loginname);
//
//        forgottenPasswordPage = loginPage.clickForgetYourPasswordLink();
//
//        boolean result = forgottenPasswordPage.isHeadingDisplayed();
//        AssertionHelper.updateTestStatus(result);
//
//        boolean result_hintText = forgottenPasswordPage.isHintHeadingDisplayed();
//        AssertionHelper.updateTestStatus(result_hintText);
//
//        forgottenPasswordPage.enterLoginname(GlobalVars.recoveryPassword_Username);
//        forgottenPasswordPage.enterEmail(GlobalVars.getEmailPassword());
//        loginPage = forgottenPasswordPage.clicksOnContinueButton();
//
//        boolean result_success = loginPage.getSuccessMsg().contains(GlobalVars.getRecoveryPasswordAlertSuccessMsg());
//        Assert.assertTrue(result_success);

    }

}