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
}
