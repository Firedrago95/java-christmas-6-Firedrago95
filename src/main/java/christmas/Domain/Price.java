package christmas.Domain;

import christmas.Constant.Badge;
import christmas.Constant.DiscountPrice;
import java.util.Map;

public class Price {

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
        if (benefitPrice >= Badge.SANTA.getMinPrice()) {
            return Badge.SANTA.getName();
        }
        if (benefitPrice >= Badge.TREE.getMinPrice()) {
            return Badge.TREE.getName();
        }
        if (benefitPrice >= Badge.STAR.getMinPrice()) {
            return Badge.STAR.getName();
        }
        return Badge.NOTHING.getName();
    }
}
