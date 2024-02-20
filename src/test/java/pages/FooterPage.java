package pages;

import base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FooterPage extends BasePage {
    private final Logger log = LogManager.getLogger(FooterPage.class);
    WebDriver driver;
    @FindBy(css = "/html/body/footer/div/div/div/h5")
    List<WebElement> footerHeadersList;

    @FindBy(xpath = "/html/body/footer/div/div/div[1]/ul/li/a")
    List<WebElement> informationDropdownList;

    @FindBy(xpath = "/html/body/footer/div/div/div[2]/ul/li/a")
    List<WebElement> customerServiceDropdownList;

    @FindBy(xpath = "/html/body/footer/div/div/div[3]/ul/li/a")
    List<WebElement> extrasDropdownList;

    @FindBy(xpath = "/html/body/footer/div/div/div[4]/ul/li/a")
    List<WebElement> myAccountDropdownList;

    @FindBy(xpath = "body footer div[class='container'] p")
    WebElement poweredByOpenCart;


    public FooterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnFooterHeaderTextName(String textName) {
        List<WebElement> textNames = footerHeadersList;
        for (WebElement c : textNames) {
            String text = c.getText().trim();
            if (text.equals(textName)) {
                log.info("selecting date as: " + textName);
                c.click();
                break;
            }
        }
    }

    public List<WebElement> getFooterHeadersList() {
        return footerHeadersList;
    }

    public List<WebElement> getInformationDropdownList() {
        return informationDropdownList;
    }

    public List<WebElement> getCustomerServiceDropdownList() {
        return customerServiceDropdownList;
    }

    public List<WebElement> getExtrasDropdownList() {
        return extrasDropdownList;
    }

    public List<WebElement> getMyAccountDropdownList() {
        return myAccountDropdownList;
    }

    public WebElement getPoweredByOpenCart() {
        return poweredByOpenCart;
    }

}
