package christmas.util;

public enum ExceptionMessage {
    NULL_OR_EMPTY("[ERROR] 값을 입력해주세요"),
    INVALID_FORM("[ERROR] 형식에 맞는 값을 입력해주세요");

    private final String message;

    ExceptionMessage(String message) {this.message = message;}

    public String getMessage() {
        return message;
    }
}
