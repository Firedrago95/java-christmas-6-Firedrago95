package christmas.Domain;

import christmas.Constant.DiscountPrice;
import christmas.View.OutputView;
import java.util.Map;

public class Price {

    public static final int MIN_SANTA_BADGE_PRICE = 20000;
    public static final int MIN_TREE_BADGE_PRICE = 10000;
    public static final int MIN_STAR_BADGE_PRICE = 5000;
    public static final String SANTA = "산타";
    public static final String TREE = "트리";
    public static final String STAR = "별";
    public static final String NOTHING = "없음";

    private final int totalPrice;
    private int benefitPrice;

    public Price(int totalPrice) {
        this.totalPrice = totalPrice;
        benefitPrice = 0;
    }

    public boolean isEventOn() {
        if (totalPrice >= DiscountPrice.MIN_EVENT_PRICE.getPrice()) {
            return true;
        }
        return false;
    }

    public boolean isEligibleForGift() {
        if (totalPrice >= DiscountPrice.MIN_GIFT_PRICE.getPrice()) {
            return true;
        }
        return false;
    }

    public int calculateTotalBenefit(Map<String, Integer> appliedDiscount, boolean isEligibleGift) {
        int totalDiscount = appliedDiscount.values()
            .stream()
            .mapToInt(Integer::intValue)
            .sum();
        if (isEligibleGift) {
            totalDiscount += DiscountPrice.CHAMPAGNE_PRICE.getPrice();
        }
        this.benefitPrice = totalDiscount;
        return totalDiscount;
    }

    public int calculateTotalPayment(boolean isEligibleGift) {
        int totalPayment = totalPrice - benefitPrice;
        if (isEligibleGift) {
            totalPayment += DiscountPrice.CHAMPAGNE_PRICE.getPrice();
        }
        return totalPayment;
    }

    public String getBadge() {
        if (benefitPrice >= MIN_SANTA_BADGE_PRICE) {
            return SANTA;
        }
        if (benefitPrice >= MIN_TREE_BADGE_PRICE) {
            return TREE;
        }
        if (benefitPrice >= MIN_STAR_BADGE_PRICE) {
            return STAR;
        }
        return NOTHING;
    }
}
