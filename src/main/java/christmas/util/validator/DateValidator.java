package christmas.util.validator;

import christmas.util.ExceptionMessage;

public class DateValidator {

    public static void validate(int visitDate) throws IllegalArgumentException{
        validateNumberRange(visitDate);
    }

    private static void validateNumberRange(int visitDate) throws IllegalArgumentException {
        if (visitDate < 1 || visitDate > 31) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DATE.getMessage());
        }
    }
}
