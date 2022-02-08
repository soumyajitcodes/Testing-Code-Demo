package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest2 {
    @ParameterizedTest
    @ValueSource(doubles = {79.0, 89.0, 95.0, 110.0})
    void should_ReturnTrue_when_DietRecommended(double coderWeight) {
        // given
        double weight = coderWeight;
        double height = 1.72;

        // when
        boolean result = BMICalculator.isDietRecommended(weight, height);

        // then
        assertTrue(result);

    }

}