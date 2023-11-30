package christmas.model;

import christmas.util.validator.OrderValidator;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class Order {

    private Map<Menu, Integer> order;

    public Order(Map<String, Integer> order) throws IllegalArgumentException {
        OrderValidator.validate(order);
        this.order = convertStringToMenu(order);
    }

    private Map<Menu, Integer> convertStringToMenu(Map<String, Integer> order) {
        return order.entrySet().stream()
            .map(entry -> {
                String menuName = entry.getKey();
                int menuCount = entry.getValue();
                Menu menu = Menu.findByName(menuName);
                return Map.entry(menu, menuCount);
            })
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public String getOrderList() {
        StringBuilder orderList = new StringBuilder();
        order.forEach(
            (menuName, quantity) -> orderList.append(menuName + " " + quantity + "개" + "\n"));
        return orderList.toString();
    }
}
