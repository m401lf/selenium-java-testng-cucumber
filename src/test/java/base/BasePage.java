package base;

import com.google.common.collect.Ordering;
import com.google.common.util.concurrent.Uninterruptibles;
import helper.action.WebElementOrderChecker;
import helper.action.WebElementOrderCheckerImpl;
import helper.assertion.AssertionHelper;
import helper.assertion.VerificationHelper;
import helper.javaScript.JavaScriptHelper;
import io.cucumber.java.en.And;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.*;
import utilities.utils.GlobalVars;

import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class BasePage {
    private final Logger log = LogManager.getLogger(BasePage.class);
    public WebDriver driver;
    String randomNumbers = System.currentTimeMillis() + "Gen";
    IndexPage indexPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    AccountPage accountPage;
    EditPage editPage;
    SuccessPage successPage;
    LogoutPage logoutPage;
    WishListPage wishListPage;
    OrderHistoryPage orderHistoryPage;
    DownloadsPage downloadsPage;
    RecurringPaymentsPage recurringPaymentsPage;
    RewardPointsPage rewardPointsPage;
    NewsletterPage newsletterPage;
    ReturnsPage returnsPage;
    TransactionsPage transactionsPage;
    AddressPage addressPage;
    ForgottenPasswordPage forgottenPasswordPage;
    AddToCartPage addToCartPage;


    @FindBy(css = ".//*")
    List<WebElement> allPageElements;
    @FindBy(css = "div#logo>h1>a")
    private WebElement logo;

    @FindBy(xpath = "/html/body/div/ul/li/a")
    List<WebElement> allPageBreadCrumbList;

    @FindBy(css = "a")
    private WebElement aTag;

    @FindBy(css = "///span[@innertext=' Home']")
    private WebElement homeIcon;

    @FindBy(css = "div[id='content'] h1")
    private WebElement pageHeader;

    @FindBy(xpath = "/html/body/nav/div/div[2]/ul/li[2]/ul//a")
    List<WebElement> myAccountOptionsList;

    @FindBy(xpath = "/html/body/nav/div/div/ul/li")
    List<WebElement> topMenuList;

    @FindBy(xpath = "/html/body/div[1]/nav/div[2]/ul/li/a")
    List<WebElement> subcategories;

    @FindBy(css = ".dropdown-menu a")
    List<WebElement> subcategoryDropdownList;
    @FindBy(css = "input[placeholder='Search']")
    private WebElement searchBox;
    @FindBy(xpath = "//div[@id='search']/descendant::button")
    private WebElement searchButton;
    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myAccountLink;
    @FindBy(linkText = "Logout")
    private WebElement logoutLink;
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    private WebElement registerOption;
    @FindBy(xpath = "//a[contains(text(),'Login')]") // Login link added in step6
    private WebElement loginOption;
    @FindBy(css = "input[class='btn btn-primary']")
    private WebElement loginButton;

    @FindBy(css = "input[value='Login']")
    private WebElement loginBtn;
    @FindBy(css = "input[value='Continue']")
    private WebElement continueButton; //  edit, registrationPage

    @FindBy(linkText = "Continue")
    WebElement Continue_Btn;
    @FindBy(css = "a.btn.btn-primary") // logoutPage, loginPage, accountSuccessPage
    private WebElement continueBtn;
    @FindBy(xpath = "/html/body/div/ul/li/a")
    private List<WebElement> breadCrumbList;

    @FindBy(xpath = "/html/body/div[2]/div/aside/div/a")
    List<WebElement> sideWidgetLinks;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    private WebElement logoutSideWidgetLink;
    @FindBy(xpath = "//a[normalize-space()='Edit Account']")
    private WebElement editAccountDetailsAsideWidgetLink;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    private WebElement logoutAsideWidgetLink;
    @FindBy(xpath = "//a[normalize-space()='Edit your account information']")
    private WebElement editYourAccountInformation;

    @FindBy(xpath = "//*[@id='wishlist-total']/span")
    private WebElement wishlist;

    @FindBy(css = "a[id='wishlist-total'] i[class='fa fa-heart']")
    private WebElement wishlistIcon;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LogoutPage clickOnLogoutSideWidgetAccountLink() throws IOException, InterruptedException {
        waitElementToAppearFor(0);
        new JavaScriptHelper(driver).scrollToElement(logoutSideWidgetLink);
        waitElementToAppearFor(1);
        logoutSideWidgetLink.click();
        log.info("Successfully clicked on Logout link");
        return new LogoutPage(driver);
    }


    public List<WebElement> getSubcategories() {
        return subcategories;

    }

    public List<WebElement> getSubcategoryDropdownList() {
        return subcategoryDropdownList;
    }
    public void assertPageBreadCrumDisplayed(){
        List<WebElement> pageList = allPageBreadCrumbList;
        for(WebElement pageBreadCrumb: allPageBreadCrumbList){
            if(pageBreadCrumb.isDisplayed()){
            }
        }
        System.out.println(pageList);
    }

    public static String randomEmailAddress() {
        Date date = new Date();
        String timestamp = date.toString().replace(" ", "_").replace(":", "_");
        return timestamp + "@gmail.com";
    }
    public String generateRandomEmail() {
        Date date = new Date();
        return "gen" + date.toString().replace(" ", "").replace(":", "") + "@gmail.com";
    }
    public List<WebElement> getAllElements() {
        return allPageElements;

    }

    public LoginPage navigateToLoginPage() throws IOException {
        myAccountLink.click();
        loginOption.click();
        return new LoginPage(driver);
    }

    public RegisterPage navigateToRegisterPage() throws IOException {
        myAccountLink.click();
        registerOption.click();
        return new RegisterPage(driver);
    }
    public void  clickLinkByText(String linkName) throws IOException {
        waitElementToAppearFor(2);
        driver.findElement(By.xpath("//*[contains(text(),'"+linkName+"')]")).click();
        waitElementToAppearFor(1);
        log.info("Successfully clicked on the link");
    }
    public List<String> assertHeaderAndLabelsTxt(String headerOrtext) {
        System.out.println(headerOrtext);
        return allPageElements.stream().map(WebElement::getText).filter(text -> text.equalsIgnoreCase(headerOrtext)).collect(Collectors.toList());
    }
    public RegisterPage clickMyAccountAndAnyOption(String Option) throws IOException {
        myAccountLink.click();
        myAccountOptionsList.stream().filter(s -> s.getText().contains(Option)).findFirst().ifPresent(WebElement::click);
        System.out.println("Successfully clicked on an element:: " + Option);
        return new RegisterPage(driver);
    }
    public RegisterPage clickContinueButton() throws IOException {
        log.info("Click :: " + continueBtn.getText());
        continueBtn.click();
        log.info("Successfully clicked on Continue button");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page url :: " + getCurrentPageTitle());
        return new RegisterPage(driver);
    }
    public AccountPage clickOnLoginBtn() throws IOException {
        loginButton.click();
        log.info("Successfully clicked on Login button");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new AccountPage(driver);
    }
    public LoginPage clickOnLoginAndMyAccountOptions(String login) throws IOException {
        myAccountOptionsList.stream()
                .filter(s -> s.getText().contains(login))
                .findFirst()
                .ifPresent(WebElement::click);
        System.out.println("Successfully clicked on an element:: " + login);
        return new LoginPage(driver);
    }

    public AccountPage clickLoginButton() throws IOException {
        loginButton.click();
        return new AccountPage(driver);

    }
    public LogoutPage clickMyAccountAndLogout() throws IOException {
        myAccountLink.click();
        logoutLink.click();
        log.info("Successfully clicked on My Account and Logout Link");
        return new LogoutPage(driver);
    }
    public EditPage clickOnYourEditAccountInformationLink() throws IOException {
        log.info("clicked :: " + editYourAccountInformation.getText());
        editYourAccountInformation.click();
        log.info("Successfully clicked on Edit Your Account Information link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new EditPage(driver);
    }
    public void clickSideWidgetLinkByName(String linkName) {
        sideWidgetLinks.stream()
                .filter(s -> s.getText().contains(linkName))
                .findFirst()
                .ifPresent(WebElement::click);
    }
    public EditPage tapOnEditAccount() throws IOException {
        clickSideWidgetLinkByName("Edit Account");
        log.info("clicked Edit Account link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new EditPage(driver);
    }
    public LogoutPage tapOnLogoutLink() throws IOException {
        clickSideWidgetLinkByName("Logout");
        log.info("clicked Logout link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new LogoutPage(driver);
    }

    public RegisterPage tapOnRegisterLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Register");
        log.info("clicked Register link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new RegisterPage(driver);
    }
    public ForgottenPasswordPage tapOnForgottenPasswordLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Forgotten Password");
        log.info("clicked Forgotten Password link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new ForgottenPasswordPage(driver);
    }
    public AccountPage tapOnMyAccountLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("My Account");
        log.info("clicked MyAccount link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new AccountPage(driver);
    }
    public AddressPage tapOnAddressBookLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Address Book");
        log.info("clicked Address Book link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new AddressPage(driver);
    }
    public WishListPage tapOnWishListLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Wish List");
        log.info("clicked Wish List link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new WishListPage(driver);
    }

    public OrderHistoryPage tapOnOrderHistoryLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Order History");
        log.info("clicked Order History link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new OrderHistoryPage(driver);
    }

    public DownloadsPage tapOnDownloadLinkFromAsideWidget() {
        clickSideWidgetLinkByName("Download");
        log.info("clicked Order Download link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new DownloadsPage(driver);
    }

    public RecurringPaymentsPage tapOnRecurringPaymentsLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Recurring payments");
        log.info("clicked Recurring payments link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new RecurringPaymentsPage(driver);
    }

    public RewardPointsPage tapOnRewardPointsLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Reward Points");
        log.info("clicked Reward Points link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new RewardPointsPage(driver);
    }

    public NewsletterPage tapOnNewsletterLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Newsletter");
        log.info("clicked Newsletter link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new NewsletterPage(driver);
    }

    public ReturnsPage tapOnReturnsLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Returns");
        log.info("clicked Returns link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new ReturnsPage(driver);
    }

    public TransactionsPage tapOnTransactionsLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Transactions");
        log.info("clicked Transactions link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new TransactionsPage(driver);
    }

    public EditPage tapOnEditAsideWidgetLink() throws Exception {
        editAccountDetailsAsideWidgetLink.click();
        log.info("Successfully clicked on Edit Account link navigating >> " + getClass());
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new EditPage(driver);
    }

    public LogoutPage tapOnSideWidgetLinkByName(String logoutLink) throws IOException {
        clickSideWidgetLinkByName(logoutLink);
        log.info("Successfully clicked on Logout link navigating >> " + getClass());
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new LogoutPage(driver);
    }

    public IndexPage tapOnAccountLogoutContinueBtn() throws IOException {
        log.info("clicked :: " + Continue_Btn.getText());
        continueBtn.click();
        log.info("Successfully clicked on Continue button navigating >> " + getClass());
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new IndexPage(driver);
    }

    public LogoutPage tapLogoutLinkFromSideWidgetLinks() throws IOException {
        log.info("clicked :: " + logoutAsideWidgetLink.getText());
        logoutAsideWidgetLink.click();
        log.info("Successfully clicked on Logout link navigating >> " + getClass());
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new LogoutPage(driver);
    }

    public String getLogoutAsideWidgetLink() {
        return logoutAsideWidgetLink.getText();
    }

    public RegisterPage tapOnItemFromAccountOptions(
            String menuItem, String accountOption) throws IOException {
        topMenuList.stream()
                .filter(s -> s.getText().contains(menuItem))
                .findFirst()
                .ifPresent(WebElement::click);
        myAccountOptionsList.stream()
                .filter(s -> s.getText().contains(accountOption))
                .findFirst()
                .ifPresent(WebElement::click);
        registerPage = new RegisterPage(driver);
        log.info("Successfully clicked on My Account dropdown item");
        return registerPage;
    }
    @And("I tap on {string} button in Account success page")
    public void iTapOnButtonInAccountSuccessPage(String successMsg) throws IOException {
        AssertionHelper.updateTestStatus(successPage.getYourAccountHasBeenCreatedHeadingTxt().contains(successMsg));
        accountPage = successPage.clickOnAccountSuccessContinueBtn();
    }

    public SuccessPage clickOnContinueButton() throws IOException {
        continueButton.click();
        log.info("Successfully clicked on Continue Button navigating >> " + getClass());
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page heading :: " + getCurrentPageTitle());
        return new SuccessPage(driver);
    }

    public AccountPage clickContinue_Button() throws IOException {
        waitElementToAppearFor(0);
        log.info("clicked :: " + continueButton.getText());
        continueButton.click();
        log.info("Successfully clicked on Continue button navigating >> " + getClass());
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new AccountPage(driver);
    }
    public IndexPage clickAccountLogoutContinueBtn() throws IOException {
        waitElementToAppearFor(0);
        log.info("clicked :: " + continueBtn.getText());
        continueBtn.isEnabled();
        continueBtn.click();
        log.info("Successfully clicked on Continue button navigating >> " + getClass());
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        log.info("******************Test Ended******************");
        return new IndexPage(driver);
    }
    public AccountPage clickOnAccountSuccessContinueBtn() throws IOException {
        continueBtn.isEnabled();
        log.info("clicked :: " + continueBtn.getText());
        continueBtn.click();
        log.info("Successfully clicked on Continue Button navigating >> " + getClass());
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page heading :: " + getCurrentPageTitle());
        return new AccountPage(driver);
    }

    public LoginPage tapOnAnItemFromTopMenuAndclickItemFromDropdownList(
            String menuItem, String menuDropdownListItem) throws IOException {
        driver.findElement(By.xpath("//a[contains(text(),'" + menuItem + "')]")).click();
        myAccountOptionsList.stream()
                .filter(s -> s.getText().equalsIgnoreCase(menuDropdownListItem))
                .findFirst()
                .ifPresent(WebElement::click);
        log.info("Successfully clicked on from top menu list links");
        return new LoginPage(driver);
    }

    public List<String> getAsideWidgetList() {
        List<String> asideWidgetList =
                sideWidgetLinks.stream()
                        .filter(WebElement::isDisplayed)
                        .map(WebElement::getText)
                        .collect(Collectors.toList());
        System.out.println("Aside Widget List: " + asideWidgetList);
        return asideWidgetList;
    }

    public int getCountAsideWidgetList() {
        List<String> asideWidgetList =
                sideWidgetLinks.stream()
                        .filter(WebElement::isDisplayed)
                        .map(WebElement::getText)
                        .toList();
        return asideWidgetList.size();
    }

    public RegisterPage clickMyAccountAndRegister() throws IOException {
        myAccountLink.click();
        registerOption.click();
        log.info("Successfully clicked on My Account and Register links");
        log.info("current page :: " + getCurrentPageUrl());
        return new RegisterPage(driver);
    }

    public boolean assertAsideWidgetAndLabelPosition(
            String labels_Count, String login, String newsletter) {
        int size = sideWidgetLinks.size();
        System.out.println("Size of labels: " + size);
        log.info("Size of labels: " + size);
        for (WebElement sideWidgetLink : sideWidgetLinks) {
            String labelsText = sideWidgetLink.getText();
            log.info(labelsText);
            System.out.println(labelsText);
        }
        return true;
    }
    public LoginPage clickOnMyAccountAndLoginLink() throws IOException {
        myAccountLink.click();
        loginOption.click();
        log.info("Successfully clicked on My Account and Logout Link" + getClass());
        log.info("current page :: " + getCurrentPageUrl());
        return new LoginPage(driver);
    }

    //=======================================================================//
    public LogoutPage clickSideWidgetLinks(String link) throws IOException {
        sideWidgetLinks.stream().parallel().filter(s -> s.getText().contains(link)).findFirst()
                .ifPresent(WebElement::click);
        return new LogoutPage(driver);
    }

    public EditPage clickEditAccountSideWidgetLinks(String link) throws IOException {
        sideWidgetLinks.stream().parallel().filter(s -> s.getText().contains(link)).findFirst()
                .ifPresent(WebElement::click);
        return new EditPage(driver);
    }

    public LogoutPage clickOnLogoutSideWidgetLink() throws IOException, InterruptedException {
        waitElementToAppearFor(0);
        new JavaScriptHelper(driver).scrollToElement(logoutSideWidgetLink);
        waitElementToAppearFor(1);
        logoutSideWidgetLink.click();
        log.info("Successfully clicked on Logout link");
        return new LogoutPage(driver);
    }

    public RegisterPage clickMyAccountAndRegisterLink() throws IOException {
        myAccountLink.click();
        registerOption.click();
        log.info("Successfully clicked on My Account and Register link navigating >> " + getClass());
        log.info("current page :: " + getCurrentPageUrl());
        log.info("current page :: " + getCurrentPageTitle());
        return new RegisterPage(driver);
    }

    public SearchPage searchForAProduct(String productText) {
        searchBox.sendKeys(productText);
        searchButton.click();
        log.info("Successfully clicked on search button");
        return new SearchPage(driver);
    }

    public SearchPage clickSearchButton() {
        searchButton.click();
        log.info("Successfully clicked on search button");
        return new SearchPage(driver);
    }

    public String getPageHeaderText() {
        return new VerificationHelper(driver).getText(pageHeader);

    }
    public boolean assertPageHeaderIsDisplayed() {
        Uninterruptibles.sleepUninterruptibly(Duration.ZERO);
        return new VerificationHelper(driver).isDisplayed(pageHeader);
    }

    public void waitAndSendKeys(WebElement element, String keysToSend) {
        element.clear();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(keysToSend);
    }

    public void waitAndClick(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        System.out.println("Clicked on :: " + findBy.getText());
        log.info("Clicked on :: " + findBy.getText());
        wait.until(ExpectedConditions.elementToBeClickable(findBy)).click();
    }
    public void waitFor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        System.out.println("Waited for the element :: " + element.getText());
        log.info("Waited for element visibility :: " + element.getText());
    }
    public void clickOnTextFromDropdownList(WebElement list, String textToSearchFor) {
        Wait<WebDriver> tempWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            tempWait.until(ExpectedConditions.elementToBeClickable(list)).click();
            list.sendKeys(textToSearchFor);
            list.sendKeys(Keys.ENTER);
            System.out.println("Successfully sent the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list + ">");
        } catch (Exception e) {
            System.out.println("Unable to send the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list.toString() + ">");
            Assert.fail("Unable to select the required text from the dropdown menu, Exception: " + e.getMessage());
        }
    }

    public void waitForElementToAppear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    public void waitForWebElementToAppear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitElementToAppearFor(int timeout) {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(timeout));

    }
    public void assertTextShouldNotBeDisplayedInHeadingText(String headingText) {
        WebElement newHeading = driver.findElement(By.id("heading"));
        Assert.assertNotEquals(headingText, newHeading.getText());
    }
    public void waitForAlert_And_ValidateText(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());
        String alert_Message_Text = driver.switchTo().alert().getText();
        Assert.assertEquals(alert_Message_Text, text);
    }

    public void clickMatchingElementByText(List<WebElement> elements, String text) {
        WebElement element = elements.stream().parallel().filter(s -> s.getText().equalsIgnoreCase(text)).findFirst().orElseThrow(() -> new RuntimeException("Element with text" + text + "not present"));
        element.click();

    }
    public void clickAMatchingElementByText(List<WebElement> elements, String ItemName) {
        WebElement element = elements.stream().parallel().filter(s -> s.getText().equalsIgnoreCase(ItemName)).findFirst().orElseThrow(() -> new RuntimeException("Element with text" + ItemName + "not present"));
        element.click();

    }
    public List<String> getAccountsSectionsList(List<WebElement> products) {
        List<String> accountsList = new ArrayList<>();
        List<WebElement> accountsHeaderList = driver.findElements((By) products);
        for (WebElement e : accountsHeaderList) {
            String text = e.getText();
            System.out.println(text);
            accountsList.add(text);
        }
        return accountsList;
    }
    public boolean isListAscendingOrder(List<Long> list) {
        return Ordering.natural().isOrdered(list);

    }
    public Iterator<String> getAllWindows() {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();
        return itr;
    }
    public void getUrl(String url) {
        log.info("navigating to :-" + url);
        driver.get(url);
    }
    public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ele);

    }
    public boolean JSClick(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", ele);

            flag = true;

        } catch (Exception e) {
            throw e;

        } finally {
            if (flag) {
                System.out.println("Click Action is performed: " + ele.getText());
            } else if (!flag) {
                System.out.println("Click Action is not performed: " + ele.getText());
            }
        }
        return flag;
    }
    public boolean assertHeaderTxtIsDisplayed(WebElement element) {
        return new VerificationHelper(driver).isDisplayed(element);
    }
    public ArrayList<Integer> getPriceMassagedData(Iterator<WebElement> itr) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        while (itr.hasNext()) {
            String p = itr.next().getText();
            if (p.contains("$")) {
                String actualData = p.substring(1);
                //log.info(actualData);
                double p1 = Double.parseDouble(actualData);
                int productPrice = (int) (p1);
                array.add(productPrice);
            }
        }
        return array;
    }
    public void click(WebElement element) {
        boolean flag = false;
        while (true) {
            try {
                element.click();
                flag = true;
            } catch (Exception e) {
                flag = false;
            }
            if (flag) {
                try {
                    element.click();
                    System.out.printf("Element: " + element.getText() + " has been clicked, Selenium exception triggered");
                } catch (Exception e) {
                    System.out.printf("Element: " + element + " has beed clicked, Selenium exception triggered: " + e.getMessage());
                }
                break;
            }
        }
    }
    public boolean assertLogoDisplayed() {
        return new VerificationHelper(driver).isDisplayed(logo);

    }

    public void waitForElementInvisible(WebElement element, int timer) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public boolean assertElementIsDisplayedAndEnabled(WebElement element) {
        return element.isDisplayed() && element.isEnabled();
    }

    public void assertOnOrderOfWebElementsByListOrder(List<String> elementIds) {
        String idOfParentElement = elementIds.get(0);
        WebElement parentWebElement = driver.findElement(By.id(idOfParentElement));
        List<WebElement> childWebElements = parentWebElement.findElements(By.xpath(".//*"));
        WebElementOrderChecker webElementOrderChecker = new WebElementOrderCheckerImpl(childWebElements);
        List<String> childIds = getIdListOfExpectedChildElements(elementIds);
        Assert.assertTrue(webElementOrderChecker.areWebElementsOrderedLikeSpecifiedListByElementId(getIdListOfExpectedChildElements(childIds)), "Web Elements are expected to be in the order: " + childIds);
    }

    public void assertOnPageErrorMessage(String expectedErrorMsg) {
        //Assert.assertEquals("Error message mismatch", expectedErrorMsg, error.getText().trim());
    }

    public void assertOnSubHeadingText(String subHeadingText) {
        WebElement subHeading = driver.findElement(By.id("sub_heading"));
        Assert.assertEquals(subHeadingText, subHeading.getText());
    }

    public void assertOnSubHeadingTextt(String subHeadingText) {
        WebElement subHeading = driver.findElement(By.id("error-summary-title"));
        Assert.assertEquals(subHeadingText, subHeading.getText());
    }

    public List<WebElement> getBreadCrumbList() {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicit_Wait())).until(ExpectedConditions.visibilityOfAllElements(breadCrumbList));
        return breadCrumbList;
    }

    public boolean assertItemDisplayedFromList(List<WebElement> listElements, String item) {
        return listElements.stream().parallel().anyMatch(s -> s.getText().equalsIgnoreCase(item));
    }

    public WebElement getPageHeader() {
        return pageHeader;

    }
    public String getCurrentPageUrl() {
        return new VerificationHelper(driver).getCurrentPageUrl();

    }

    public String getCurrentPageTitle() {
        return new VerificationHelper(driver).getCurrentPageTitle();
    }
    public void assertWebElementNotDisplayedInCurrentPage(By locator) {
        try {
            driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            Assert.assertTrue(e.getMessage().contains("no such element: Unable to locate element:"));
        }
    }


    public void clickOnBrowserBackButton() {
        driver.navigate().back();

    }


    public List<String> getArrayListOfStringWithCommaSeparated(String fieldNames) {
        List<String> errorIds = new ArrayList<>();
        if (fieldNames.contains(",")) {
            errorIds = Arrays.asList(fieldNames.split(","));
        } else {
            errorIds.add(fieldNames);
        }
        return errorIds;
    }


    private List<String> getIdListOfExpectedChildElements(List<String> elementIds) {
        List<String> ids = new ArrayList<>();
        for (String elementId : elementIds) {
            ids.add(elementId);
        }
        ids.remove(0);
        return ids;
    }

    // navigate helper
    public void navigateTo(String url) {
        driver.navigate().to(url);

    }


    public void mouseOver(String data) {
        log.info("doing mouse over on :" + data);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'" + data + "')]"))).build().perform();
    }

    public void mouseOverElement(WebDriver driver, WebElement element) {
        boolean flag = false;
        try {
            new Actions(driver).moveToElement(element).build().perform();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag) {
                log.info(" MouserOver Action is performed on: " + element.getText());
            } else {
                log.info("MouseOver action is not performed on");
            }
        }
    }


    // Wait for element & click on element
    public void clickOnElement(WebElement element, long durationInSeconds) {
        WebElement webElement = waitForElement(element, durationInSeconds);
        webElement.click();
    }

    // Type text into element
    public void typeTextIntoElement(WebElement element, String textToBeTyped, long durationInSeconds) {
        WebElement webElement = waitForElement(element, durationInSeconds);
        webElement.click();
        webElement.clear();
        webElement.sendKeys(textToBeTyped);
    }

    // Select option in dropdown
    public void selectOptionInDropdown(WebElement element, String dropDownOption, long durationInSeconds) {
        WebElement webElement = waitForElement(element, durationInSeconds);
        Select select = new Select(webElement);
        select.selectByVisibleText(dropDownOption);
    }

    // Alert accept & reject
    public void acceptAlert(long durationInSeconds) {
        Alert alert = waitForAlert(durationInSeconds);
        alert.accept();
    }

    public void dismissAlert(long durationInSeconds) {
        Alert alert = waitForAlert(durationInSeconds);
        alert.dismiss();
    }

    // Mouse hover & click
    public void mouseHoverAndClick(WebElement element, long durationInSeconds) {
        WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().build().perform();
    }

    public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
        WebElement webElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return webElement;
    }

    public WebElement waitForElement(WebElement element, long durationInSeconds) {
        WebElement webElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return webElement;
    }

    public Alert waitForAlert(long durationInSeconds) {
        Alert alert = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            alert = wait.until(ExpectedConditions.alertIsPresent());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return alert;
    }

    // JavaScript Click
    public void javaScriptClick(WebElement element, long durationInSeconds) {
        WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].click();", webElement);
    }

    // JavaScript Type
    public void javaScriptType(WebElement element, long durationInSeconds, String textToBeTyped) {
        WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].value='" + textToBeTyped + "'", webElement);
    }

    // Get text from element
    public String getTextFromElement(WebElement element, long durationInSeconds) {
        WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
        return webElement.getText();
    }

    // Display status of element
    public boolean displayStatusOfElement(WebElement element, long durationInSeconds) {
        try {
            WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
            return webElement.isDisplayed();
        } catch (Throwable e) {
            return false;
        }
    }

    public void clickTermsAndConditionsLink() {

    }
    
    public void assertPolicyPrivacyLinkIsDisplayed() {

    }

    public void clickPrivacyPolicyLink() {

    }

    public void clickOnContinueBtn() {

    }

    public void assertHeadingIsDisplayed() {
    }

    public void assertHeadingErrorIdIsDisplayed() {
    }

    public void clickRadioBtnOption(int i) {
    }

    public void assertRadioButtonsUnchecked() {
    }

    public void assertInputLabel(int i, String s) {
    }
}
