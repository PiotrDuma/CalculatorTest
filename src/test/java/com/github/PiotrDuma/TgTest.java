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

public class TgTest extends BaseTest{

    @ParameterizedTest
    @MethodSource("dataSource")
    @DisplayName("Should return value of sin({0})")
    public void sinTest(double value, double expected){
        assertEquals(expected, calculator.tg(value), 0.001);
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    @DisplayName("Should keep period of sin function")
    public void periodSinTest(double value, double expected){
        double period = 200 * Math.PI;
        assertEquals(expected, calculator.tg(period + value), 0.001);
    }

    @Test
    @DisplayName("Should return nan value in infinite period")
    public void testInfiniteValues(){
        assertTrue(calculator.tg(Math.PI/2) > 10e10); //inf
        assertTrue(calculator.tg(-Math.PI/2) < 10e10); //-inf
    }

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                arguments(0.0, 0.0),
                arguments(Math.PI, 0.0),
                arguments(-Math.PI/4, -1.0),
                arguments(Math.PI/4, 1.0)
        );
    }
}
