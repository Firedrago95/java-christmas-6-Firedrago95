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

    Date date;
    Order order;
    Price price;

    public void run() {
        date = createDate();
        order = createOrder();
        OutputView.printOrder(order.getOrder());
        int totalPrice = getTotalPrice();
        if (hasEvent(totalPrice)) {
            return;
        }
        boolean isEligibleForGift = hasGift();
        Map<String, Integer> appliedDiscount = getDiscount(isEligibleForGift);
        getTotalBenefit(isEligibleForGift, appliedDiscount);
        getTotalPayment(isEligibleForGift);
        getChristmasBadge();
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

    private boolean hasEvent(int totalPrice) {
        price = new Price(totalPrice);
        boolean isEventOn = price.isEventOn();
        if (!isEventOn) {
            OutputView.printNoEvent(totalPrice);
            return true;
        }
        return false;
    }

    private boolean hasGift() {
        boolean isEligibleForGift = price.isEligibleForGift();
        OutputView.printGift(isEligibleForGift);
        return isEligibleForGift;
    }

    private Map<String, Integer> getDiscount(boolean isEligibleForGift) {
        int visitDay = date.getVisitDay();
        Discount discount = new Discount();
        Map<String, Integer> appliedDiscount = discount.applyDiscount(visitDay,
            order.countDessertItems(), order.countMainItems());
        OutputView.printDiscount(appliedDiscount, isEligibleForGift);
        return appliedDiscount;
    }

    private void getTotalBenefit(boolean isEligibleForGift, Map<String, Integer> appliedDiscount) {
        int totalBenefit = price.calculateTotalBenefit(appliedDiscount, isEligibleForGift);
        OutputView.printTotalBenefit(totalBenefit);
    }

    private int getTotalPrice() {
        int totalPrice = order.calculateTotalPrice();
        OutputView.printTotalPrice(totalPrice);
        return totalPrice;
    }

    private void getTotalPayment(boolean isEligibleForGift) {
        int totalPayment = price.calculateTotalPayment(isEligibleForGift);
        OutputView.printTotalPayment(totalPayment);
    }

    private void getChristmasBadge() {
        String badge = price.getBadge();
        OutputView.printBadge(badge);
    }
}
