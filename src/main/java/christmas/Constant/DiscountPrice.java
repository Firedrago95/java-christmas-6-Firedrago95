package christmas.Constant;

public enum DiscountPrice {
    MIN_EVENT_PRICE(10000),
    MIN_GIFT_PRICE(120000),
    CHAMPAGNE_PRICE(25000),
    WEEKEND_DISCOUNT(2023),
    WEEKDAY_DISCOUNT(2023),
    SPECIAL_DISCOUNT(1000),
    DAILY_INCREASE(100),
    DEFAULT_DISCOUNT(1000);

    private final int price;

    DiscountPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}
