package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class WebElementFinderUtils {


    public static List<WebElement> findAllChildElementsOfParentElementInActualOrder(WebElement parentWebElement) {
        List<WebElement> childWebElementsInActualOrder = parentWebElement.findElements(By.xpath(".//*"));
        String tagName = childWebElementsInActualOrder.get(childWebElementsInActualOrder.size() - 1).getText();
        return childWebElementsInActualOrder;
    }

}
