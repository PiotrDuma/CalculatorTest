package com.github.PiotrDuma;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PowTest extends BaseTest{

    @ParameterizedTest
    @MethodSource("dataSource")
    @DisplayName("Should pow two values")
    public void powTest(double a, double b, double expected){
        double result = calculator.pow(a, b);

        assertEquals(expected, result, 0.001);
    }

    @Test
    public void powEdgeCasesTest(){
        assertTrue(Double.isNaN(calculator.pow(Double.NaN, 2.0)));
        assertEquals(1, calculator.pow(Double.NaN, 0.0));
    }

    @ParameterizedTest
    @DisplayName("Should round exponent positive number")
    @CsvSource({ //csv values just for training purposes
            "2.0, 2.99, 4.0",
            "2.0, 3, 8.0",
            "2.0, 3.01, 8.0",
            "2.0, -1.99, 0.25",
            "2.0, -2.0, 0.25",
            "2.0, -2.01, 0.125"})
    public void powRoundExponentNumberTest(double a, double b, double expected){
        assertEquals(expected, calculator.pow(a, b), 0.001);
    }

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                arguments(0.0, 1.0, 0),
                arguments(2.0, 0.0, 1.0),
                arguments(2.0, 3.0, 8.0),
                arguments(2.0, -3.0, 0.125),
                arguments(-2.0, 3.0, -8),
                arguments(-0.2, 3.0, -0.008),
                arguments(-0.1, -3.0, -1000)
        );
    }
}
