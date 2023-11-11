package christmas.Constant;

public enum Badge {
    SANTA("산타",20000),
    TREE("트리",10000),
    STAR("별", 5000),
    NOTHING("없음",0);

    private final String name;
    private final int minPrice;

    Badge(String name, int minPrice) {
        this.name = name;
        this.minPrice = minPrice;
    }

    public String getName() {
        return name;
    }

    public int getMinPrice() {
        return minPrice;
    }
}
