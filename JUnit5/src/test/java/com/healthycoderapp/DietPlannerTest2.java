package com.healthycoderapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DietPlannerTest2 {
    private DietPlanner dietPlanner;

    @BeforeEach
    void setup() {
        dietPlanner = new DietPlanner(20, 30, 50);
    }

    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    void should_ReturnCorrectDietPlan_When_CorrectCoder() {
        // given
        Coder coder = new Coder(1.82, 75.0, 26, Gender.MALE);
        DietPlan expected = new DietPlan(2202, 110,73,275);

        // when
        DietPlan calculated = dietPlanner.calculateDiet(coder);

        // then
        assertAll(
                ()->assertEquals(expected.getCalories(), calculated.getCalories()),
                ()->assertEquals(expected.getProtein(), calculated.getProtein()),
                ()->assertEquals(expected.getFat(), calculated.getFat()),
                ()->assertEquals(expected.getCarbohydrate(), calculated.getCarbohydrate())
        );

    }

}