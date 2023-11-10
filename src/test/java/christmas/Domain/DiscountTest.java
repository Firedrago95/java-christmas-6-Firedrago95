package christmas.Domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiscountTest {

    @Test
    @DisplayName("할인 혜택 구하기 테스트")
    public void applyDiscountTest() {
        Discount discount = new Discount();
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
}
