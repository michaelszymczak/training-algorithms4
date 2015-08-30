package com.michaelszymczak.training.algorithms4.chapter01.section01;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _1_1Test {

    public static final double DELTA = 1e-20;

    @Test
    public void _1_1_1() throws Exception {
        assertDoubleEquals(7, (0 + 15) / 2);
        assertDoubleEquals(200.0000002, 2.0e-6 * 100000000.1);
        assertEquals(true, true && false || true && true);
    }

    @Test
    public void _1_1_2() throws Exception {
        assertDoubleEquals(1.618, (1 + 2.236) / 2);
        assertDoubleEquals(10.0, 1 + 2 + 3 + 4.0);
        assertTrue(4.1 > 4);
        assertEquals("33", 1 + 2 + "3");
    }


    @Test
    public void _1_1_3() throws Exception {
        assertEquals("equal", _1_1_3.check("5", "5", "5"));
        assertEquals("not equal", _1_1_3.check("5", "3", "5"));
        assertEquals("not equal", _1_1_3.check("a", "3", "3"));
        assertEquals("not equal", _1_1_3.check("a", "a", "a"));
    }

    @Test
    public void _1_1_4() throws Exception {
        // given
        int a = 0, b = 0, c = 0;
        // then

        // if (a > b) then c = 0; // no then keyword in java, should be:
        if (a > b) c = 0;

        // if a > b { c = 0; } // no parenthesis, should be
        if (a > b) { c = 0; }

        if (a > b) c = 0; // OK

        // if (a > b) c = 0 else b = 0; // no semicolon, should be:
        if (a > b) c = 0; else b = 0;
    }

    @Test
    public void _1_1_5() throws Exception {
        assertTrue(_1_1_5.areStrictlyBetweenZeroAndOne(0.1, 0.1));
        assertTrue(_1_1_5.areStrictlyBetweenZeroAndOne(0.5, 0.3));
        assertTrue(_1_1_5.areStrictlyBetweenZeroAndOne(0.3, 0.5));
        assertTrue(_1_1_5.areStrictlyBetweenZeroAndOne(0.0, 0.1));
        assertTrue(_1_1_5.areStrictlyBetweenZeroAndOne(0.0, 0.0));
        assertTrue(_1_1_5.areStrictlyBetweenZeroAndOne(0.0, 1.0));
        assertTrue(_1_1_5.areStrictlyBetweenZeroAndOne(1.0, 0.0));
        assertTrue(_1_1_5.areStrictlyBetweenZeroAndOne(1.0, 1.0));
        assertFalse(_1_1_5.areStrictlyBetweenZeroAndOne(0.0, -0.1));
        assertFalse(_1_1_5.areStrictlyBetweenZeroAndOne(-0.1, 0.0));
        assertFalse(_1_1_5.areStrictlyBetweenZeroAndOne(0.0, 1.1));
        assertFalse(_1_1_5.areStrictlyBetweenZeroAndOne(1.1, 0.0));
    }

    @Test
    public void _1_1_6() throws Exception {
        assertEquals("0,", _1_1_6.numbers(0));
        assertEquals("0,1,", _1_1_6.numbers(1));
        assertEquals("0,1,1,", _1_1_6.numbers(2));
        assertEquals("0,1,1,2,", _1_1_6.numbers(3));
        assertEquals("0,1,1,2,3,", _1_1_6.numbers(4));
        assertEquals("0,1,1,2,3,5,", _1_1_6.numbers(5));
        assertEquals("0,1,1,2,3,5,8,", _1_1_6.numbers(6));
        assertEquals("0,1,1,2,3,5,8,13,", _1_1_6.numbers(7));
        assertEquals("0,1,1,2,3,5,8,13,21,", _1_1_6.numbers(8));
        assertEquals("0,1,1,2,3,5,8,13,21,34,", _1_1_6.numbers(9));
        assertEquals("0,1,1,2,3,5,8,13,21,34,55,", _1_1_6.numbers(10));
        assertEquals("0,1,1,2,3,5,8,13,21,34,55,89,", _1_1_6.numbers(11));
        assertEquals("0,1,1,2,3,5,8,13,21,34,55,89,144,", _1_1_6.numbers(12));
        assertEquals("0,1,1,2,3,5,8,13,21,34,55,89,144,233,", _1_1_6.numbers(13));
        assertEquals("0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,", _1_1_6.numbers(14));
        assertEquals("0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,", _1_1_6.numbers(15));
    }

        private void assertDoubleEquals(double expected, double actual) {
        assertEquals(expected, actual, DELTA);
    }

}