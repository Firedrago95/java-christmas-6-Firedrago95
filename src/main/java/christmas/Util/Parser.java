package christmas.Util;

import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {

    public static final String EMPTY_VALUE_MESSAGE = "[ERROR] 값을 입력해주세요";
    public static final String INVALID_FORM_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    public static final String ORDER_REGEX = "[가-힣]+-\\d+(,[가-힣]+-\\d+)*";

    public static Map<String, Integer> convertStringToMap(String order)
        throws IllegalArgumentException {
        validateEmpty(order);
        validateFormat(order);
        return getMap(order);
    }

    private static Map<String, Integer> getMap(String order) throws IllegalArgumentException{
        try {
            return Arrays.stream(order.split(","))
                .map(menu -> menu.split("-"))
                .collect(Collectors.toMap(menuInfo -> menuInfo[0],
                    menuInfo -> Integer.parseInt(menuInfo[1])));
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(INVALID_FORM_MESSAGE);
        }
    }

    private static void validateEmpty(String order) throws IllegalArgumentException {
        if (order == null || order.equals("")) {
            throw new IllegalArgumentException(EMPTY_VALUE_MESSAGE);
        }
    }

    private static void validateFormat(String order) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(ORDER_REGEX);
        Matcher matcher = pattern.matcher(order);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_FORM_MESSAGE);
        }
    }

}
