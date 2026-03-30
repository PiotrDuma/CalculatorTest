package com.github.PiotrDuma;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MultiplyDoubleTest extends BaseTest{

    @ParameterizedTest
    @DisplayName("Multiply double values")
    @MethodSource("dataSource")
    public void shouldMultiplyTwoDoubleValues(double a, double b, double expected){
        assertEquals(expected, calculator.mult(a, b));
    }

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                arguments(0.0, 1.0, 0),
                arguments(1.0, 0.0, 0),
                arguments(0.0, 0.0, 0.0),
                arguments(2.001, 3.0, 6.0),
                arguments(1.999, 3.0, 5.0),
                arguments(2.0, -3.0, -6.0),
                arguments(-2.0, -3.0, 6.0),
                arguments(-1.0, 0.0001, -1.0),
                arguments(-1.0, 1.0001, -2.0)
        );
    }
}
