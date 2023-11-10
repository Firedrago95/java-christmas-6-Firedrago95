package christmas.View;

import christmas.Domain.Menu;
import java.util.Map;

public class OutputView {

    public void printOrder(Map<Menu, Integer> order) {
        System.out.println("<주문 메뉴>");
        order.forEach(
            (menu, quantity) -> System.out.println(menu.getName() + " " + quantity + "개"));
        System.out.println();
    }
}
