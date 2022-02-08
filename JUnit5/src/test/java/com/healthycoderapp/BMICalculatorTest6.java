package com.healthycoderapp;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest6 {
    private String environment = "dev";

    @Nested
    @DisplayName("Diet Recommender Test Class")
    @DisabledOnOs(OS.LINUX)
    class IsDietRecommendedTests {
        @Test
        @DisplayName("Diet Recommended Test Method")
        void should_ReturnTrue_DietRecommended() {
            double weight = 89.0;
            double height = 1.72;
            boolean recommendation = BMICalculator.isDietRecommended(weight, height);
            assertTrue(recommendation);
        }

        @Test
        void should_ReturnFalse_DietNotRecommended() {
            double weight = 59.0;
            double height = 1.72;
            boolean recommendation = BMICalculator.isDietRecommended(weight, height);
            assertFalse(recommendation);
        }
    }

    @Nested
    class DataCheckerTests {
        @Test
        void should_ReturnException_HeightIsZero() {
            double weight = 59.0;
            double height = 0.0;
            Executable executable = () -> BMICalculator.isDietRecommended(weight, height);
            assertThrows(ArithmeticException.class, executable);
        }
    }

    @Nested
    class FindCoderWithWorstBMITests {
        @Test
        void should_ReturnCoderWithWorstBMI_WhenCoderNotEmpty() {
            List<Coder> coders = new ArrayList<>();
            coders.add(new Coder(1.80, 60.0));
            coders.add(new Coder(1.82, 98.0));
            coders.add(new Coder(1.82, 64.7));
            Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
            assertAll(
                    ()->assertEquals(1.82, coderWorstBMI.getHeight()),
                    ()->assertEquals(98.0, coderWorstBMI.getWeight())
            );
        }

        @Test
        void should_ReturnCoderWithWorstBMI_WhenCoderIsEmpty() {
            List<Coder> coders = new ArrayList<>();
            Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
            assertNull(coderWorstBMI);
        }
    }
}