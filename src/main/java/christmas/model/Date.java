package christmas.model;

import christmas.util.ExceptionMessage;
import christmas.util.validator.DateValidator;

public class Date {

    private final int visitDate;

    public Date(int visitDate) throws IllegalArgumentException {
        DateValidator.validate(visitDate);
        this.visitDate = visitDate;
    }

}
