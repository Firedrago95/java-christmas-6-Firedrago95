package christmas.Domain;

public class Price {

    public static final int MIN_EVENT_PRICE = 10000;
    public static final int MIN_GIFT_PRICE = 120000;
    private final int totalPrice;
    private final int dicountPrice;

    public Price(int totalPrice) {
        this.totalPrice = totalPrice;
        dicountPrice = 0;
    }

    public boolean isEventOn() {
        if (totalPrice >= MIN_EVENT_PRICE) {return true;}
        return false;
    }

    public boolean isEligibleForGift() {
        if (totalPrice >= MIN_GIFT_PRICE) {return true;}
        return false;
    }
}
