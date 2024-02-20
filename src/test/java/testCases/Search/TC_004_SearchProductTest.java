package testCases.Search;

import base.BaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.IndexPage;
import pages.SearchPage;

@Listeners(base.Listeners.class)

@Test
public class TC_004_SearchProductTest extends BaseTest {
    private final Logger log = LogManager.getLogger(AccountPage.class);

    IndexPage indexPage;
    SearchPage searchPage;

    public void test_pruductSearch() {
        log.info(" Starting TC_004_SearchProductTest ");

        try {

            indexPage = new IndexPage(driver);

            //indexPage.enterProductName("iPhone");
            searchPage = indexPage.enterProductName("mac");
            searchPage.isProductExist("MacBook");

            Assert.assertTrue(searchPage.isProductExist("MacBook"));

        } catch (Exception e) {
            Assert.fail();
        }

        log.info(" Finished TC_004_SearchProductTest ");

    }
}
