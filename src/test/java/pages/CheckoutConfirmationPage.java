package pages;

import base.BasePage;
import helper.assertion.VerificationHelper;
import helper.select.DropDownHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CheckoutConfirmationPage extends BasePage {

    final static Logger log = LogManager.getLogger(CheckoutConfirmationPage.class);
    WebDriver driver;
    LoginPage loginPage;
    @FindBy(css = "div#content > h1")
    WebElement header;
    @FindBy(linkText = "Step 2: Billing Details")
    WebElement billingDetails;
    //========Step 2: Billing Details =============//
    @FindBy(id = "input-payment-firstname")
    WebElement paymentFirstname;
    @FindBy(id = "input-payment-lastname")
    WebElement paymentLastname;
    @FindBy(id = "input-payment-company")
    WebElement paymentCompany;
    @FindBy(id = "input-payment-address-1")
    WebElement paymentAddress1;
    @FindBy(id = "input-payment-address-2")
    WebElement paymentAddress2;
    @FindBy(id = "input-payment-city")
    WebElement paymentCity;
    @FindBy(id = "input-payment-postcode")
    WebElement paymentPostcode;
    @FindBy(id = "input-payment-country")
    WebElement paymentCountryDropdown;
    @FindBy(id = "input-payment-zone")
    WebElement paymentZoneDropdown;
    @FindBy(id = "button-payment-address")
    WebElement paymentAddressBtn;
    @FindBy(linkText = "Step 3: Delivery Details")
    WebElement deliveryDetails;
    //========Step 3: Delivery Details=============//
    @FindBy(css = "#accordion .panel-default:nth-of-type(3) .radio:nth-of-type(1) [type]")
    WebElement useExistingAddressRadioBtn;
    @FindBy(css = "div#shipping-existing > select[name='address_id']")
    WebElement selectedAddress;
    @FindBy(xpath = "//*[@id='collapse-shipping-address']/div/form/div[3]/label/input")
    WebElement useNewShippingAddress;
    @FindBy(id = "input-shipping-firstname")
    WebElement shippingfirstname;
    @FindBy(id = "input-shipping-lastname")
    WebElement shippinglastname;
    @FindBy(id = "input-shipping-company")
    WebElement shippingcompany;
    @FindBy(id = "input-shipping-address-1")
    WebElement shippingaddress1;
    @FindBy(id = "input-shipping-address-2")
    WebElement shippingaddress2;
    @FindBy(id = "input-shipping-city")
    WebElement shippingcity;
    @FindBy(id = "input-shipping-postcode")
    WebElement shippingpostcode;
    @FindBy(id = "input-shipping-country")
    WebElement shippingcountryDropdown;
    @FindBy(id = "input-shipping-zone")
    WebElement shippingzoneDropdown;
    @FindBy(id = "button-shipping-address")
    WebElement shippingaddressBtn;
    @FindBy(css = "input[name='shipping_method']")
    WebElement flatShippingRateRadioBtn;
    //========Step 4: Delivery Method=============//
    @FindBy(id = "textarea[name='comment']")
    WebElement addCommentToOrderBox;
    @FindBy(id = "button-shipping-method")
    WebElement shippingmethodBtn;
    @FindBy(id = "input[name='agree']")
    WebElement agreeRadioBtn;
    @FindBy(linkText = "Step 6: Confirm Order")
    WebElement confirmOrder;
    @FindBy(id = "button-confirm")
    WebElement confirmOrderBtn;

    public CheckoutConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickBillingDetails() {
        billingDetails.click();

    }

    public void inputPaymentFirstname(String firstname) {
        paymentFirstname.sendKeys(firstname);

    }

    public void inputPaymentLastname(String lastname) {
        paymentLastname.sendKeys(lastname);

    }

    public void inputPaymentCompany(String coy) {
        paymentCompany.sendKeys(coy);

    }

    public void inputPaymentAddress1(String addr1) {
        paymentAddress1.sendKeys(addr1);

    }

    public void inputPaymentAddress2(String addr2) {
        paymentAddress2.sendKeys(addr2);

    }

    public void inputPaymentCity(String city) {
        paymentCity.sendKeys(city);

    }

    public void inputPaymentPostcode(String postcode) {
        paymentPostcode.sendKeys(postcode);

    }

    public void selectPaymentCountryDropdown(String country) {
        new DropDownHelper(driver).selectUsingVisibleText(paymentCountryDropdown, country);
    }

    public void getPaymentZoneDropdown(String zone) {
        new DropDownHelper(driver).selectUsingVisibleText(paymentZoneDropdown, zone);

    }

    public void clickPaymentAddressBtn() {
        paymentAddressBtn.click();

    }

    public boolean assertDeliveryDetails() {
        return new VerificationHelper(driver).isDisplayed(deliveryDetails);

    }

    public void clickDeliveryDetails() {
        deliveryDetails.click();

    }

    public void clickToUseExistingAddressRadioBtn() {
        useExistingAddressRadioBtn.click();

    }

    public boolean assertSelectedAddressSelected() {
        return new VerificationHelper(driver).isSelected(selectedAddress);

    }

    public WebElement getUseNewShippingAddress() {
        return useNewShippingAddress;

    }

    public void inputShippingfirstname(String firstname) {
        shippingfirstname.sendKeys(firstname);

    }

    public void inputShippinglastname(String lastname) {
        shippinglastname.sendKeys(lastname);

    }

    public void inputShippingcompany(String coyname) {
        shippingcompany.sendKeys(coyname);

    }

    public void inputShippingaddress1(String addr1) {
        shippingaddress1.sendKeys(addr1);

    }

    public void inputShippingaddress2(String addr2) {
        shippingaddress2.sendKeys(addr2);

    }

    public void inputShippingCity(String city) {
        shippingcity.clear();
        shippingcity.sendKeys(city);
    }

    public void getShippingPostcode(String postCode) {
        shippingpostcode.clear();
        shippingpostcode.sendKeys(postCode);
    }

    public void selectShippingCountryDropdown(String country) {
        new DropDownHelper(driver).selectUsingVisibleText(shippingcountryDropdown, country);

    }

    public void selectShippingZoneDropdown(String regionOrState) {
        new DropDownHelper(driver).selectUsingVisibleText(shippingzoneDropdown, regionOrState);

    }

    public void clickShippingAddressBtn() {
        shippingaddressBtn.clear();
        shippingaddressBtn.click();
    }

    public boolean assertFlatShippingRateRadioBtnSelected() {
        return new VerificationHelper(driver).isSelected(flatShippingRateRadioBtn);

    }

    public void inputAddCommentToOrderBox(String comment) {
        addCommentToOrderBox.clear();
        addCommentToOrderBox.sendKeys(comment);
    }

    public void clickShippingmethodBtn() {
        shippingmethodBtn.click();

    }

    public void clickAgreeRadioBtn() {
        agreeRadioBtn.click();

    }

    public boolean assertConfirmOrder() {
        return new VerificationHelper(driver).isDisplayed(confirmOrder);

    }

    public CheckoutSuccessPage clickConfirmOrder() throws IOException {
        confirmOrder.click();
        return new CheckoutSuccessPage(driver);
    }

    public WebElement getConfirmOrderBtn() {
        return confirmOrderBtn;

    }


}


