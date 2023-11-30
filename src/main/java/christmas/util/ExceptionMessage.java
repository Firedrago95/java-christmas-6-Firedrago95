package christmas.util;

public enum ExceptionMessage {
    NULL_OR_EMPTY("[ERROR] 값을 입력해주세요"),
    INVALID_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");


    private final String message;

    ExceptionMessage(String message) {this.message = message;}

    public String getMessage() {
        return message;
    }
}
