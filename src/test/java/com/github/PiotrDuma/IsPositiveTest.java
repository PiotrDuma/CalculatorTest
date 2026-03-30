package com.github.PiotrDuma;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsPositiveTest extends BaseTest{

    @Test
    @DisplayName("Min positive number should return true")
    public void minPositiveNumberShouldReturnTrue(){
        assertTrue(calculator.isPositive(1));
    }

    @Test
    @DisplayName("MAX positive number should return true")
    public void maxPositiveNumberShouldReturnTrue(){
        assertTrue(calculator.isPositive(Long.MAX_VALUE));
    }

    @Test
    @DisplayName("Zero should return false")
    public void zeroShouldReturnFalse(){
        assertFalse(calculator.isPositive(0));
    }

    @Test
    @DisplayName("Negative should return false")
    public void negativeShouldReturnFalse(){
        assertFalse(calculator.isPositive(-1));
    }
}
