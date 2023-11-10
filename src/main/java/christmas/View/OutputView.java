package christmas.View;

import christmas.Domain.Menu;
import java.util.Map;

public class OutputView {

    public static void printOrder(Map<Menu, Integer> order) {
        System.out.println("<주문 메뉴>");
        order.forEach(
            (menu, quantity) -> System.out.println(menu.getName() + " " + quantity + "개"));
        System.out.println();
    }

    public static void printTotalPrice(int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(convertFormatted(totalPrice) + "원");
        System.out.println();
    }

    public static void printGift(boolean isEligibleForGift) {
        if (!isEligibleForGift) {
            System.out.println("<증정 메뉴>");
            printNothing();
            return;
        }
        System.out.println("<증정 메뉴>");
        System.out.println("샴페인 1개");
        System.out.println();
    }

    private static String convertFormatted(int number) {
        return String.format("%,d", number);
    }

    public static void printNoEvent(int totalPrice) {
        System.out.println("<증정 메뉴>");
        printNothing();
        System.out.println("<혜택 내역>");
        printNothing();
        System.out.println("<총혜택 금액>");
        System.out.println("0원");
        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(totalPrice+"원");
        System.out.println();
        System.out.println("<12월 이벤트 배지>");
        printNothing();
    }

    private static void printNothing() {
        System.out.println("없음");
        System.out.println();
    }

    public static void printDiscount(Map<String, Integer> appliedDiscount, boolean isEligibleGift) {
        System.out.println("<혜택 내역>");
        for (Map.Entry<String, Integer> entry : appliedDiscount.entrySet()) {
            System.out.println(entry.getKey() + ": " + "-"+convertFormatted(entry.getValue())+"원");
        }
        if (isEligibleGift) {
            System.out.println("증정 이벤트: -25,000원");
        }
        System.out.println();
    }

    public static void printTotalBenefit(int totalBenefit) {
        System.out.println("<총혜택 금액>");
        System.out.println("-"+convertFormatted(totalBenefit)+"원");
        System.out.println();
    }

    public static void printTotalPayment(int totalPayment) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(convertFormatted(totalPayment)+"원");
        System.out.println();
    }

    public static void printBadge(String badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }
}
