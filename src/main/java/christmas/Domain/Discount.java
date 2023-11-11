package christmas.Domain;

import christmas.Constant.December;
import java.util.HashMap;
import java.util.Map;

public class Discount {

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
        if (visitDay >= December.FIRST_DAY.getDay() && visitDay <= December.CHRISTMAS.getDay()) {
            appliedDiscount.put("크리스마스 디데이 할인",
                ((visitDay - December.FIRST_DAY.getDay()) * DAILY_INCREASE) + DEFAULT_DISCOUNT);
        }
    }

    private void calculateWeekendDiscount(int visitDay, int mainCount,
        Map<String, Integer> appliedDiscount) {
        if (getDayOfWeek(visitDay) == December.FRIDAY.getDay()
            || getDayOfWeek(visitDay) == December.SATURDAY.getDay()) {
            appliedDiscount.put("주말 할인", WEEKEND_DISCOUNT * mainCount);
        }
    }

    private void calculateSpecialDiscount(int visitDay, Map<String, Integer> appliedDiscount) {
        if (getDayOfWeek(visitDay) == December.SUNDAY.getDay()
            || visitDay == December.CHRISTMAS.getDay()) {
            appliedDiscount.put("특별 할인", SPECIAL_DISCOUNT);
        }
    }

    private void calculateWeekdayDiscount(int visitDay, int dessertCount,
        Map<String, Integer> appliedDiscount) {
        if (December.SUNDAY.getDay() <= getDayOfWeek(visitDay)
            && getDayOfWeek(visitDay) <= December.THURSDAY.getDay()) {
            appliedDiscount.put("평일 할인", WEEKDAY_DISCOUNT * dessertCount);
        }
    }

    private static int getDayOfWeek(int visitDay) {
        return visitDay % December.WEEK_DAYS.getDay();
    }
}
