package christmas.Domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {

    Order order;
    @BeforeEach
    @DisplayName("객체생성")
    public void setUp(){
        Map<String, Integer> orderMap = new HashMap<>();
        orderMap.put("양송이수프", 2);
        orderMap.put("티본스테이크", 1);
        order = new Order(orderMap);
    }

    @Test
    @DisplayName("객체생성 테스트")
    public void createOrderTest() {
        assertEquals(2, order.getOrder().get(Menu.양송이수프));
        assertEquals(1, order.getOrder().get(Menu.티본스테이크));
    }

    @Test
    @DisplayName("총 구매금액 계산 테스트")
    public void calculateTotalPriceTest() {
        int result = order.calculateTotalPrice();
        int expectedResult = 67000;

        assertEquals(result,expectedResult);
    }
}
