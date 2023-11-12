package christmas.Domain;

import java.util.Map;


public class PromotionService {

    Date date;
    Order order;
    Price price;

    public void createDate(int visitDay) throws IllegalArgumentException {
        date = new Date(visitDay);
    }

    public void createOrder(Map<String, Integer> orders) throws IllegalArgumentException {
        order = new Order(orders);
    }

    public Map<Menu, Integer> getOrderList() {
        return order.getOrder();
    }

    public int getTotalPrice() {
        int totalPrice = order.calculateTotalPrice();
        price = new Price(totalPrice);
        return totalPrice;
    }

    public boolean isEventOn() {
        return price.isEventOn();
    }

    public boolean hasGift() {
        return price.isEligibleForGift();
    }

    public Map<String, Integer> getDiscount() {
        int visitDay = date.getVisitDay();
        Discount discount = new Discount();
        return discount.applyDiscount(visitDay, order.countDessertItems(), order.countMainItems());
    }

    public int getTotalBenefit() {
        return price.calculateTotalBenefit(getDiscount(), hasGift());
    }

    public int getTotalPayment() {
        return price.calculateTotalPayment(hasGift());
    }

    public String getChristmasBadge() {
        return price.getBadge();
    }
}
