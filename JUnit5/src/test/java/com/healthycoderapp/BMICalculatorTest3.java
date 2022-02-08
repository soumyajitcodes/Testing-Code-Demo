package com.healthycoderapp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest3 {
    @ParameterizedTest(name = "Weight={0}, Height={1}")
    @CsvSource(value = {"89.0, 1.72", "95.0, 1.75", "110.0, 1.78"})
    void should_ReturnTrue_when_DietRecommended(double coderWeight, double coderHeight) {
        // given
        double weight = coderWeight;
        double height = coderHeight;

        // when
        boolean result = BMICalculator.isDietRecommended(weight, height);

        // then
        assertTrue(result);
    }

}