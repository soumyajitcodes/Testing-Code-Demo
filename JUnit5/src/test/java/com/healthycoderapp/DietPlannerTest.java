package com.healthycoderapp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DietPlannerTest {
    private DietPlanner dietPlanner;

    @BeforeEach
    void setup() {
        this.dietPlanner = new DietPlanner(20, 30, 50);
    }

    @AfterEach
    void afterEach() {
        System.out.println("An unit test was finished");
    }

    @Test
    void should_ReturnCorrectDietPlan_When_CorrectCoder() {
        Coder coder = new Coder(1.82, 75.0, 26, Gender.MALE);
        DietPlan expected = new DietPlan(2202, 110,73,275);

        DietPlan calculated = dietPlanner.calculateDiet(coder);

        assertAll(
                ()->assertEquals(expected.getCalories(), calculated.getCalories()),
                ()->assertEquals(expected.getProtein(), calculated.getProtein()),
                ()->assertEquals(expected.getFat(), calculated.getFat()),
                ()->assertEquals(expected.getCarbohydrate(), calculated.getCarbohydrate())
        );

    }

}