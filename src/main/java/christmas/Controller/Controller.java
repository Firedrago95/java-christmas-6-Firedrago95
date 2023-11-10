package christmas.Controller;

import christmas.Domain.Discount;
import christmas.Domain.Order;
import christmas.Domain.Price;
import christmas.Util.Parser;
import christmas.View.InputView;
import christmas.View.OutputView;
import christmas.Domain.Date;
import java.util.Map;

public class Controller {

    public void run() {
        Date date = createDate();
        Order order = createOrder();
        OutputView.printOrder(order.getOrder());
        int totalPrice = order.calculateTotalPrice();
        OutputView.printTotalPrice(totalPrice);
        Price price = new Price(totalPrice);
        boolean isEventOn = price.isEventOn();
        if (!isEventOn) {
            OutputView.printNoEvent(totalPrice);
            return;
        }
        boolean isEligibleForGift = price.isEligibleForGift();
        OutputView.printGift(isEligibleForGift);
        int visitDay = date.getVisitDay();
        Discount discount = new Discount();
        Map<String, Integer> appliedDiscount = discount.applyDiscount(visitDay,
            order.countDessertItems(), order.countMainItems());
        OutputView.printDiscount(appliedDiscount, isEligibleForGift);
        OutputView.printTotalDiscount(
            price.calculateTotalDiscount(appliedDiscount, isEligibleForGift));
    }

    private static Date createDate() {
        try {
            int inputedDay = InputView.requestVisitDay();
            return new Date(inputedDay);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createDate();
        }
    }

    private static Order createOrder() {
        try {
            String inputedOrder = InputView.requestOrder();
            return new Order(Parser.convertStringToMap(inputedOrder));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createOrder();
        }
    }
}
