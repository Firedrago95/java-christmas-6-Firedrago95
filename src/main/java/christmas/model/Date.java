package christmas.model;

import christmas.util.ExceptionMessage;

public class Date {

    private final int visitDate;

    public Date(int visitDate) throws IllegalArgumentException {
        validateNumberRange(visitDate);
        this.visitDate = visitDate;
    }

    private void validateNumberRange(int visitDate) throws IllegalArgumentException {
        if (visitDate < 1 || visitDate > 31) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DATE.getMessage());
        }
    }

}
