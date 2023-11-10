package christmas.Domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
