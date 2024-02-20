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
import utilities.utils.GlobalVars;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class AccountPage extends BasePage {
    WebDriver driver;
    EditPage editPage;
    private final Logger log = LogManager.getLogger(AccountPage.class);

    public AccountPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(linkText = "Edit your account information")
    private WebElement EditYourAccountInformationOption;
    @FindBy(xpath = "//a[normalize-space()='Edit your account information']")
    WebElement editAccountInformationLink;
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement logoutSideWidgetAccountLink;
    @FindBy(css = "a.list-group-item")
    List<WebElement> aSideWidgetAccountLinks;
    @FindBy(xpath = "//h2[text()='My Account']") // MyAccount Page heading
    WebElement msgHeading;
    @FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
    WebElement lnkLogout;
    @FindBy(linkText = "Edit your account information")
    private WebElement editYourAccountInformationOption;
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    private WebElement myAccount;
    @FindBy(css = "a.fa.fa-user")
    private WebElement userProfileIcon;
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    private WebElement myAccountTopMenuTxt;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement successYourAccountSuccessfullyUpdatedTxt;
    @FindBy(linkText = "My Orders")
    private WebElement myOrderTxt;
    @FindBy(xpath = "/html/body/main/div/div/div/ul/li/a")
    private List<WebElement> allSubLinks;


    public boolean isMyAccountPageExists()   // MyAccount Page heading display status
    {
        try {
            return (msgHeading.isDisplayed());
        } catch (Exception e) {
            return (false);
        }
    }

    // MyAccount Page heading display status
    public boolean assertMyAccountPageExists() {
        return new VerificationHelper(driver).assertElementEnabledAndDisplayed(msgHeading);
    }
    public String getMyAccountText() {
        return new VerificationHelper(driver).getText(msgHeading);
    }

    public String getEditAccountDetailsText() {
        return new VerificationHelper(driver).getText(editAccountInformationLink);
    }

    public boolean displayStatusOfEditYourAccountInformationOption() {
        return displayStatusOfElement(EditYourAccountInformationOption,
                GlobalVars.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickLogout() {
        lnkLogout.click();

    }

    public boolean assertMyAccountTxtIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(myAccount);
    }

    public boolean assertUserProfileIconDisplayed() {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
        return new VerificationHelper(driver).isDisplayed(userProfileIcon);

    }

    public String getSuccessYourAccountSuccessfullyUpdatedTxt() {
        return new VerificationHelper(driver).getText(successYourAccountSuccessfullyUpdatedTxt);

    }

    public boolean assertSuccessYourAccountSuccessfullyUpdatedTxtIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(successYourAccountSuccessfullyUpdatedTxt);

    }

    public String getMyAccountTxt() {
        return new VerificationHelper(driver).getText(myAccount);

    }

    public String getMyOrderTxt() {
        return new VerificationHelper(driver).getText(myOrderTxt);

    }

    public boolean assertMyOrderTxtDisplayed() {
        return new VerificationHelper(driver).isDisplayed(myOrderTxt);

    }

    public LogoutPage clickMatchingItemFromAsideWidget(String item) throws IOException {
        driver.findElement(By.xpath("//aside[#'column-right']/?/?/a[@innertext='" + item + "']"))
                .click();
        return new LogoutPage(driver);
    }


    public boolean assertAllSubHeadingLinksDisplayed() {
        return new VerificationHelper(driver).isDisplayed((WebElement) allSubLinks);

    }

    public boolean getDisplayStatusOfEditYourAccountInformationOption() {
        return editYourAccountInformationOption.isDisplayed();
    }

    public boolean assertEditYourAccountInformationOptionDisplayed() {
        return new VerificationHelper(driver).isDisplayed(editYourAccountInformationOption);
    }

}
