package com.github.PiotrDuma;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsNegativeTest extends BaseTest{

    @Test
    @DisplayName("Min negative number should return true")
    public void minPositiveNumberShouldReturnTrue(){
        assertTrue(calculator.isNegative(-1));
    }

    @Test
    @DisplayName("MAX negative number should return true")
    public void maxPositiveNumberShouldReturnTrue(){
        assertTrue(calculator.isNegative(Long.MIN_VALUE));
    }

    @Test
    @DisplayName("Zero should return false")
    public void zeroShouldReturnFalse(){
        assertFalse(calculator.isNegative(0));
    }

    @Test
    @DisplayName("Positive should return false")
    public void negativeShouldReturnFalse(){
        assertFalse(calculator.isNegative(1));
    }
}
