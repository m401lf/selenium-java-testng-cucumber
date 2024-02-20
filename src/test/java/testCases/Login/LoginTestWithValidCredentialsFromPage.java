package testCases.Login;

import base.BaseTest;
import helper.assertion.AssertionHelper;
import org.testng.annotations.Test;
import pages.*;
import utilities.utils.GlobalVars;

//@Listeners(testComponents.Listeners.class)

public class LoginTestWithValidCredentialsFromPage extends BaseTest {

    IndexPage indexPage;
    LoginPage loginPage;
    AccountPage accountPage;
    LogoutPage logoutPage;
    EditPage editPage;

    @Test(description = "Login test with valid credentials")
    public void loginTestValidCredentials() throws Exception {
        indexPage = new IndexPage(driver);
        loginPage = indexPage.clickOnMyAccountAndLoginLink();
        accountPage = loginPage.loginInApplication(GlobalVars.getEmailAddress(), GlobalVars.getPass());
        AssertionHelper.updateTestStatus(accountPage.getMyAccountTxt().contains(GlobalVars.getMyAccount()));
        editPage = accountPage.tapOnEditAsideWidgetLink();
        accountPage = editPage.clickContinue_Button();
        logoutPage = accountPage.tapLogoutLinkFromSideWidgetLinks();
        indexPage = logoutPage.clickAccountLogoutContinueBtn();
    }

}