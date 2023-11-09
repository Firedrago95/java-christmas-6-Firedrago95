package christmas.View;

import camp.nextstep.edu.missionutils.Console;
import christmas.Util.Parser;

public class InputView {

    public static final String REQUEST_ORDER =
        "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private final String REQUEST_VISIT_DAY =
        "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    public int requestVisitDay() {
        try {
            System.out.println(REQUEST_VISIT_DAY);
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println(Parser.REQUEST_VALUE_MESSAGE);
            return requestVisitDay();
        }
    }

    public String requestOrder() {
        System.out.println(REQUEST_ORDER);
        return Console.readLine();
    }

}
