package com.in28minutes.junit.helper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {
    StringHelper helper = new StringHelper();

    @Test
    public void test_truncateAInFirst2Positions_AinFirst2Positions() {
        // given
        String expected = "CD";

        // when
        String actual = helper.truncateAInFirst2Positions("AACD");

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void test_truncateAInFirst2Positions_AinFirstPosition() {
        // given
        String expected = "CD";

        // when
        String actual = helper.truncateAInFirst2Positions("ACD");

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void test_truncateAInFirst2Positions_ANotInAnyPosition() {
        // given
        String expected = "CDEF";

        // when
        String actual = helper.truncateAInFirst2Positions("CDEF");

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void test_truncateAInFirst2Positions_AinLast2Positions() {
        // given
        String expected = "CDAA";

        // when
        String actual = helper.truncateAInFirst2Positions("CDAA");

        // then
        assertEquals(expected, actual);
    }

}