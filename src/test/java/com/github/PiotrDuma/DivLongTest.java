package com.github.PiotrDuma;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class DivLongTest extends BaseTest{

    @Test
    @DisplayName("Should not div by zero.")
    public void shouldThrowWhenDivByZero(){
        assertThrows(NumberFormatException.class, () -> calculator.div(1L, 0L));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    @DisplayName("Should div two long values")
    public void divLongTest(long a, long b, long expected){
        long result = calculator.div(a, b);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                arguments(0L, 1L, 0L),
                arguments(0L, -1L, 0L),
                arguments(2L, -2L, -1L),
                arguments(-2L, 2L, -1L),
                arguments(-2L, -2L, 1L),
                arguments(Long.MAX_VALUE, Long.MAX_VALUE, 1L)
        );
    }
}
