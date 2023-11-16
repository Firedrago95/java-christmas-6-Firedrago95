package christmas.Domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiscountTest {

    Discount discount;
    @BeforeEach
    @DisplayName("객체생성")
    public void setup() {
        discount = new Discount();
    }

    @Test
    @DisplayName("할인 혜택 구하기 테스트")
    public void applyDiscountTest() {
        int visitDay = 3;
        int dessertCount = 2;
        int mainCount = 2;

        Map<String, Integer> expectedDiscount = Map.of(
            "크리스마스 디데이 할인", 1200,
            "평일 할인", 4046,
            "특별 할인", 1000
        );

        assertThat(discount.applyDiscount(visitDay, dessertCount, mainCount)).isEqualTo(
            expectedDiscount);
    }

    @Test
    @DisplayName("크리스마스 당일 할인 혜택 테스트")
    public void applyChristmasDiscountTest() {
        int visitDay = 25;
        int dessertCount = 1;
        int mainCount = 1;

        Map<String, Integer> expectedDiscount = Map.of(
            "크리스마스 디데이 할인", 3400,
            "평일 할인", 2023,
            "특별 할인", 1000
        );

        assertThat(discount.applyDiscount(visitDay, dessertCount, mainCount)).isEqualTo(
            expectedDiscount);
    }

    @Test
    @DisplayName("크리스마스 이후 주말 할인혜택 테스트")
    public void applyWeekendDiscountTest() {
        int visitDay = 29;
        int dessertCount = 1;
        int mainCount = 1;

        Map<String, Integer> expectedDiscount = Map.of(
            "주말 할인", 2023
        );

        assertThat(discount.applyDiscount(visitDay, dessertCount, mainCount)).isEqualTo(
            expectedDiscount);
    }
}
