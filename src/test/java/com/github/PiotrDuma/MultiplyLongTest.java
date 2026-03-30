package com.github.PiotrDuma;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MultiplyLongTest extends BaseTest{

    @ParameterizedTest
    @DisplayName("Multiply long values")
    @MethodSource("dataSource")
    public void shouldMultiplyTwoLongValues(long a, long b, long expected){
        assertEquals(expected, calculator.mult(a, b));
    }

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                arguments(0L, 1L, 0),
                arguments(1L, 0L, 0),
                arguments(0L, 0L, 0L),
                arguments(2L, 3L, 6L),
                arguments(2L, -3L, -6L),
                arguments(-3L, -3L, 9L)
        );
    }
}
