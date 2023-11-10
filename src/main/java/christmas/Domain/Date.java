package christmas.Domain;

public class Date {

    public static final String  INVALID_RANGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    public static final int FIRST_DAY = 1;
    public static final int LAST_DAY = 31;
    private final int visitDay;

    public Date(int visitDay) throws IllegalArgumentException{
        validateNumberRange(visitDay);
        this.visitDay = visitDay;
    }

    private void validateNumberRange(int visitDay) throws IllegalArgumentException{
        if (visitDay < FIRST_DAY || visitDay > LAST_DAY) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }

    public int getVisitDay() {
        return visitDay;
    }
}
