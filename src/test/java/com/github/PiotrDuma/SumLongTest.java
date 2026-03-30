package com.github.PiotrDuma;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class SumLongTest extends BaseTest{


    //TODO: Verify requirements.
    @Disabled
    @Test
    public void sumExceedValuesShouldReturnValue(){
        long expected = -2;
        long result = super.calculator.sum(Long.MAX_VALUE, Long.MAX_VALUE);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "SUM: {0} + {1} should result {2}")
    @MethodSource("dataSource")
    @DisplayName("Should sum two long values")
    public void sumTest(long a, long b, long expected){
        long result = calculator.sum(a, b);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                arguments(1L, 2L, 3L),
                arguments(-10L, 20L, 10L),
                arguments(-20L, 20L, 0L),
                arguments(0L, 0L, 0L),
                arguments(-1L, -2L, -3L)
        );
    }
}
