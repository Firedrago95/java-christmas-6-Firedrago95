package christmas.util;

import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern dateRegex = Pattern.compile("\\d+");
    private static final Pattern orderRegex = Pattern.compile("[가-힣]+-\\d+(,[가-힣]+-\\d+)*");

    public static void validateDate(String input) throws IllegalArgumentException {
        validateNullOrEmpty(input);
        validateDateForm(input);
    }

    public static void validateOrder(String input) throws IllegalArgumentException {
        validateNullOrEmpty(input);
        validateOrderForm(input);
    }

    private static void validateOrderForm(String input) throws IllegalArgumentException {
        if (!orderRegex.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_FORM.getMessage());
        }
    }

    private static void validateDateForm(String input) throws IllegalArgumentException {
        if (!dateRegex.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_FORM.getMessage());
        }
    }

    private static void validateNullOrEmpty(String input) throws IllegalArgumentException {
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException(ExceptionMessage.NULL_OR_EMPTY.getMessage());
        }
    }


}
