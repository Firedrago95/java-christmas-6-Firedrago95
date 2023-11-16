package christmas.Domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DateTest {

    @ParameterizedTest
    @DisplayName("1 ~ 31 이외의 숫자 예외테스트")
    @ValueSource(ints = {0, -1, 32})
    public void numberRangeTest(int input) {
        assertThatThrownBy(() -> new Date(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
