package christmas.model;

import java.util.Map;

public class ChristmasService {

    private Date visitDate;
    private Order order;
    public void createDate(int date) throws IllegalArgumentException {
        this.visitDate = new Date(date);
    }

    public void createOrder(Map<String, Integer> order) throws IllegalArgumentException {
        this.order = new Order(order);
    }
}
