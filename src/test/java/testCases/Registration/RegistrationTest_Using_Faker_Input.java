package testCases.Registration;

import base.BaseTest;
import base.TestBase;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.util.Locale;

import static base.BasePage.randomEmailAddress;

@Listeners(base.Listeners.class)

public class RegistrationTest_Using_Faker_Input extends TestBase {
    IndexPage indexPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    SuccessPage successPage;
    AccountPage accountPage;
    EditPage editPage;
    LogoutPage logoutPage;
    Faker faker;

    @Test()
    public void RegistrationTestUsingFakerInput() throws IOException, InterruptedException {
        faker = new Faker(Locale.UK);
        String randomEmail = faker.internet().emailAddress();
        indexPage = new IndexPage(driver);
        loginPage = indexPage.clickOnMyAccountAndLoginLink();
        registerPage = loginPage.clickContinueButton();
        registerPage.inputFirstName(faker.name().firstName());
        registerPage.inputLastName(faker.name().lastName());
        registerPage.inputEmailAddress(randomEmailAddress());
        //registerPage.inputEmailAddress(randomEmail);
        registerPage.inputTelephone(faker.phoneNumber().cellPhone());
        registerPage.inputPassword("Password");
        registerPage.inputConfirmPassword("Password");
        Assert.assertTrue(registerPage.isNewsletterSubscribeNoButtonSelected());
        registerPage.tickOnYesSubscribeRadioButton();
        registerPage.clickOnAgreeToPrivacyPolicyButton();
        successPage = registerPage.clickOnContinueButton();
        Assert.assertTrue(successPage.assertPageHeaderIsDisplayed());
        accountPage = successPage.clickOnAccountSuccessContinueBtn();
        editPage = accountPage.clickOnYourEditAccountInformationLink();
        Assert.assertTrue(editPage.assertPageHeaderIsDisplayed());
        accountPage = editPage.clickContinue_Button();
        logoutPage = accountPage.clickOnLogoutSideWidgetAccountLink();
        indexPage = logoutPage.clickAccountLogoutContinueBtn();
    }

}
