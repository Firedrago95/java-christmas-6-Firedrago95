package christmas.Domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    @DisplayName("dessert 개수 구하기 테스트")
    public void countDessertItemsTest() {
        Map<String,Integer> orderedMenu = Map.of(
            "초코케이크",2,
            "아이스크림",3,
            "양송이수프",3
        );

        Order order = new Order(orderedMenu);

        assertThat(order.countDessertItems()).isEqualTo(5);
    }

    @Test
    @DisplayName("main 개수 구하기 테스트")
    public void countMainItemsTest() {
        Map<String,Integer> orderedMenu = Map.of(
            "티본스테이크",2,
            "바비큐립",2,
            "양송이수프",3
        );

        Order order = new Order(orderedMenu);

        assertThat(order.countMainItems()).isEqualTo(4);
    }

    @Test
    @DisplayName("샴페인 포함 확인 테스트")
    public void hasChampagneTest() {
        Map<String,Integer> orderedMenu = Map.of(
            "티본스테이크",2,
            "바비큐립",2,
            "샴페인",1
        );

        Order order = new Order(orderedMenu);

        assertTrue(order.hasChampagne());
    }
}
