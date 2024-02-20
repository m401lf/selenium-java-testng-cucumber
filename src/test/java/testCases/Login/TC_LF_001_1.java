package testCases.Login;

import base.BaseTest;
import helper.assertion.AssertionHelper;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.IndexPage;
import pages.LoginPage;
import testData.data.LoginDetailsTestData;
import utilities.utils.GlobalVars;

//@Listeners(testComponents.Listeners.class)

public class TC_LF_001_1 extends BaseTest {

    IndexPage ip;
    LoginPage lp;
    AccountPage ap;


    @Test(description = "(TS_002): Login Functionality - Login test with valid credentials")
    public void loginTestValidCredentials() throws Exception {
        ip = new IndexPage(driver);
        lp = ip.clickOnMyAccountAndLoginLink();
        ap = lp.loginInApplication(LoginDetailsTestData.EMAIL, LoginDetailsTestData.PASSWORD);
        AssertionHelper.updateTestStatus(ap.getMyAccountTxt().contains(GlobalVars.getMyAccount()));
    }

}