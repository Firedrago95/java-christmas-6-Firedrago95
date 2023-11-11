package christmas.Domain;

import java.util.HashMap;
import java.util.Map;

public class Discount {

    public static final int FIRST_DAY = 1;
    public static final int WEEK = 7;
    public static final int THI = 7;
    public static final int FRI = 1;
    public static final int SAT = 2;
    public static final int SUN = 3;
    public static final int CHRISTMAS = 25;
    public static final int WEEKEND_DISCOUNT = 2023;
    public static final int WEEKDAY_DISCOUNT = 2023;
    public static final int SPECIAL_DISCOUNT = 1000;
    public static final int DAILY_INCREASE = 100;
    public static final int DEFAULT_DISCOUNT = 1000;


    public Map<String, Integer> applyDiscount(int visitDay, int dessertCount, int mainCount) {
        Map<String, Integer> appliedDiscount = new HashMap<>();

        calculateChristmasDiscount(visitDay, appliedDiscount);
        calculateWeekendDiscount(visitDay, mainCount, appliedDiscount);
        calculateSpecialDiscount(visitDay, appliedDiscount);
        calculateWeekdayDiscount(visitDay, dessertCount, appliedDiscount);
        return appliedDiscount;
    }

    private void calculateChristmasDiscount(int visitDay, Map<String, Integer> appliedDiscount) {
        if (visitDay >= FIRST_DAY && visitDay <= CHRISTMAS) {
            appliedDiscount.put("크리스마스 디데이 할인",
                ((visitDay - FIRST_DAY) * DAILY_INCREASE) + DEFAULT_DISCOUNT);
        }
    }

    private void calculateWeekendDiscount(int visitDay, int mainCount,
        Map<String, Integer> appliedDiscount) {
        if (getDayOfWeek(visitDay) == FRI || getDayOfWeek(visitDay) == SAT) {
            appliedDiscount.put("주말 할인", WEEKEND_DISCOUNT * mainCount);
        }
    }

    private void calculateSpecialDiscount(int visitDay, Map<String, Integer> appliedDiscount) {
        if (getDayOfWeek(visitDay) == SUN || visitDay == CHRISTMAS) {
            appliedDiscount.put("특별 할인", SPECIAL_DISCOUNT);
        }
    }

    private void calculateWeekdayDiscount(int visitDay, int dessertCount,
        Map<String, Integer> appliedDiscount) {
        if (SUN <= getDayOfWeek(visitDay) && getDayOfWeek(visitDay) <= THI) {
            appliedDiscount.put("평일 할인", WEEKDAY_DISCOUNT * dessertCount);
        }
    }

    private static int getDayOfWeek(int visitDay) {
        return visitDay % WEEK;
    }
}
