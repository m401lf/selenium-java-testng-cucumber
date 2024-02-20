package helper.action;

import org.openqa.selenium.WebElement;

public class FieldInputUtils {

    public static void inputFieldValueBasedOnValueType(String valueType, int numberOfChars, WebElement element,
                                                       String caseType) {
        if (element != null) {
            element.clear();
            if (valueType.equals("Number")) {
                element.sendKeys(NumberGeneratorUtils.generateNumberWithLength(numberOfChars));
            } else if (valueType.equals("String")) {
                element.sendKeys(TextGeneratorUtils.generateStringWithLengthAndCase(numberOfChars, caseType));
            } else if (valueType.equals("Numeric Email")) {
                element.sendKeys(EmailGeneratorUtils.generateEmailWithNumbersAndLength(numberOfChars));
            } else if (valueType.equals("Textual Email")) {
                element.sendKeys(
                        EmailGeneratorUtils.generateEmailWithTextAndLengthLessThanFiveChars(numberOfChars, caseType));
            } else if (valueType.equals("Textual Email with < 5 chars")) {
                element.sendKeys(
                        EmailGeneratorUtils.generateEmailWithTextAndLengthLessThanFiveChars(numberOfChars, caseType));
            } else if (valueType.equals("Numeric Email with < 5 chars")) {
                element.sendKeys(EmailGeneratorUtils.generateEmailWithNumbersAndLengthLessThanFiveChars(numberOfChars));
            }
        }
    }
}
