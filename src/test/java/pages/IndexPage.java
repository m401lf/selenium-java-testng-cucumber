package pages;

import base.BasePage;
import com.google.common.util.concurrent.Uninterruptibles;
import helper.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.utils.GlobalVars;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class IndexPage extends BasePage {
    public WebDriver driver;
    LoginPage loginPage;
    SearchPage searchPage;
    AddToCartPage addToCartPage;
    private final Logger log = LogManager.getLogger(IndexPage.class);

    public IndexPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public final String url = "https://tutorialsninja.com/demo/";

    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myAccountDropMenu;

    @FindBy(linkText = "Login")
    private WebElement loginOption;

    @FindBy(linkText = "Register")
    private WebElement registerOption;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    private WebElement searchBtn;

    @FindBy(css = "img[title='Your Store']")
    private WebElement logoImage;
    @FindBy(css = ".col-lg-3.col-md-3.col-sm-6.col-xs-12")
    private List<WebElement> allDisplayedProducts;
    @FindBy(xpath = "/html/body/nav/div/div/ul/li")
    private List<WebElement> topMenuList;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div/div/h4/a")
    private List<WebElement> ProductsNameList;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div/div/button/span")
    private List<WebElement> addToCartList;

    @FindBy(linkText = "Add to Cart")
    private WebElement addToCart;
    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myAccount;
    @FindBy(css = "div#search > input[name='search']")
    private WebElement searchBox;
    @FindBy(css = ".fa.fa-search")
    private WebElement searchButton;
    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement lnkMyAccount;
    @FindBy(linkText = "Register")
    private WebElement lnkRegister;
    @FindBy(linkText = "Login")   // Login link added in step6
    private WebElement linkLogin;
    @FindBy(xpath = "//input[@placeholder='Search']")  //For Search Product Test
    private WebElement txtSearchBox;
    @FindBy(xpath = "//div[@id='search']//button[@type='button']") //For Search Product Test
    private WebElement btnSearch;

    public void clickMyAccount() {
        lnkMyAccount.click();

    }

    public void clickRegister() {
        lnkRegister.click();

    }

    public void clickLogin() {
        linkLogin.click();

    }



    public SearchPage searchForAProduct(String productText) {
        searchBox.click();
        searchBox.sendKeys(productText);
        searchButton.click();
        searchPage = new SearchPage(driver);
        return searchPage;

    }

    public SearchPage enterProductName(String productText) {
        searchBox.sendKeys(productText);
        log.info("input product name :: " + productText);
        searchButton.click();
        searchPage = new SearchPage(driver);
        log.info("******navigating to :: " + getClass() + "*******");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page url :: " + getCurrentPageTitle());
        return searchPage;
    }

    public void clickSearch() {
        btnSearch.click();

    }

    public void clickSearchBox() {
        searchBox.click();

    }

    public void goTo() {
        driver.get("https://tutorialsninja.com/demo/");
        log.info("******************Test Started from " + getClass() + "*************");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page url :: " + getCurrentPageTitle());
    }

    public List<WebElement> getTopMenuList() {
        return topMenuList;

    }

    public WebElement getTopMenuItemByName(String itemNameTopMenu) {
        return getTopMenuList()
                .stream()
                .filter(product -> product.getText().equals(itemNameTopMenu))
                .findFirst()
                .orElse(null);
    }

    public void clickOnTopMenuItem(String itemName) {
        WebElement menuItem = getTopMenuItemByName(itemName);
        menuItem.click();
        log.info("Successfully clicked on the link" + itemName);
    }

    public void  clickLinkByText(String linkName) throws IOException {
        waitElementToAppearFor(2);
        driver.findElement(By.xpath("//*[contains(text(),'"+linkName+"')]")).click();
        waitElementToAppearFor(1);
        log.info("Successfully clicked on the" +linkName);
    }

    public int countAllDisplayedProductsInIndexPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until((d) -> this.allDisplayedProducts.size() > 15);
        System.out.println("Products count Displayed: " + this.allDisplayedProducts.size());
        return this.allDisplayedProducts.size();
    }

    public void enterProductIntoSearchBoxField(String productText) {
        searchBox.sendKeys(productText);
    }

    public void gotoUrl() {
        driver.get(GlobalVars.URL_HOMEPAGE);
        log.info("current page url :: " + getCurrentPageUrl());
    }

    public boolean assertMyAccountLinkIsEnabledAndDisplayed() {
        return new VerificationHelper(driver).assertElementEnabledAndDisplayed(lnkMyAccount);
    }


    public LoginPage selectLoginOption() throws IOException {
        loginOption.click();
        return new LoginPage(driver);

    }

    public RegisterPage selectRegisterOption() throws IOException {
        registerOption.click();
        return new RegisterPage(driver);

    }

    public SearchPage searchWithValidKeyword(String validKeyword) {
        searchBox.click();
        searchBox.sendKeys(validKeyword);
        searchButton.click();
        searchPage = new SearchPage(driver);
        return searchPage;
    }

    public SearchPage SearchWithInvalidKeyword(String inValidKeyword) {;
        searchBox.click();
        searchBox.sendKeys(inValidKeyword);
        searchButton.click();
        searchPage = new SearchPage(driver);
        return searchPage;

    }

    public SearchPage clickOnSearchButton() {
        searchButton.click();
        searchPage = new SearchPage(driver);
        return searchPage;

    }

    public void enterProductIntoSearchBox(String product) {

        searchBox.click();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        searchBox.sendKeys(product);

    }

    public SearchResultPage clickSearchBtn() {
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

        clickOnElement(searchBtn, GlobalVars.EXPLICIT_WAIT_BASIC_TIME);
        return new SearchResultPage(driver);

    }

    public void clickOnMyAccount() {
        clickOnElement(myAccountDropMenu, GlobalVars.EXPLICIT_WAIT_BASIC_TIME);

    }


    public SearchResultPage clickOnSearchBtn() {
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        searchBtn.click();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        return new SearchResultPage(driver);

    }

    public LoginPage navigateToLoginPage() throws IOException {
        myAccountDropMenu.click();
        loginOption.click();
        return new LoginPage(driver);


    }

    public RegisterPage navigateToRegisterPage() throws IOException {
        myAccountDropMenu.click();
        registerOption.click();
        return new RegisterPage(driver);

    }

}
