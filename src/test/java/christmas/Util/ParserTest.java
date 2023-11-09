package christmas.Util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParserTest {


    @DisplayName("문자열 Map 변환 정규식 예외 테스트")
    @ValueSource(strings = {"양송이스프-1,제로콜라", ""})
    @ParameterizedTest
    public void regExceptionTest(String input) {
        assertThatThrownBy(() -> Parser.convertStringToMap(input)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("문자열 Map 올바른 형식 테스트 ")
    @ValueSource(strings = {"양송이스프-1,제로콜라-3","제로콜라-1,양송이스프-2,레드와인-1"})
    @ParameterizedTest
    public void formTest(String input) {
        assertDoesNotThrow(() -> Parser.convertStringToMap(input));
    }

    @Test
    @DisplayName("문자열 Map 기능 테스트")
    public void convertStringToMapTest() {
        String input = "양송이스프-1,제로콜라-1";

        assertThat(Parser.convertStringToMap(input))
            .isEqualTo(Map.of("양송이스프", 1, "제로콜라", 1));
    }
}
