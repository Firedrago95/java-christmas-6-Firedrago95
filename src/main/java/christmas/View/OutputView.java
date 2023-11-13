package christmas.View;

import christmas.Domain.Menu;
import java.util.Map;

public class OutputView {

    public static final String ORDER_LIST_MESSAGE = "<주문 메뉴>";
    public static final String TOTAL_PRICE_MESSAGE = "<할인 전 총주문 금액>";
    public static final String GIFT_MESSAGE = "<증정 메뉴>";
    public static final String CHAMPAGNE = "샴페인 1개";
    public static final String BENEFIT_LIST_MESSAGE = "<혜택 내역>";
    public static final String CHAMPAGNE_AMOUNT_MESSAGE = "증정 이벤트: -25,000원";
    public static final String BENEFIT_AMOUNT_MESSAGE = "<총혜택 금액>";
    public static final String ZERO = "0원";
    public static final String TOTAL_PAYMENT_MESSAGE = "<할인 후 예상 결제 금액>";
    public static final String BADGE_MESSAGE = "<12월 이벤트 배지>";
    public static final String CURRENCY = "원";
    public static final String NOTHING = "없음";

    public static void printOrder(Map<Menu, Integer> order) {
        System.out.println(ORDER_LIST_MESSAGE);
        order.forEach(
            (menu, quantity) -> System.out.println(menu.getName() + " " + quantity + "개"));
        System.out.println();
    }

    public static void printTotalPrice(int totalPrice) {
        System.out.println(TOTAL_PRICE_MESSAGE);
        System.out.println(convertFormatted(totalPrice) + CURRENCY);
        System.out.println();
    }

    public static void printGift(boolean isEligibleForGift) {
        if (!isEligibleForGift) {
            System.out.println(GIFT_MESSAGE);
            printNothing();
            return;
        }
        System.out.println(GIFT_MESSAGE);
        System.out.println(CHAMPAGNE);
        System.out.println();
    }

    public static void printNoEvent(int totalPrice) {
        System.out.println(GIFT_MESSAGE);
        printNothing();
        System.out.println(BENEFIT_LIST_MESSAGE);
        printNothing();
        System.out.println(BENEFIT_AMOUNT_MESSAGE);
        System.out.println(ZERO);
        System.out.println();
        System.out.println(TOTAL_PAYMENT_MESSAGE);
        System.out.println(totalPrice + CURRENCY);
        System.out.println();
        System.out.println(BADGE_MESSAGE);
        printNothing();
    }

    public static void printDiscount(Map<String, Integer> appliedDiscount, boolean isEligibleGift) {
        System.out.println(BENEFIT_LIST_MESSAGE);
        for (Map.Entry<String, Integer> discount : appliedDiscount.entrySet()) {
            if (discount.getValue() != 0) {
                System.out.println(
                    discount.getKey() + ": " + "-" + convertFormatted(discount.getValue()) + CURRENCY);
            }
        }
        printGiftAmount(isEligibleGift);
    }

    public static void printTotalBenefit(int totalBenefit) {
        System.out.println(BENEFIT_AMOUNT_MESSAGE);
        System.out.println("-" + convertFormatted(totalBenefit) + CURRENCY);
        System.out.println();
    }

    public static void printTotalPayment(int totalPayment) {
        System.out.println(TOTAL_PAYMENT_MESSAGE);
        System.out.println(convertFormatted(totalPayment) + CURRENCY);
        System.out.println();
    }

    public static void printBadge(String badge) {
        System.out.println(BADGE_MESSAGE);
        System.out.println(badge);
    }

    private static void printNothing() {
        System.out.println(NOTHING);
        System.out.println();
    }

    private static void printGiftAmount(boolean isEligibleGift) {
        if (isEligibleGift) {
            System.out.println(CHAMPAGNE_AMOUNT_MESSAGE);
        }
        System.out.println();
    }

    private static String convertFormatted(int number) {
        return String.format("%,d", number);
    }
}
