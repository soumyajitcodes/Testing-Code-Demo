package com.healthycoderapp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest4 {
    @ParameterizedTest(name = "Weight={0}, Height={1}")
    @CsvFileSource(resources = "/diet-recommended-input-data.csv", numLinesToSkip = 1)
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