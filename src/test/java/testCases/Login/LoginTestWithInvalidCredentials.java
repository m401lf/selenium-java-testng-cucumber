package testCases.Login;

import base.BaseTest;
import com.github.javafaker.Faker;
import helper.assertion.AssertionHelper;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.LoginPage;
import utilities.utils.GlobalVars;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Locale;

// //@Listeners(testComponents.Listeners.class)

public class LoginTestWithInvalidCredentials extends BaseTest {

    LoginPage loginPage;
    Faker faker;

    // @Test(invocationCount = 2)
    @Test(description = "Login Test With Invalid Credentials")
    public void LoginTestInvalidCredentials(Method method) throws IOException {
        faker = new Faker(Locale.UK);
        indexPage = new IndexPage(driver);
        loginPage = indexPage.tapOnAnItemFromTopMenuAndclickItemFromDropdownList("My Account", "Login");
        loginPage.inputLoginApplication(faker.internet().emailAddress(), GlobalVars.getWrongPass());
        loginPage.clickOnLoginBtn();
        AssertionHelper.updateTestStatus(loginPage.assertWarningConfirmationMsg());
        AssertionHelper.updateTestStatus(loginPage.getErrorWarningConfirmationMsg().contains(GlobalVars.getWarningIncorrectLoginPasswordMsg()));
    }
}
