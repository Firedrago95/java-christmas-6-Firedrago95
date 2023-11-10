package christmas.Domain;

import christmas.Util.Validator.OrderValidator;
import java.util.Map;
import java.util.Set;

public class Order {


    private final Map<String,Integer> order;

    public Order(Map<String, Integer> order) throws IllegalArgumentException{
        OrderValidator.validateOrder(order);
        this.order = order;
    }


}
