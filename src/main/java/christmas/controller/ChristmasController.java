package christmas.controller;

import christmas.model.ChristmasService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class ChristmasController {

    private final ChristmasService service = new ChristmasService();

    public void run() {
        setDate();
        setOrder();
        printOrderList();
    }

    private void setOrder() {
        try {
            Map<String, Integer> order = InputView.readOrder();
            service.createOrder(order);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setOrder();
        }
    }

    private void setDate() {
        try {
            int date = InputView.readDate();
            service.createDate(date);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setDate();
        }
    }

    private void printOrderList() {
        OutputView.printOrderList(service.getOrderList(), service.getDate());
    }
}
