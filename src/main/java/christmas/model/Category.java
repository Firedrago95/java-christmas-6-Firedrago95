package christmas.model;

import java.util.Arrays;

public enum Category {
    에피타이저("appetizer"),
    메인("main"),
    디저트("dessert"),
    음료("beverage");

    private final String category;

    Category(String category) {this.category = category;}

    public String getCategory() {
        return category;
    }
}
