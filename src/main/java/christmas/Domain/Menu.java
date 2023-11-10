package christmas.Domain;

import java.util.Arrays;

public enum Menu {
    양송이수프("양송이수프", 6000, "appetizer"),
    타파스("타파스", 5500, "appetizer"),
    시저샐러드("시저샐러드", 8000, "appetizer"),
    티본스테이크("티본스테이크", 55000, "main"),
    바비큐립("바비큐립", 54000, "main"),
    해산물파스타("해산물파스타", 35000, "main"),
    크리스마스파스타("크리스마스파스타", 25000, "main"),
    초코케이크("초코케이크", 15000, "dessert"),
    아이스크림("아이스크림", 5000, "dessert"),
    제로콜라("제로콜라", 3000, "beverage"),
    레드와인("레드와인", 60000, "beverage"),
    샴페인("샴페인", 25000, "beverage");

    private final String name;
    private final int price;
    private final String category;

    Menu(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public static boolean hasContain(String menuName) {
        return Arrays.stream(values())
            .anyMatch(menu -> menu.name.equals(menuName));
    }

    public static boolean isBeverage(String menuName) {
        return Arrays.stream(values())
            .anyMatch(menu -> menu.name.equals(menuName) && menu.category.equals("beverage"));
    }

    public static Menu findByName(String menuName) {
        return Arrays.stream(values())
            .filter(menu -> menu.name.equals(menuName))
            .findFirst()
            .orElse(null);
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
