package helper.action;

public class EmailGeneratorUtils {

    // -5 is here to take into account @ and .com
    public static String generateEmailWithNumbersAndLength(int numberOfChars) {
        StringBuilder email = new StringBuilder();
        return email.append(NumberGeneratorUtils.generateNumberWithLength(numberOfChars / 2)).append("@")
                .append(NumberGeneratorUtils.generateNumberWithLength((numberOfChars / 2) - 5)).append(".com")
                .toString();
    }

    public static String generateEmailWithTextAndLength(int numberOfChars, String caseType) {
        StringBuilder email = new StringBuilder();
        return email.append(TextGeneratorUtils.generateStringWithLengthAndCase(numberOfChars / 2, caseType)).append("@")
                .append(TextGeneratorUtils.generateStringWithLengthAndCase((numberOfChars / 2) - 5, caseType))
                .append(".com").toString();
    }

    public static String generateEmailWithTextAndLengthLessThanFiveChars(int numberOfChars, String caseType) {
        StringBuilder email = new StringBuilder();
        return email.append(TextGeneratorUtils.generateStringWithLengthAndCase(numberOfChars / 2, caseType)).append("@")
                .append(TextGeneratorUtils.generateStringWithLengthAndCase(numberOfChars / 2, caseType)).toString();
    }

    public static String generateEmailWithNumbersAndLengthLessThanFiveChars(int numberOfChars) {
        StringBuilder email = new StringBuilder();
        return email.append(NumberGeneratorUtils.generateNumberWithLength(numberOfChars / 2)).append("@")
                .append(NumberGeneratorUtils.generateNumberWithLength((numberOfChars / 2))).toString();
    }

}
