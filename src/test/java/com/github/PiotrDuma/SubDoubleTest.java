package com.github.PiotrDuma;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SubDoubleTest extends BaseTest{


    @ParameterizedTest(name = "SUM: {0} - {1} should result {2}")
    @MethodSource("dataSource")
    @DisplayName("Should subtract two double values")
    public void sumTest(double a, double b, double expected){
        double result = calculator.sub(a, b);

        assertEquals(expected, result, 0.001);
    }

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                arguments(1.1, 2.0, -0.9),
                arguments(2.2, 2.2, 0.0),
                arguments(2.1, 1.001, 1.099),
                arguments(0.0, 0.0, 0.0)
        );
    }
}
