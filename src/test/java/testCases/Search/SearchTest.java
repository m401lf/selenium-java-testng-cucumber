package testCases.Search;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.SearchPage;

import java.io.IOException;

@Listeners(base.Listeners.class)

public class SearchTest extends BaseTest {
    SearchPage searchPage;
    IndexPage indexPage;

    @Test(priority = 1)
    public void verifySearchWithValidProduct() throws IOException {
        indexPage = new IndexPage(driver);
        searchPage = indexPage.searchWithValidKeyword(dataProp.getProperty("validProduct"));
        Assert.assertTrue(searchPage.displayStatusOfHPValidProduct(), "Valid product HP is not displayed in the search results");

    }

    @Test(priority = 2)
    public void verifySearchWithInvalidProduct() throws IOException {
        indexPage = new IndexPage(driver);
        searchPage = indexPage.SearchWithInvalidKeyword(dataProp.getProperty("invalidProduct"));
        Assert.assertEquals(searchPage.retrieveNoProductMessageText(), "There is no product that matches the search criteria.", "No product message in search results is not displayed");

    }

    @Test(priority = 3, dependsOnMethods = {"verifySearchWithValidProduct", "verifySearchWithInvalidProduct"})
    public void verifySearchWithoutAnyProduct() throws IOException {
        indexPage = new IndexPage(driver);
        searchPage = indexPage.clickSearchButton();
        Assert.assertEquals(searchPage.retrieveNoProductMessageText(), dataProp.getProperty("NoProductTextInSearchResults"), "No product message in search results is not displayed");

    }

}
