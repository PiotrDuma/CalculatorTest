package com.github.PiotrDuma;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SubLongTest extends BaseTest{

    @ParameterizedTest(name = "SUM: {0} - {1} should result {2}")
    @MethodSource("dataSource")
    @DisplayName("Should subtract two long values")
    public void sumTest(long a, long b, long expected){
        long result = calculator.sub(a, b);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                arguments(1L, 2L, -1L),
                arguments(2L, 2L, 0L),
                arguments(2L, 1L, 1L),
                arguments(-10L, 20L, -30L),
                arguments(-20L, -20L, 0L),
                arguments(0L, 0L, 0L),
                arguments(-1L, -2L, 1L)
        );
    }
}
