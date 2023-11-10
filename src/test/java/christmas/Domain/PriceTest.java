package christmas.Domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriceTest {

    @Test
    @DisplayName("이벤트 발생 테스트")
    public void isEventOnTest() {
        Price validPrice = new Price(10000);
        Price invalidPrice = new Price(9999);

        assertTrue(validPrice.isEventOn());
        assertFalse(invalidPrice.isEventOn());
    }

    @Test
    @DisplayName("증정품 여부 확인 테스트")
    public void isEligibleForGiftTest() {
        Price validPrice = new Price(120000);
        Price invalidPrice = new Price(119999);

        assertTrue(validPrice.isEligibleForGift());
        assertFalse(invalidPrice.isEligibleForGift());
    }

    @Test
    @DisplayName("총 할인금액 계산 테스트")
    public void calculateTotalDiscountTest() {
        Map<String, Integer> appliedDiscount = Map.of(
            "크리스마스 디데이 할인", 1200,
            "평일 할인", 4046,
            "특별 할인", 1000
        );
        boolean isEligibleForGift = true;

        Price price = new Price(10000);

        assertThat(price.calculateTotalDiscount(appliedDiscount, isEligibleForGift))
            .isEqualTo(31246);
    }
}
