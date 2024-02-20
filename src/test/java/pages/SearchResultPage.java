package pages;

import base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.utils.GlobalVars;

import java.util.List;


public class SearchResultPage extends BasePage {

    private final Logger log = LogManager.getLogger(SearchResultPage.class);
    WebDriver driver;
    @FindBy(css = "select[name='category_id']")
    List<WebElement> allcategoryDropdownList;
    @FindBy(css = "input[value='1'][name='sub_category']")
    List<WebElement> searchInSubcategoriesCheckBox;
    @FindBy(id = "button-search")
    List<WebElement> searchResultButton;
    @FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
    WebElement ResultSearchHeader;
    @FindBy(css = "div.product-thumb")
    List<WebElement> resultSearchProductDisplayedList;
    @FindBy(css = "i[class='fa fa-shopping-cart']")
    List<WebElement> addToCartList;
    @FindBy(css = "i.fa.fa-heart")
    List<WebElement> addToWishList;
    @FindBy(css = "i.fa-exchange")
    List<WebElement> addToExchangeList;
    @FindBy(css = ".col-sm-6.text-right")
    WebElement showingResultPagnation;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[3]/div/div/div/div/h4/a")
    List<WebElement> productNamesDisplayList;
    @FindBy(css = "p.price")
    List<WebElement> priceList;
    @FindBy(css = "#input-sort")
    WebElement sortByBox;
    @FindBy(css = "/html/body/div[2]/div/div/div[2]/div[3]/div/select/option")
    WebElement sortByDropdownList;
    @FindBy(css = "#input-limit")
    WebElement showLimitBox;
    @FindBy(css = "#input-limit")
    WebElement ListViewButton;
    @FindBy(css = "#grid-view")
    WebElement gridViewButton;
    @FindBy(linkText = "HP LP3065")
    private WebElement validHPProduct;
    @FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
    private WebElement messageText;
    @FindBy(css = "#input-search")
    private WebElement searchCriteriaBox;
    @FindBy(css = "#description")
    private WebElement searchCriteriadescriptionRadioBox;
    @FindBy(css = "#description")
    private WebElement searchCriteriaButton;
    @FindBy(css = "select[name='category_id']")
    private WebElement allcategoryButton;

    @FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
    private WebElement warningMsg;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean displayStatusOfValidProduct() {
        return displayStatusOfElement(validHPProduct, GlobalVars.EXPLICIT_WAIT_BASIC_TIME);

    }

    public String getMessageText() {
        return getTextFromElement(messageText, GlobalVars.EXPLICIT_WAIT_BASIC_TIME);

    }

    public boolean verifyValidHPProductStatus() {
        return displayStatusOfElement(validHPProduct, GlobalVars.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String getNoMatchWarningMsg() {
        return getTextFromElement(warningMsg, GlobalVars.EXPLICIT_WAIT_BASIC_TIME);
    }

    public WebElement getValidHPProduct() {
        return validHPProduct;
    }

    public WebElement getSearchCriteriaBox() {
        return searchCriteriaBox;
    }

    public WebElement getSearchCriteriadescriptionRadioBox() {
        return searchCriteriadescriptionRadioBox;
    }

    public WebElement getSearchCriteriaButton() {
        return searchCriteriaButton;
    }

    public WebElement getAllcategoryButton() {
        return allcategoryButton;
    }

    public List<WebElement> getAllcategoryDropdownList() {
        return allcategoryDropdownList;
    }

    public List<WebElement> getSearchInSubcategoriesCheckBox() {
        return searchInSubcategoriesCheckBox;
    }

    public List<WebElement> getSearchResultButton() {
        return searchResultButton;
    }

    public WebElement getResultSearchHeader() {
        return ResultSearchHeader;
    }

    public List<WebElement> getResultSearchProductDisplayedList() {
        return resultSearchProductDisplayedList;
    }

    public List<WebElement> getAddToCartList() {
        return addToCartList;
    }

    public List<WebElement> getAddToWishList() {
        return addToWishList;
    }

    public List<WebElement> getAddToExchangeList() {
        return addToExchangeList;
    }

    public WebElement getShowingResultPagnation() {
        return showingResultPagnation;
    }

    public List<WebElement> getProductNamesDisplayList() {
        return productNamesDisplayList;
    }

    public List<WebElement> getPriceList() {
        return priceList;
    }

    public WebElement getSortByBox() {
        return sortByBox;
    }

    public WebElement getSortByDropdownList() {
        return sortByDropdownList;
    }

    public WebElement getShowLimitBox() {
        return showLimitBox;
    }

    public WebElement getListViewButton() {
        return ListViewButton;
    }

    public WebElement getGridViewButton() {
        return gridViewButton;
    }

}
