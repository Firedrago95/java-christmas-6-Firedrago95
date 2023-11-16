package christmas.Domain;

import christmas.Constant.December;

public class Date {

    public static final String INVALID_RANGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    private final int visitDay;

    public Date(int visitDay) throws IllegalArgumentException {
        validateNumberRange(visitDay);
        this.visitDay = visitDay;
    }

    private void validateNumberRange(int visitDay) throws IllegalArgumentException {
        if (visitDay < December.FIRST_DAY.getDay() || visitDay > December.LAST_DAY.getDay()) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }

    public int getVisitDay() {
        return visitDay;
    }
}
