package helper.select;


import helper.database.DataBaseHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;

public class DropDownHelper {

    final Logger log = LogManager.getLogger(DataBaseHelper.class);// for Logger;
    private WebDriver driver;

    public DropDownHelper(WebDriver driver) {
        this.driver = driver;
        /*log.info("DropDownHelper object created..");
        System.out.println("DropDownHelper object created..");*/
    }

    public void selectUsingValue(WebElement element, String value) {
        Select select = new Select(element);
        log.info("selectUsingValue and value is: " + value);
        System.out.println("selectUsingValue and value is: " + value);
        select.selectByValue(value);
    }

    public void selectUsingIndex(WebElement element, int index) {
        Select select = new Select(element);
        log.info("selectUsingIndex and index is: " + index);
        System.out.println("selectUsingIndex and index is: " + index);
        select.selectByIndex(index);
    }

    public void selectUsingVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        log.info("selectUsingVisibleText and visibleText is: " + visibleText);
        System.out.println("selectUsingVisibleText and visibleText is: " + visibleText);
        select.selectByVisibleText(visibleText);
    }

    public void deSelectUsingValue(WebElement element, String value) {
        Select select = new Select(element);
        log.info("deSelectUsingValue and value is: " + value);
        System.out.println("deSelectUsingValue and value is: " + value);
        select.deselectByValue(value);
    }

    public void deSelectUsingIndex(WebElement element, int index) {
        Select select = new Select(element);
        log.info("deSelectUsingIndex and index is: " + index);
        System.out.println("deSelectUsingIndex and index is: " + index);
        select.deselectByIndex(index);
    }

    public void deSelectUsingVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        log.info("deselectByVisibleText and visibleText is: " + visibleText);
        System.out.println("deselectByVisibleText and visibleText is: " + visibleText);
        select.deselectByVisibleText(visibleText);
    }

    public List<String> getAllDropDownData(WebElement element) {
        Select select = new Select(element);
        List<WebElement> elementList = select.getOptions();
        List<String> valueList = new LinkedList<String>();
        for (WebElement ele : elementList) {
            log.info(ele.getText());
            System.out.println(ele.getText());
            valueList.add(ele.getText());
        }
        return valueList;
    }
}
