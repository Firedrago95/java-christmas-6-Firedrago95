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
        Map<String, Integer> orderMap = Map.of(
            "초코케이크",2,
            "아이스크림",3,
            "양송이수프",1,
            "바비큐립",2
        );

        order = new Order(orderMap);
    }

    @Test
    @DisplayName("객체생성 테스트")
    public void createOrderTest() {
        assertEquals(1, order.getOrder().get(Menu.양송이수프));
        assertEquals(3, order.getOrder().get(Menu.아이스크림));
        assertEquals(2, order.getOrder().get(Menu.초코케이크));
        assertEquals(2, order.getOrder().get(Menu.바비큐립));
    }

    @Test
    @DisplayName("총 구매금액 계산 테스트")
    public void calculateTotalPriceTest() {
        assertThat(order.calculateTotalPrice()).isEqualTo(159000);
    }

    @Test
    @DisplayName("dessert 개수 구하기 테스트")
    public void countDessertItemsTest() {
        assertThat(order.countDessertItems()).isEqualTo(5);
    }

    @Test
    @DisplayName("main 개수 구하기 테스트")
    public void countMainItemsTest() {
        assertThat(order.countMainItems()).isEqualTo(2);
    }
}
