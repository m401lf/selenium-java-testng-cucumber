package testCases.Demos.TestNGTests;

import base.BaseTest;
import helper.assertion.AssertionHelper;
import org.testng.annotations.Test;
import pages.*;
import utilities.utils.GlobalVars;

import java.io.IOException;

public class LoginTest extends BaseTest {
    IndexPage indexPage;
    LoginPage loginPage;
    AccountPage accountPage;
   LogoutPage logoutPage;

   EditPage editPage;

    @Test
    public void loginTest() throws IOException, InterruptedException {
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
        loginPage.enterPassword(GlobalVars.getPassword());

        accountPage = loginPage.clickOnLoginBtnInAccountLoginPage();
        boolean status_welcomeMsg = accountPage.getEditAccountDetailsText().contains(GlobalVars.getWelcomeMsg());
        AssertionHelper.updateTestStatus(status_welcomeMsg);

        editPage = accountPage.clickOnYourEditAccountInformationLink();
        AssertionHelper.updateTestStatus(editPage.getCurrentPageUrl().contains(GlobalVars.getAccountEditUrlPath()));

        accountPage = editPage.clickContinue_Button();
        boolean status_updatedSuccessfully = accountPage.getSuccessYourAccountSuccessfullyUpdatedTxt().contains(GlobalVars.getUpdatedSuccessfully());
        AssertionHelper.updateTestStatus(status_updatedSuccessfully);

        logoutPage = accountPage.clickOnLogoutSideWidgetLink();
        boolean status_AccountLogoutHeader = logoutPage.getAccountLogoutTxt().contains(GlobalVars.getAccountLogoutHeaderTxt());
        AssertionHelper.updateTestStatus(status_AccountLogoutHeader);

        indexPage = logoutPage.clickAccountLogoutContinueBtn();
    }
}