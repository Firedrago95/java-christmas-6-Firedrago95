package christmas.Util.Validator;

import christmas.Domain.Menu;
import java.util.Map;

public class OrderValidator {

    public static final String INVALID_ORDER = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public static void validateOrder(Map<String, Integer> order) throws IllegalArgumentException {
        validateMenu(order);
        validateAllBeverage(order);
        validateNumber(order);
        validateNumberRange(order);
    }

    private static void validateMenu(Map<String, Integer> order) throws IllegalArgumentException {
        boolean isContain = order.keySet().stream()
            .allMatch(Menu::hasContain);

        if (!isContain) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    private static void validateAllBeverage(Map<String, Integer> order)
        throws IllegalArgumentException {
        boolean allBeverage = order.keySet().stream()
            .allMatch(Menu::isBeverage);

        if (allBeverage) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    private static void validateNumber(Map<String, Integer> order) throws IllegalArgumentException {
        int menuCount = order.values().stream()
            .mapToInt(Integer::intValue)
            .sum();

        if (menuCount > 20) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    private static void validateNumberRange(Map<String, Integer> order)
        throws IllegalArgumentException{
        boolean allQuantitiesValid = order.values().stream()
            .allMatch(quantity -> quantity >= 1);

        if (!allQuantitiesValid) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

}
