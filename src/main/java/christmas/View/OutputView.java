package christmas.View;

import christmas.Domain.Menu;
import java.text.NumberFormat;
import java.util.Map;

public class OutputView {

    public void printOrder(Map<Menu, Integer> order) {
        System.out.println("<주문 메뉴>");
        order.forEach(
            (menu, quantity) -> System.out.println(menu.getName() + " " + quantity + "개"));
        System.out.println();
    }

    public void printTotalPrice(int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(convertFormatted(totalPrice) + "원");
        System.out.println();
    }

    private String convertFormatted(int number) {
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
}
