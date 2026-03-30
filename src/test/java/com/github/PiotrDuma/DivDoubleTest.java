package com.github.PiotrDuma;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class DivDoubleTest extends BaseTest{

    @Test
    public void shouldReturnInfinityWhenDivByZero(){
        assertTrue(Double.isInfinite(calculator.div(1.0, 0.0)));
        assertTrue(Double.isInfinite(calculator.div(-1.0, 0.0)));
    }

    @Test
    public void shouldReturnNaN(){
        assertTrue(Double.isNaN(calculator.div(0.0, 0.0)));
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    @DisplayName("Should div two double values")
    public void divDoubleTest(double a, double b, double expected){
        double result = calculator.div(a, b);

        assertEquals(expected, result, 0.001);
    }

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                arguments(0.0, 1d, 0.0),
                arguments(0.0, -1d, 0.0),
                arguments(2.0, -2.0, -1.0),
                arguments(-2.0, 0.5, -4.0),
                arguments(-2.0, -0.5, 4.0),
                arguments(Double.MAX_VALUE, Double.MAX_VALUE, 1.0)
        );
    }
}
