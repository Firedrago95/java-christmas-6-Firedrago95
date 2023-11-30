package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private enum ConsoleMessage {
        REQUEST_DATE_MESSAGE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

        private final String message;

        ConsoleMessage(String message) {this.message = message;}
    }
    public int readDate() throws IllegalArgumentException {
        System.out.println(ConsoleMessage.REQUEST_DATE_MESSAGE.message);
        String input = Console.readLine();
        InputValidator.validateDate(input);
        return Integer.parseInt(input);
    }
}
