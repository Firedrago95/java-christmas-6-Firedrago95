package christmas.Domain;

import java.util.Map;
import java.util.Set;

public class Order {

    public static final String INVALID_ORDER = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private final Map<String,Integer> order;

    public Order(Map<String, Integer> order) throws IllegalArgumentException{
        validateOrder(order);
        this.order = order;
    }

    private void validateOrder(Map<String, Integer> order) throws IllegalArgumentException{
        validateMenu(order);
        validateAllBeverage(order);
        validateNumber(order);
    }

    private void validateMenu(Map<String, Integer> order) throws IllegalArgumentException{
        boolean isContain = order.keySet().stream()
            .allMatch(Menu::hasContain);

        if (!isContain) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    private void validateAllBeverage(Map<String, Integer> order) throws IllegalArgumentException{
        boolean allBeverage = order.keySet().stream()
            .allMatch(Menu::isBeverage);

        if (allBeverage) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    private void validateNumber(Map<String, Integer> order) throws IllegalArgumentException{
        int menuCount = order.values().stream()
            .mapToInt(Integer::intValue)
            .sum();

        if (menuCount > 20) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }
}
