package com.github.PiotrDuma;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CosTest extends BaseTest{

    @ParameterizedTest
    @MethodSource("dataSource")
    @DisplayName("Should return value of cos({0})")
    public void cosTest(double value, double expected){
        assertEquals(expected, calculator.cos(value), 0.001);
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    @DisplayName("Should keep period of cos function")
    public void periodSinTest(double value, double expected){
        double period = 200 * Math.PI;
        assertEquals(expected, calculator.cos(period + value), 0.001);
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    @DisplayName("Should keep symmetry of cos function")
    public void symmetricSinTest(double value, double expected){
        assertEquals(expected, calculator.cos(-1 * value), 0.001);
    }


    private static Stream<Arguments> dataSource() {
        return Stream.of(
                arguments(0.0, 1.0),
                arguments(Math.PI/2, 0.0),
                arguments(Math.PI, -1.0),
                arguments(-Math.PI / 2 , 0.0),
                arguments(3 * Math.PI / 2, 0.0),
                arguments(-2 * Math.PI, 1.0),
                arguments(2 * Math.PI, 1.0)
        );
    }
}
