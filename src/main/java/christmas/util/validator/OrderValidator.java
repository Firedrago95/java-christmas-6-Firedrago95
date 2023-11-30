package christmas.util.validator;

import christmas.model.Menu;
import christmas.util.ExceptionMessage;
import java.util.Map;
import java.util.Set;

public class OrderValidator {

    public static void validate(Map<String, Integer> order) throws IllegalArgumentException {
        validateMenu(order);
        validateUnique(order);
        validateAllBeverage(order);
        validateCount(order);
    }
    private static void validateMenu(Map<String, Integer> order) throws IllegalArgumentException {
        boolean isContain = order.keySet().stream()
            .allMatch(Menu::hasContain);

        if (!isContain) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER.getMessage());
        }
    }

    private static void validateUnique(Map<String, Integer> order) throws IllegalArgumentException {
        Set keySet = order.keySet();
        int menuCount = (int)keySet.stream().count();

        if (order.size() != menuCount) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER.getMessage());
        }
    }

    private static void validateAllBeverage(Map<String, Integer> order) throws IllegalArgumentException {
        boolean isAllBeverage = order.keySet().stream()
            .allMatch(Menu::checkAllBeverage);

        if (isAllBeverage) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER.getMessage());
        }
    }

    private static void validateCount(Map<String, Integer> order) throws IllegalArgumentException {
        int count = order.values().stream()
            .mapToInt(Integer::intValue)
            .sum();

        if (count > 20) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER.getMessage());
        }
    }
}
