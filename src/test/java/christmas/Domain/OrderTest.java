package christmas.Domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    @DisplayName("객체생성 테스트")
    public void calculateTotalPrice() {
        Map<String, Integer> orderMap = new HashMap<>();
        orderMap.put("양송이수프", 2);
        orderMap.put("티본스테이크", 1);
        Order order = new Order(orderMap);

        assertEquals(2, order.getOrder().get(Menu.양송이수프));
        assertEquals(1, order.getOrder().get(Menu.티본스테이크));
    }

}
