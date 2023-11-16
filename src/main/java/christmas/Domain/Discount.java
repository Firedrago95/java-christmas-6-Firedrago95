package christmas.Domain;

import christmas.Constant.December;
import christmas.Constant.DiscountPrice;
import java.util.HashMap;
import java.util.Map;

public class Discount {

    public Map<String, Integer> applyDiscount(int visitDay, int dessertCount, int mainCount) {
        Map<String, Integer> appliedDiscount = new HashMap<>();
        calculateChristmasDiscount(visitDay, appliedDiscount);
        calculateWeekendDiscount(visitDay, mainCount, appliedDiscount);
        calculateSpecialDiscount(visitDay, appliedDiscount);
        calculateWeekdayDiscount(visitDay, dessertCount, appliedDiscount);
        return appliedDiscount;
    }

    private void calculateChristmasDiscount(int visitDay, Map<String, Integer> appliedDiscount) {
        if (December.FIRST_DAY.getDay() <= visitDay && visitDay <= December.CHRISTMAS.getDay()) {
            appliedDiscount.put("크리스마스 디데이 할인",
                ((visitDay - December.FIRST_DAY.getDay()) * DiscountPrice.DAILY_INCREASE.getPrice())
                    + DiscountPrice.DEFAULT_DISCOUNT.getPrice());
        }
    }

    private void calculateWeekendDiscount(int visitDay, int mainCount,
        Map<String, Integer> appliedDiscount) {
        if (getDayOfWeek(visitDay) == December.FRIDAY.getDay()
            || getDayOfWeek(visitDay) == December.SATURDAY.getDay()) {
            appliedDiscount.put("주말 할인", DiscountPrice.WEEKEND_DISCOUNT.getPrice() * mainCount);
        }
    }

    private void calculateSpecialDiscount(int visitDay, Map<String, Integer> appliedDiscount) {
        if (getDayOfWeek(visitDay) == December.SUNDAY.getDay()
            || visitDay == December.CHRISTMAS.getDay()) {
            appliedDiscount.put("특별 할인", DiscountPrice.SPECIAL_DISCOUNT.getPrice());
        }
    }

    private void calculateWeekdayDiscount(int visitDay, int dessertCount,
        Map<String, Integer> appliedDiscount) {
        if (December.SUNDAY.getDay() <= getDayOfWeek(visitDay)
            && getDayOfWeek(visitDay) <= December.THURSDAY.getDay()) {
            appliedDiscount.put("평일 할인", DiscountPrice.WEEKDAY_DISCOUNT.getPrice() * dessertCount);
        }
    }

    private static int getDayOfWeek(int visitDay) {
        return visitDay % December.WEEK_DAYS.getDay();
    }
}
