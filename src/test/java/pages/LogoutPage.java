package pages;

import base.BasePage;
import helper.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LogoutPage extends BasePage {
    private final Logger log = LogManager.getLogger(LogoutPage.class);
    WebDriver driver;

    public LogoutPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "Continue")
    WebElement accountLogoutContinueBtn;
    @FindBy(css = "div[id='content'] h1")
    WebElement accountLogoutTxt;
    @FindBy(css = "a.btn.btn-primary") // logoutPage, loginPage, accountSuccessPage
    private WebElement continueBtn;




    public String getAccountLogoutTxt() {
        return new VerificationHelper(driver).getText(accountLogoutTxt);

    }

    public boolean assertContinueButtonIsEnabledAndDisplayed() {
        return new VerificationHelper(driver).assertElementEnabledAndDisplayed(continueBtn);
    }

    public String getContinueButton() {
        return new VerificationHelper(driver).getText(continueBtn);
    }
}
