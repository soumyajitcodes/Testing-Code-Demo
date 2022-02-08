package com.healthycoderapp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {
    @Test
    void should_ReturnTrue_DietRecommended() {
        // given
        double weight = 89.0;
        double height = 1.72;

        // when
        boolean recommendation = BMICalculator.isDietRecommended(weight, height);

        // then
        assertTrue(recommendation);
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

    @Test
    void should_ReturnException_HeightIsZero() {
        double weight = 59.0;
        double height = 0.0;

        Executable executable = () -> BMICalculator.isDietRecommended(weight, height);

        assertThrows(ArithmeticException.class, executable);
    }

    @Test
    void should_ReturnCoderWithWorstBMI_WhenCoderNotEmpty() {
        // given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80, 60.0));
        coders.add(new Coder(1.82, 98.0));
        coders.add(new Coder(1.82, 64.7));

        // when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        // then
        assertAll(
                ()->assertEquals(1.82, coderWorstBMI.getHeight()),
                ()->assertEquals(98.0, coderWorstBMI.getWeight())
        );
    }

    @Test
    void should_ReturnCoderWithWorstBMI_WhenCoderIsEmpty() {
        // given
        List<Coder> coders = new ArrayList<>();

        // when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        // then
        assertNull(coderWorstBMI);
    }

    @Test
    void should_ReturnCorrectBMIScoreArray_When_ListNotEmpty() {
        // given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80, 60.0));
        coders.add(new Coder(1.82, 98.0));
        coders.add(new Coder(1.82, 64.7));
        double[] expected = {18.52, 29.59, 19.53};

        // when
        double[] bmiScores = BMICalculator.getBMIScores(coders);

        // then
        assertArrayEquals(expected, bmiScores);

    }

    @AfterEach
    void afterEach() {
        System.out.println("An unit test was finished");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all Unit tests");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all nit tests");
    }

}