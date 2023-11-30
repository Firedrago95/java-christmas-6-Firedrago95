package christmas.model;

import christmas.util.ExceptionMessage;
import christmas.util.validator.OrderValidator;
import java.util.Map;
import java.util.Set;

public class Order {

    private Map<Menu, Integer> order;

    public Order(Map<String, Integer> order) throws IllegalArgumentException {
        OrderValidator.validate(order);
        this.order = convertStringToMenu(order);
    }

}
