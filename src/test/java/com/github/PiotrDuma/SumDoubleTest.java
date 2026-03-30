package com.github.PiotrDuma;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class SumDoubleTest extends BaseTest{

    @ParameterizedTest(name = "SUM: {0} + {1} should result {2}")
    @MethodSource("dataSource")
    @DisplayName("Should sum two double values")
    public void sumTest(double a, double b, double expected){
        double result = calculator.sum(a, b);

        assertEquals(expected, result, 0.001);
    }

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                arguments(1.01, 2.01, 3.02),
                arguments(-10.01, 20.01, 10.0),
                arguments(-20.01, 20.01, 0.0),
                arguments(0.0, 0.0, 0.0),
                arguments(-1.01, -2.01, -3.02)
        );
    }
}
