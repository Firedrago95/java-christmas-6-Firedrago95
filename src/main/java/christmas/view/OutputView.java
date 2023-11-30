package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.Menu;
import java.util.Map;

public class OutputView {
    private enum ConsoleMessage {
        EVENT_START("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
        ORDER_LIST("<주문 메뉴>");
        private String message;

        ConsoleMessage(String message) {this.message = message;}
    }

    public static void printOrderList(String orderList, int date) {
        printEventStart(date);
        System.out.println(ConsoleMessage.ORDER_LIST.message);
        System.out.println(orderList);
    }

    private static void printEventStart(int date) {
        System.out.printf(ConsoleMessage.EVENT_START.message, date);
        System.out.println();
        System.out.println();
    }
}
