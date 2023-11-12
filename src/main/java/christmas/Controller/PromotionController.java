package christmas.Controller;

import christmas.Domain.PromotionService;
import christmas.Util.Parser;
import christmas.View.InputView;
import christmas.View.OutputView;


public class PromotionController {

    PromotionService promotionService;

    public void run() {
        setPromotion();
        printOrderList();
        printTotalPrice();
        if (hasNoEvent()) {
            printNoEvent();
            return;
        }
        printEligibleGift();
        printAppliedDiscount();
        printTotalBenefit();
        printTotalPayment();
        printChristmasBadge();
    }

    private void setPromotion() {
        setUpService();
        setDate();
        setOrder();
    }

    private void setUpService() {
        promotionService = new PromotionService();
    }

    private void setDate() {
        try {
            int visitDay = InputView.requestVisitDay();
            promotionService.createDate(visitDay);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setDate();
        }
    }

    private void setOrder() {
        try {
            String orders = InputView.requestOrder();
            promotionService.createOrder(Parser.convertStringToMap(orders));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setOrder();
        }
    }

    private void printOrderList() {
        OutputView.printOrder(promotionService.getOrderList());
    }

    private void printTotalPrice() {
        OutputView.printTotalPrice(promotionService.getTotalPrice());
    }

    private void printNoEvent() {
        OutputView.printNoEvent(promotionService.getTotalPrice());
    }

    private boolean hasNoEvent() {
        boolean isEventOn = promotionService.isEventOn();
        if (!isEventOn) {
            return true;
        }
        return false;
    }

    private void printEligibleGift() {
        OutputView.printGift(promotionService.hasGift());
    }

    private void printAppliedDiscount() {
        OutputView.printDiscount(promotionService.getDiscount(), promotionService.hasGift());
    }

    private void printTotalBenefit() {
        OutputView.printTotalBenefit(promotionService.getTotalBenefit());
    }

    private void printTotalPayment() {
        OutputView.printTotalPayment(promotionService.getTotalPayment());
    }

    private void printChristmasBadge() {
        OutputView.printBadge(promotionService.getChristmasBadge());
    }
}
