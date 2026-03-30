package com.github.PiotrDuma;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SqrtTest extends BaseTest{

    @ParameterizedTest
    @DisplayName("Should return sqrt of a positive value")
    @CsvSource({
            "4.0, 2.0",
            "1.0, 1.0",
            "0.0, 0.0",
            "3, 1.732",
            "0.25, 0.5"
    })
    public void shouldReturnSqrtValueOfPositiveInput(double value, double expected){
        assertEquals(expected, calculator.sqrt(value), 0.001);
    }

    @ParameterizedTest
    @DisplayName("Should return sqrt of a negative value")
    @CsvSource({
            "-4.0, 2.0",
            "-1.0, 1.0",
            "-2, 1.414",
            "-0.25, 0.5",
    })
    public void shouldReturnSqrtValueOfNegativeInput(double value, double expected){
        assertEquals(expected, calculator.sqrt(value), 0.001);
    }

    @Test
    @DisplayName("Should result 0 for 0 argument")
    public void shouldReturnZeroIfValueIsZero(){
        assertEquals(0.0, calculator.sqrt(0.0), 0.001);
    }

    @Test
    @DisplayName("Should calculate small value")
    public void shouldCalculateSmallValue(){
        assertEquals(1e-5, calculator.sqrt(1e-10), 1e-15);
    }

    @Test
    @DisplayName("Should calculate large value")
    public void shouldCalculateLargeValue(){
        assertEquals(1e10, calculator.sqrt(1e20), 1e20);
    }

    @Test
    @DisplayName("Should calculate infinity value")
    public void shouldCalculateInfinity(){
        assertTrue(Double.isInfinite(calculator.sqrt(Double.POSITIVE_INFINITY)));
        assertTrue(Double.isInfinite(calculator.sqrt(Double.NEGATIVE_INFINITY)));
    }
}
