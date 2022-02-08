package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class BMICalculatorTest5 {
    private String environment = "dev";

    @Test
    void should_ReturnCoderWithWorstBMIIn1Ms_When_CoderListHas10000Elements() {
        // given
        assumeTrue(this.environment.equals("prod"));
        List<Coder> coders = new ArrayList<>();
        for (int i=0; i<10000; i++) {
            coders.add(new Coder(1.0+i, 10.0+i));
        }

        // when
        Executable executable = () -> BMICalculator.findCoderWithWorstBMI(coders);

        // then
        assertTimeout(Duration.ofMillis(20), executable);
    }

    @Test
    void should_ReturnFalse_DietNotRecommended() {
        // given
        double weight = 59.0;
        double height = 1.72;

        // when
        boolean recommendation = BMICalculator.isDietRecommended(weight, height);

        // then
        assertFalse(recommendation);
    }

}