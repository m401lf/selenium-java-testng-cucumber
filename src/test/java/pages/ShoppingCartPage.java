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

public class ShoppingCartPage extends BasePage {

    final static Logger log = LogManager.getLogger(ShoppingCartPage.class);
    WebDriver driver;
    @FindBy(css = "div#content > h1") // MyAccount BasePage heading
    WebElement headerTxt;
    @FindBy(css = "div#content > p")
    WebElement emptyShoppingCartMsg;
    @FindBy(css = ".table-responsive .img-thumbnail")
    WebElement productImage;
    @FindBy(css = "div#content > p")
    WebElement productName;
    @FindBy(xpath = "//*[@id='content']/form/div/table/tbody/tr/td[3]")
    WebElement productModel;
    @FindBy(css = "input[value='1']")
    WebElement quantityBox;
    @FindBy(css = ".fa.fa-refresh")
    WebElement quantityRefresh;
    @FindBy(css = ".fa.fa-times-circle")
    WebElement quantityRemoveItem;
    @FindBy(xpath = "//*[@id='content']/form/div/table/tbody/tr/td[6]")
    WebElement totalPrice;
    @FindBy(xpath = "//h2[normalize-space()='What would you like to do next?']")
    WebElement unitPrice;
    @FindBy(xpath = "//*[@id='content']/form/div/table/tbody/tr/td[5]")
    WebElement WhatWouldYouLikeToDoNextTxt;
    @FindBy(css = ".accordion-toggle.collapsed[href='#collapse-coupon']")
    WebElement accordionUseCouponCode;
    @FindBy(css = "#input-coupon")
    WebElement couponCode;
    @FindBy(css = "#button-coupon")
    WebElement applyCouponBtn;
    @FindBy(css = ".accordion-toggle.collapsed")
    WebElement accordionUseGiftCertificate;
    @FindBy(css = "#input-voucher")
    WebElement giftCertificatevoucher;
    @FindBy(css = "#button-voucher")
    WebElement applyGiftCertificateBtn;
    @FindBy(css = ".text-right")
    WebElement totalP;
    @FindBy(xpath = "//*[@id='content']/div[2]/div/table/tbody/tr[4]/td[2]")
    WebElement total;
    @FindBy(xpath = "//*[@id='content']/div[2]/div/table/tbody/tr[1]/td[2]")
    WebElement subTotal;
    @FindBy(xpath = "//*[@id='content']/div[2]/div/table/tbody/tr[2]/td[2]")
    WebElement ecoTaxPrice;
    @FindBy(xpath = "//*[@id='content']/div[2]/div/table/tbody/tr[3]/td[2]")
    WebElement vatPrice;
    @FindBy(css = "[css] .btn-default")
    WebElement continueShippingBtn;
    @FindBy(css = "#content div:nth-child(8) .btn-primary")
    WebElement checkoutBtn;
    @FindBy(xpath = "//*[@id='checkout-cart']/ul/li[2]/a")
    WebElement subMenuMenuShoppinCartArrow;
    @FindBy(css = "a.accordion-toggle")
    WebElement accordionEstimateShippingTaxes;
    @FindBy(id = "input-country")
    WebElement accordionEstimateShippingTaxesDropdown;
    @FindBy(id = "input-zone")
    WebElement accordionEstimateShippingTaxesRegionOrState;
    @FindBy(id = "input-postcode")
    WebElement accordionEstimateShippingTaxesPostCode;
    @FindBy(id = "button-quote")
    WebElement accordionEstimateShippingTaxesGetQuotesBtn;
    //@FindBy(xpath="//button[@aria-expanded='false']")
    @FindBy(xpath = "//div[@id='cart']")
    WebElement btnItems;
    @FindBy(xpath = "//strong[normalize-space()='View Cart']")
    WebElement lnkViewCart;
    @FindBy(xpath = "//*[@id='content']/div[2]/div/table//strong[text()='Total:']//following::td")
    WebElement lblTotalPrice;  //$246.40
    @FindBy(xpath = "//a[text()='Checkout']")
    WebElement btnCheckout;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickItemsToNavigateToCart() {
        btnItems.click();

    }

    public void clickViewCart() {
        lnkViewCart.click();

    }

    public String getTotalPrice() {
        return lblTotalPrice.getText();

    }

    public void clickOnCheckout() {
        btnCheckout.click();

    }

    public boolean assertHeader() {
        return new VerificationHelper(driver).isDisplayed(headerTxt);

    }

    public String getHeaderTxt() {
        return new VerificationHelper(driver).getText(headerTxt);

    }

    public String getEmptyShoppingCartMsg() {
        return new VerificationHelper(driver).getText(emptyShoppingCartMsg);

    }

    public boolean assertEmptyShoppingCartMsg() {
        return new VerificationHelper(driver).isDisplayed(emptyShoppingCartMsg);

    }


    public boolean assertProductImage() {
        return new VerificationHelper(driver).isDisplayed(productImage);

    }

    public boolean assertProductName() {
        return new VerificationHelper(driver).isDisplayed(productName);

    }

    public String getProductNameTxt() {
        return new VerificationHelper(driver).getText(productName);

    }

    public String getProductModel() {
        return new VerificationHelper(driver).getText(productModel);

    }

    public boolean assertProductModel() {
        return new VerificationHelper(driver).isDisplayed(productModel);

    }

    public void inputQuantity(String num) {
        quantityBox.sendKeys(num);

    }

    public boolean assertQuantityBoxEnabled() {
        return new VerificationHelper(driver).isEnabled(quantityBox);

    }

    public void clickQuantityRefresh() {
        quantityRefresh.click();

    }

    public void clickQuantityRemoveItemBtn() {
        quantityRemoveItem.click();

    }

    public String getTotalPriceTxt() {
        return new VerificationHelper(driver).getText(totalPrice);

    }

    public String getUnitPriceTxt() {
        return new VerificationHelper(driver).getText(unitPrice);

    }

    public boolean assertWhatWouldYouLikeToDoNextTxt() {
        return new VerificationHelper(driver).isDisplayed(WhatWouldYouLikeToDoNextTxt);

    }

    public void clickAccordionUseCouponCode() {
        accordionUseCouponCode.click();

    }

    public void inputCouponCode(String coupon) {
        couponCode.clear();
        couponCode.sendKeys(coupon);

    }

    public void clickApplyCouponBtn() {
        applyCouponBtn.click();

    }

    public void clickAccordionUseGiftCertificate() {
        accordionUseGiftCertificate.click();

    }

    public void inputGiftCertificatevoucher(String certificatevoucher) {
        giftCertificatevoucher.clear();
        giftCertificatevoucher.sendKeys(certificatevoucher);

    }

    public void clickApplyGiftCertificateBtn() {
        applyGiftCertificateBtn.click();

    }

    public WebElement getTotalP() {
        return totalP;

    }

    public WebElement getTotal() {
        return total;

    }

    public WebElement getSubTotal() {
        return subTotal;

    }

    public WebElement getEcoTaxPrice() {
        return ecoTaxPrice;

    }

    public WebElement getVatPrice() {
        return vatPrice;

    }

    public IndexPage getContinueShippingBtn() throws IOException {
        continueShippingBtn.click();
        return new IndexPage(driver);

    }

    public CheckoutcheckoutPage clickCheckoutBtn() {
        checkoutBtn.click();
        return new CheckoutcheckoutPage(driver);

    }

    public boolean assertCheckoutBtn() {
        return new VerificationHelper(driver).isDisplayed(checkoutBtn);

    }

    public WebElement getSubMenuMenuShoppinCartArrow() {
        return subMenuMenuShoppinCartArrow;

    }

    public WebElement getAccordionEstimateShippingTaxes() {
        return accordionEstimateShippingTaxes;

    }

    public WebElement getAccordionEstimateShippingTaxesDropdown() {
        return accordionEstimateShippingTaxesDropdown;

    }

    public WebElement getAccordionEstimateShippingTaxesRegionOrState() {
        return accordionEstimateShippingTaxesRegionOrState;

    }

    public WebElement getAccordionEstimateShippingTaxesPostCode() {
        return accordionEstimateShippingTaxesPostCode;

    }

    public WebElement getAccordionEstimateShippingTaxesGetQuotesBtn() {
        return accordionEstimateShippingTaxesGetQuotesBtn;

    }


}
