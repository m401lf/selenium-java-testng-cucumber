package testCases.Login;

import base.BaseTest;
import helper.assertion.AssertionHelper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.LoginPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

//@Listeners(testComponents.Listeners.class)

public class TC_LF_002 extends BaseTest {

    LoginPage loginPage;

    @Test(dataProvider = "getData", groups = {"Login"}, description = "(TS_002) Login Functionality - Login Test With Invalid Credentials")
    public void LoginTestInvalidCredentials(HashMap<String, String> input) throws IOException {
        indexPage = new IndexPage(driver);
        loginPage = indexPage.tapOnAnItemFromTopMenuAndclickItemFromDropdownList(input.get("myAccountLink"), input.get("loginLink"));
        loginPage.inputLoginApplication(input.get("emailAddress"), input.get("password"));
        loginPage.clickOnLoginBtn();
        AssertionHelper.updateTestStatus(loginPage.assertWarningConfirmationMsg());
        AssertionHelper.updateTestStatus(loginPage.getErrorWarningConfirmationMsg().contains(input.get("loginErrorMsg")));
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//testData.data//Login.json");
        return new Object[][]{{data.get(0)}};
        //return new Object[][]  {{testData.data.get(0)}, {testData.data.get(1)}, {testData.data.get(2)}}; //for array multiple testData.data set in the json file
    }
}
