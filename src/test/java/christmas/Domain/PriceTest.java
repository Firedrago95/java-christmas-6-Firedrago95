package christmas.Domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
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

        assertThat(price.calculateTotalBenefit(appliedDiscount, isEligibleForGift))
            .isEqualTo(31246);
    }

    @Test
    @DisplayName("총 지불금액 계산 테스트")
    public void calculateTotalPaymentTest() {
        Price price = new Price(150000);
        Map<String, Integer> appliedDiscount = new HashMap<>();
        appliedDiscount.put("크리스마스 디데이 할인", 10000);
        appliedDiscount.put("평일 할인", 5000);
        boolean isEligibleGift = true;

        price.calculateTotalBenefit(appliedDiscount, isEligibleGift);
        int totalPayment = price.calculateTotalPayment(isEligibleGift);

        int expectedTotalPayment = 135000;
        assertEquals(expectedTotalPayment, totalPayment);
    }

    @Test
    @DisplayName("배지 얻기 기능 20000 이상 테스트")
    public void getBadgeTest() {
        Price price = new Price(10000);
        Map<String, Integer> appliedDiscount = new HashMap<>();
        boolean isEligibleGift = true;

        price.calculateTotalBenefit(appliedDiscount, isEligibleGift);
        String badge = "산타";

        assertEquals(badge,price.getBadge());
    }

    @Test
    @DisplayName("배지 얻기 10000 이상 테스트")
    public void getBadgeOverTenThousandTest() {
        Price price = new Price(10000);
        Map<String, Integer> appliedDiscount = new HashMap<>();
        appliedDiscount.put("크리스마스 특별 할인",10000);
        boolean isEligibleGift = false;

        price.calculateTotalBenefit(appliedDiscount, isEligibleGift);
        String badge = "트리";

        assertEquals(badge,price.getBadge());
    }

    @Test
    @DisplayName("배지 얻기 5000 이상 테스트")
    public void getBadgeOverFiveThousandTest() {
        Price price = new Price(10000);
        Map<String, Integer> appliedDiscount = new HashMap<>();
        appliedDiscount.put("크리스마스 특별 할인",5000);
        boolean isEligibleGift = false;

        price.calculateTotalBenefit(appliedDiscount, isEligibleGift);
        String badge = "별";

        assertEquals(badge,price.getBadge());
    }
}
