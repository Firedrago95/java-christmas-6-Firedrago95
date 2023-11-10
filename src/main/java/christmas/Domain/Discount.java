package christmas.Domain;

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
        if (visitDay >= 1 && visitDay <= 25) {
            appliedDiscount.put("크리스마스 디데이 할인", ((visitDay - 1) * 100) + 1000);
        }
    }

    private void calculateWeekendDiscount(int visitDay, int mainCount,
        Map<String, Integer> appliedDiscount) {
        if (visitDay % 7 == 1 || visitDay % 7 == 2) {
            appliedDiscount.put("주말 할인", 2023 * mainCount);
        }
    }

    private void calculateSpecialDiscount(int visitDay, Map<String, Integer> appliedDiscount) {
        if (visitDay % 7 == 3 || visitDay == 25) {
            appliedDiscount.put("특별 할인", 1000);
        }
    }

    private void calculateWeekdayDiscount(int visitDay, int dessertCount,
        Map<String, Integer> appliedDiscount) {
        if (visitDay % 7 == 3 || visitDay % 7 == 4 || visitDay % 7 == 5 || visitDay == 6
            || visitDay == 7) {
            appliedDiscount.put("평일 할인", 2023 * dessertCount);
        }
    }
}
