package christmas.Domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuTest {

    @Test
    @DisplayName("메뉴 이름 포함 테스트")
    public void hasContainTest() {
        String invalidInput = "양송이송이수프";
        String validInput = "양송이수프";

        assertFalse(() -> Menu.hasContain(invalidInput));
        assertTrue(() -> Menu.hasContain(validInput));
    }

    @Test
    @DisplayName("음료 카테고리 확인 테스트")
    public void isBeverageTest() {
        String[] inputs = {"제로콜라", "레드와인", "샴페인"};
        String invalidInput = "양송이수프";

        for (String input : inputs) {
            assertTrue(Menu.isBeverage(input));
        }
        assertFalse(Menu.isBeverage(invalidInput));
    }
}
