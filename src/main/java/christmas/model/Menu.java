package christmas.model;

import java.util.Arrays;

public enum Menu {
    양송이수프("양송이수프", 6000, Category.에피타이저.getCategory()),
    타파스("타파스", 5500, Category.에피타이저.getCategory()),
    시저샐러드("시저샐러드", 8000, Category.에피타이저.getCategory()),
    티본스테이크("티본스테이크", 55000, Category.메인.getCategory()),
    바비큐립("바비큐립", 54000, Category.메인.getCategory()),
    해산물파스타("해산물파스타", 35000, Category.메인.getCategory()),
    크리스마스파스타("크리스마스파스타", 25000, Category.메인.getCategory()),
    초코케이크("초코케이크", 15000, Category.디저트.getCategory()),
    아이스크림("아이스크림", 5000, Category.디저트.getCategory()),
    제로콜라("제로콜라", 3000, Category.음료.getCategory()),
    레드와인("레드와인", 60000, Category.음료.getCategory()),
    샴페인("샴페인", 25000, Category.음료.getCategory());

    public static final String BEVERAGE = "beverage";
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

    public static boolean checkAllBeverage(String menuName) {
        return Arrays.stream(values())
            .anyMatch(
                menu -> menu.name.equals(menuName)
                    && menu.category.equals(Category.음료.getCategory()));
    }

    public static Menu findByName(String menuName) {
        return Arrays.stream(values())
            .filter(menu -> menu.name.equals(menuName))
            .findFirst()
            .orElse(null);
    }
}
