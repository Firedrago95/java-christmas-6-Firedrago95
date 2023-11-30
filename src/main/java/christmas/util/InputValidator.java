package christmas.util;

import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern dateRegex = Pattern.compile("\\d+");

    public static void validateDate(String input) throws IllegalArgumentException {
        validateNullOrEmpty(input);
        validateDateForm(input);
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
