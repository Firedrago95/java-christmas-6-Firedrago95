package christmas.Domain;

import christmas.Util.Validator.OrderValidator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Order {

    private final Map<Menu, Integer> order;

    public Order(Map<String, Integer> order) throws IllegalArgumentException {
        OrderValidator.validateOrder(order);
        this.order = findMenu(order);
    }

    private Map<Menu, Integer> findMenu(Map<String, Integer> order) {
        return order.entrySet().stream()
            .map(entry -> {
                String menuName = entry.getKey();
                int quantity = entry.getValue();
                Menu menu = Menu.findByName(menuName);
                return Map.entry(menu, quantity);
            })
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<Menu, Integer> getOrder() {
        return new HashMap<>(order);
    }

    public int calculateTotalPrice() {
        return order.keySet().stream()
            .mapToInt(menu -> menu.getPrice() * order.get(menu))
            .sum();
    }

    public int countDessertItems() {
        return order.entrySet().stream()
            .filter(
                entry -> entry.getKey() != null && "dessert".equals(entry.getKey().getCategory()))
            .mapToInt(Map.Entry::getValue)
            .sum();
    }

    public int countMainItems() {
        return order.entrySet().stream()
            .filter(
                entry -> entry.getKey() != null && "main".equals(entry.getKey().getCategory()))
            .mapToInt(Map.Entry::getValue)
            .sum();
    }

    public boolean hasChampagne() {
        return order.keySet().stream()
            .anyMatch(menu -> Menu.샴페인.getName().equals(menu.getName()));
    }
}
