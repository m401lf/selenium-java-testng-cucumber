package pages;

import base.BasePage;
import helper.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductCategoryPage extends BasePage {
    private final Logger log = LogManager.getLogger(ProductCategoryPage.class);
    WebDriver driver;
    By addToCart = By.cssSelector("[title='Add to Cart']");
    @FindBy(xpath = "//*[@id='layered_block_left']/p")
    private WebElement catalogTextObj;
    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[1]/h2")
    private WebElement productAddedSuccessfully;
    @FindBy(css = "a.productcart")
    private List<WebElement> add_To_Cart;
    @FindBy(xpath = "//a[contains(text(),'Check out')]")
    private WebElement proceedToCheckOut;
    @FindBy(xpath = "//*[@id='center_column']/ul/li")
    private WebElement totalProducts;
    @FindBy(css = ".bold.extra.totalamout")
    private WebElement totalTxt;
    @FindBy(css = "div.oneprice")
    private WebElement onePrice;
    @FindBy(css = ".#totals_table td:nth-of-type(2) .totalamout")
    private List<WebElement> totalPriceTxt;
    @FindBy(css = ".pricenew")
    private List<WebElement> price_new;
    @FindBy(css = ".priceold")
    private WebElement price_old;
    @FindBy(css = "select#sort")
    private List<WebElement> sortBy;
    @FindBy(css = ".col-md-3.col-sm-6.col-xs-12")
    private List<WebElement> allProductsList;
    @FindBy(css = "[title='Add to Cart']")
    private List<WebElement> addTo_Cart;
    @FindBy(css = "a.prdocutname")
    private List<WebElement> productNames;
    @FindBy(xpath = "//*[@id='center_column']/ul/li/div/div[2]/div/span[1]")
    private List<WebElement> allPriceElements;
    @FindBy(css = "input#keyword")
    private WebElement searchCriteria;
    @FindBy(css = "select#category_id")
    private WebElement categoriesDropdown;
    @FindBy(css = "/html/body/div/div[2]/div/div/div/div/div[1]/fieldset/div[2]/div/select/option")
    private List<WebElement> categoriesDropdownList;
    @FindBy(css = "input#description")
    private WebElement productDescription;
    @FindBy(css = "input#model")
    private WebElement productModel;
    @FindBy(css = "[title='Search']")
    private WebElement searchBtn;
    @FindBy(css = ".contentpanel > div:nth-of-type(2)")
    private WebElement noSearchResultFound;
    @FindBy(css = ".contentpanel > h4:nth-of-type(2)")
    private WebElement searchResultFound;
    @FindBy(css = "[class='col-md-3 col-sm-6 col-xs-12']")
    private List<WebElement> productsList;
    @FindBy(xpath = "/html/body/div/div/div/div/div/div/div/div/div[1]/div/a")
    private List<WebElement> productnamesList;
    @FindBy(css = "[title='Add to Cart']")
    private List<WebElement> add2CartList;
    @FindBy(css = "i.fa.fa-phone.fa-fw")
    private List<WebElement> call2orderList;
    @FindBy(css = "[class='nostock']")
    private List<WebElement> nostockList;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div/div[3]/div/div[2]/div[3]/div/div")
    private List<WebElement> onepriceList;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div/div[2]/form/select/option")
    private List<WebElement> sortbyDropdownList;
    @FindBy(id = "sort")
    private WebElement sortbyDropdown;
    @FindBy(css = "select#limit")
    private WebElement perPageDropdown;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div/div[5]/form/select/option")
    private List<WebElement> perPageDropdownList;
    public ProductCategoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement searchCriteria() {
        return searchCriteria;

    }

    public void clickOnSearchBtn() {
        waitAndClick(searchBtn);

    }

    public void inputSearchCriteria(String keyword) {
        waitAndSendKeys(searchCriteria, keyword);

    }

    public void clickonCategoriesDropdown() {
        waitAndClick(categoriesDropdown);

    }

    public void clickOnFisrtItemOnCategoriesDropdownList() {
        categoriesDropdownList.get(0).click();

    }

    public void clickOnItemOnCategoriesDropdownList(String textToSearchFor) {
        clickOnTextFromDropdownList(categoriesDropdown, textToSearchFor);

    }

    public List<WebElement> categoriesDropdownList() {
        return categoriesDropdownList;

    }

    public WebElement productDescription() {
        return productDescription;

    }

    public void clickProductDescription() {
        waitAndClick(productDescription);

    }

    public void clickProductModel() {
        waitAndClick(productModel);

    }

    public String getNoSearchResultFoundTxt() {
        return new VerificationHelper(driver).getText(noSearchResultFound);

    }

    public String getSearchResultFoundTxt() {
        return new VerificationHelper(driver).getText(searchResultFound);

    }

    public List<WebElement> allProductsList() {
        return productsList;

    }

    public void clickOnFirstItemOnProductsList() {
        if (!productsList.isEmpty()) {
            productsList.get(1).click();
        }
    }

    public List<WebElement> productnamesList() {
        return productnamesList;

    }

    public List<WebElement> add2CartList() {
        return add2CartList;

    }

    public List<WebElement> call2orderList() {
        return call2orderList;

    }

    public List<WebElement> nostockList() {
        return nostockList;

    }

    public List<WebElement> onepriceList() {
        return onepriceList;

    }

    public List<WebElement> sortbyDropdownList() {
        return sortbyDropdownList;

    }

    public void clickOnSortbyDropdown() {
        sortbyDropdown.click();
    }

    public void clickPerPageDropdown() {
        perPageDropdown.click();
    }

    public List<WebElement> perPageDropdownList() {
        return perPageDropdownList;

    }

    public void mouseOverOnProduct(int number) {
        // /html/body/div/div[1]/div[1]/section/nav/ul/li[4]/a
        String fPart = "/html/body/div/div[1]/div[1]/section/nav/ul/li[";
        String sPart = "]/a";
        Actions action = new Actions(driver);
        log.info("doing mouse over on: " + number + "..product");
        action.moveToElement(driver.findElement(By.xpath(fPart + number + sPart))).build().perform();
    }

    public List<WebElement> getProductList() {
        return allProductsList;

    }

    public WebElement getProductByName(String productName) {
        return getProductList()
                .stream()
                .filter(product -> product.findElement(By.cssSelector("a.prdocutname")).getText()
                        .equals(productName))
                .findFirst()
                .orElse(null);
    }

    public void addProductToCart(String productName) {
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCart).click();
    }

    public WebElement getCatalogTextObj() {
        return catalogTextObj;

    }

    public WebElement getProductAddedSuccessfully() {
        return productAddedSuccessfully;

    }

    public List<WebElement> getAddToCart() {
        return add_To_Cart;

    }

    public WebElement getProceedToCheckOut() {
        return proceedToCheckOut;

    }

    public WebElement getTotalProducts() {
        return totalProducts;

    }

    public WebElement getTotalTxt() {
        return totalTxt;

    }

    public List<WebElement> getTotalPriceTxt() {
        return totalPriceTxt;

    }

    public List<WebElement> getPrice_new() {
        return price_new;

    }

    public WebElement getPrice_old() {
        return price_old;

    }

    public List<WebElement> getSortBy() {
        return sortBy;

    }

    public List<WebElement> productsList() {
        return allProductsList;

    }

    public List<WebElement> getAdd2Cart() {
        return add_To_Cart;

    }

    public List<WebElement> getProductNames() {
        return productNames;

    }

    public List<WebElement> getAllPriceElements() {
        return allPriceElements;

    }

    public void clickOnAddToCart() {
        log.info("clicking on add to cart");
        driver.findElement(addToCart).click();
    }

    public void clickOnProceedTCheckOut() {
        log.info("clicking on :" + proceedToCheckOut.getText());
        proceedToCheckOut.click();
    }

    public void selectColor(String data) {
        assert driver != null;
        //new JavaScriptHelper(driver.scrollIntoView(driver.findElement(By.xpath("//a[contains(text(),'"+testData.data+"')]/parent::*/preceding-sibling::input[1]")));
        driver.findElement(
                        By.xpath("//a[contains(text(),'" + data + "')]/parent::*/preceding-sibling::input[1]"))
                .click();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectSmallSize() {
        log.info("selecting small size..");
        driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_1']")).click();
    }

    public void selectMediumSize() {
        log.info("selecting Medium size..");
        try {
            boolean selected = driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_2']"))
                    .isSelected();
            if (!selected) {
                driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_2']")).click();
                log.info("checkbox is checked..");
            }
        } catch (Exception e) {
            log.info("checkbox was already checked..");
        }
    }

    public void selectLSize() {
        log.info("selecting Large size..");
        try {
            boolean selected = driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_3']"))
                    .isSelected();
            if (!selected) {
                driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_3']")).click();
                log.info("checkbox is checked..");
            }
        } catch (Exception e) {
            log.info("checkbox was already checked..");
        }
    }

    public void selectFirstProduct() {
        Actions obj = new Actions(driver);
        log.info("performing mouse over on first product of page..");
        //obj.moveToElement(totalProducts.get(0)).build().perform();
        log.info("clicking on add to basket..");
        driver.findElement(addToCart).click();
    }

    public boolean verifyArrayHasAscendingData(ArrayList<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            // this condition will check all next price should be smaller than previous one.
            // next price can be grater and equal
            if (array.get(i) <= array.get(i + 1)) {
                log.info("obj.get(i).." + array.get(i));
                log.info("obj.get(i+1).." + array.get(i + 1));
            } else {
                log.info("is not working");
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> getPriceMassagedData(Iterator<WebElement> itr) {
        ArrayList<Integer> array = new ArrayList<>();
        while (itr.hasNext()) {
            String p = itr.next().getText();
            if (p.contains("$")) {
                String actualData = p.substring(1);
                log.info(actualData);
                double p1 = Double.parseDouble(actualData);
                int productPrice = (int) (p1);
                array.add(productPrice);
            }
        }
        return array;
    }
}
