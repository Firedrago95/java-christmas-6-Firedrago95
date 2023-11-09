package christmas.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int requestVisitDay() {
        try {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e){
            System.out.println("[ERROR] 값을 입력해주세요");
            return requestVisitDay();
        }
    }

}
