package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.InputValidator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class InputView {

    private enum ConsoleMessage {
        REQUEST_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
        REQUEST_ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    public static int readDate() throws IllegalArgumentException {
        System.out.println(ConsoleMessage.REQUEST_DATE.message);
        String input = Console.readLine();
        InputValidator.validateDate(input);
        return Integer.parseInt(input);
    }

    public static Map<String, Integer> readOrder() throws IllegalArgumentException {
        System.out.println(ConsoleMessage.REQUEST_ORDER.message);
        String input = Console.readLine();
        InputValidator.validateOrder(input);
        return Arrays.stream(input.split(","))
            .map(menu -> menu.split("-"))
            .collect(Collectors.toMap(menuInfo -> menuInfo[0],
                menuInfo -> Integer.parseInt(menuInfo[1])));
    }
}
