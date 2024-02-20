package testCases.Login;

import base.BaseTest;
import helper.assertion.AssertionHelper;
import org.testng.annotations.Test;
import pages.*;
import utilities.utils.GlobalVars;

//@Listeners(testComponents.Listeners.class)

public class LoginTest_ValidCredentials extends BaseTest {

    IndexPage ip;
    LoginPage lp;
    AccountPage ap;
    LogoutPage lgp;
    EditPage ep;

    @Test(description = "Login test with valid credentials")
    public void loginTestValidCredentials() throws Exception {
        ip = new IndexPage(driver);
        lp = ip.clickOnMyAccountAndLoginLink();
        ap = lp.loginInApplication(GlobalVars.getEmailAddress(), GlobalVars.getPass());
        AssertionHelper.updateTestStatus(ap.getMyAccountTxt().contains(GlobalVars.getMyAccount()));
        ep = ap.tapOnEditAsideWidgetLink();
        ap = ep.clickContinue_Button();
        lgp = ap.tapLogoutLinkFromSideWidgetLinks();
        ip = lgp.clickAccountLogoutContinueBtn();
    }

}