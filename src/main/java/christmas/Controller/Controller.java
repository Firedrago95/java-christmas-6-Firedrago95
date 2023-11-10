package christmas.Controller;

import christmas.Domain.Order;
import christmas.Domain.Price;
import christmas.Util.Parser;
import christmas.View.InputView;
import christmas.View.OutputView;
import java.util.Date;

public class Controller {

    public void run() {
        Date date = createDate();
        Order order = createOrder();
        int totalPrice = order.calculateTotalPrice();
        Price price = new Price(totalPrice);
        boolean isEventOn = price.isEventOn();
        if (!isEventOn) {
            OutputView.printNoEvent(totalPrice);
            return;
        }
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
