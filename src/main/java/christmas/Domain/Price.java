package christmas.Domain;

import java.util.Map;

public class Price {

    public static final int MIN_EVENT_PRICE = 10000;
    public static final int MIN_GIFT_PRICE = 120000;
    private final int totalPrice;
    private int dicountPrice;

    public Price(int totalPrice) {
        this.totalPrice = totalPrice;
        dicountPrice = 0;
    }

    public boolean isEventOn() {
        if (totalPrice >= MIN_EVENT_PRICE) {return true;}
        return false;
    }

    public boolean isEligibleForGift() {
        if (totalPrice >= MIN_GIFT_PRICE) {return true;}
        return false;
    }

    public int calculateTotalDiscount(Map<String,Integer> appliedDiscount, boolean isEligibleGift) {
        int totalDiscount = appliedDiscount.values()
            .stream()
            .mapToInt(Integer::intValue)
            .sum();
        if (isEligibleGift) {
            totalDiscount += 25000;
        }
        this.dicountPrice = totalDiscount;
        return totalDiscount;
    }
}
