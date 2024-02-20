package testCases.End2End;

import base.BaseTest;
import helper.assertion.AssertionHelper;
import org.testng.annotations.Test;
import pages.*;
import utilities.utils.GlobalVars;

import java.io.IOException;

public class Order_IndexPage_E2E_Test extends BaseTest {
    String[] itemsNeeded= {"SKINSHEEN BRONZER STICK","BENEFIT BELLA BAMBA","ABSOLUE EYE PRECIOUS CELLS"};
    IndexPage indexPage;
    LoginPage accountLoginPage;
    AccountPage checkoutConfirmationPage;
    CheckoutCartPage checkoutCartPage;
    CheckoutSuccessPage checkoutSuccessPage;

    @Test
    public void completeOrder() throws IOException {
        indexPage = new IndexPage(driver);
        boolean status_url = indexPage.getCurrentPageUrl().equalsIgnoreCase(GlobalVars.getHomePageUrl());
        AssertionHelper.updateTestStatus(status_url);
        boolean status_title = indexPage.getCurrentPageTitle().equalsIgnoreCase(GlobalVars.getHomePageTitle());
        AssertionHelper.updateTestStatus(status_title);

/*        homePage.addProductsToCart(GlobalVars.PRODUCTNAME_1);
        homePage.addProductsToCart(GlobalVars.PRODUCTNAME_2);
        homePage.addProductsToCart(GlobalVars.PRODUCTNAME_3);

        checkoutCartPage = homePage.clickCartLink();
        checkoutCartPage.inputItemQuantity(4);
        checkoutCartPage.clickOnUpdateBtn();

        checkoutCartPage.inputItemQuantity(2);
        checkoutCartPage.clickOnUpdateBtn();

        checkoutCartPage.clickOnRemoveIconBtn();

        accountLoginPage = checkoutCartPage.clickOnCheckoutBtn();

        boolean status_returningCustomer = accountLoginPage.getReturningCustomerTxt().equalsIgnoreCase(GlobalVars.getReturningCustomer());
        AssertionHelper.updateTestStatus(status_returningCustomer);
        boolean status_newCustomer = accountLoginPage.getNewCustomerTxt().equalsIgnoreCase(GlobalVars.getNewCustomer());
        AssertionHelper.updateTestStatus(status_newCustomer);
        accountLoginPage.enterLoginName(GlobalVars.getUserName());
        accountLoginPage.enterPassword(GlobalVars.getPassword());
        checkoutConfirmationPage = accountLoginPage.clickLoginButton();
        checkoutSuccessPage = checkoutConfirmationPage.clickOnConfirmOrderButton();

        boolean status_orderNunber = checkoutSuccessPage.getOrderNumberTxt().contains("Your order #");
        Assert.assertTrue(status_orderNunber, "Order numder is not contained and displayed");

        checkoutSuccessPage.clickOnContinueCheckoutSuccessBtn();*/

        AssertionHelper.updateTestStatus(indexPage.getCurrentPageUrl().contains("https://automationteststore.com/"));
        AssertionHelper.updateTestStatus(indexPage.getCurrentPageTitle().contains("A place to practice your automation skills!"));
    }
}