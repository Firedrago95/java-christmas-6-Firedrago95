package christmas.Util.Validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import christmas.Domain.Order;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderValidatorTest {

    @Test
    @DisplayName("없는 메뉴 유효성검사 테스트")
    public void noMenuTest() {
        Map<String, Integer> invalidOrder = Map.of("된장찌개", 1);

        assertThatThrownBy(() -> OrderValidator.validateOrder(invalidOrder)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주문 생성 20개 초과 예외 테스트")
    public void exceedMenuTest() {
        Map<String, Integer> invalidOrder = Map.of("양송이수프", 21);

        assertThatThrownBy(() -> OrderValidator.validateOrder(invalidOrder)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    @DisplayName("음료만 주문 예외 테스트")
    public void orderOnlyBeverageTest() {
        Map<String, Integer> invalidOrder = new HashMap<>();
        invalidOrder.put("제로콜라",1);
        invalidOrder.put("레드와인",1);
        invalidOrder.put("샴페인",1);

        assertThatThrownBy(() -> OrderValidator.validateOrder(invalidOrder)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주문 수량 1이하인 경우 예외발생 테스트")
    public void orderNumberRangeTest() {
        Map<String, Integer> invalidOrder = new HashMap<>();
        invalidOrder.put("제로콜라",-1);
        invalidOrder.put("양송이수프",0);

        assertThatThrownBy(() -> OrderValidator.validateOrder(invalidOrder)).isInstanceOf(
            IllegalArgumentException.class);
    }

}
