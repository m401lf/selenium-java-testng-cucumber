package helper.action;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CheckBoxUtils {

    public static void assertCheckBoxIsTickedByDefaults(List<WebElement> checkBoxesList) {
        Assert.assertFalse(checkBoxesList.get(0).isSelected());

    }
}

