package christmas.controller;

import christmas.model.ChristmasService;
import christmas.view.InputView;
import java.util.Map;

public class ChristmasController {

    private final ChristmasService service = new ChristmasService();

    public void run() {
        setDate();
        setOrder();
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
}
