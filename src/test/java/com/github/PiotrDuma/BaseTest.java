package com.github.PiotrDuma;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    protected Calculator calculator;

    @BeforeEach
    void setUp(){
        this.calculator = new Calculator();
    }
}
