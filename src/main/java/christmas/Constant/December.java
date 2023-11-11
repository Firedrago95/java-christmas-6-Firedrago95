package christmas.Constant;

public enum December {
    FIRST_DAY(1),
    CHRISTMAS(25),
    LAST_DAY(31),
    SUNDAY(3),
    THURSDAY(7),
    FRIDAY(1),
    SATURDAY(2),
    WEEK_DAYS(7);

    private final int day;

    December(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }
}
