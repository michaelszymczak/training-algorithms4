package com.michaelszymczak.training.algorithms4.chapter01.section01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class _01_01Test {

    public static final double DELTA = 1e-20;

    @Test
    public void _01_01_01() throws Exception {
        assertDoubleEquals(7, (0 + 15) / 2);
        assertDoubleEquals(200.0000002, 2.0e-6 * 100000000.1);
        assertEquals(true, true && false || true && true);
    }

    @Test
    public void _01_01_02() throws Exception {
        assertDoubleEquals(1.618, (1 + 2.236) / 2);
        assertDoubleEquals(10.0, 1 + 2 + 3 + 4.0);
        assertTrue(4.1 > 4);
        assertEquals("33", 1 + 2 + "3");
    }


    @Test
    public void _01_01_03() throws Exception {
        assertEquals("equal", _01_01_03.check("5", "5", "5"));
        assertEquals("not equal", _01_01_03.check("5", "3", "5"));
        assertEquals("not equal", _01_01_03.check("a", "3", "3"));
        assertEquals("not equal", _01_01_03.check("a", "a", "a"));
    }

    @Test
    public void _01_01_04() throws Exception {
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
    public void _01_01_05() throws Exception {
        assertTrue(_01_01_05.areStrictlyBetweenZeroAndOne(0.1, 0.1));
        assertTrue(_01_01_05.areStrictlyBetweenZeroAndOne(0.5, 0.3));
        assertTrue(_01_01_05.areStrictlyBetweenZeroAndOne(0.3, 0.5));
        assertTrue(_01_01_05.areStrictlyBetweenZeroAndOne(0.0, 0.1));
        assertTrue(_01_01_05.areStrictlyBetweenZeroAndOne(0.0, 0.0));
        assertTrue(_01_01_05.areStrictlyBetweenZeroAndOne(0.0, 1.0));
        assertTrue(_01_01_05.areStrictlyBetweenZeroAndOne(1.0, 0.0));
        assertTrue(_01_01_05.areStrictlyBetweenZeroAndOne(1.0, 1.0));
        assertFalse(_01_01_05.areStrictlyBetweenZeroAndOne(0.0, -0.1));
        assertFalse(_01_01_05.areStrictlyBetweenZeroAndOne(-0.1, 0.0));
        assertFalse(_01_01_05.areStrictlyBetweenZeroAndOne(0.0, 1.1));
        assertFalse(_01_01_05.areStrictlyBetweenZeroAndOne(1.1, 0.0));
    }

    @Test
    public void _01_01_06() throws Exception {
        assertEquals("0,", _01_01_06.numbers(0));
        assertEquals("0,1,", _01_01_06.numbers(1));
        // X(n) = X(n-2) + X(n-1)
        assertEquals("0,1,1,", _01_01_06.numbers(2));
        assertEquals("0,1,1,2,", _01_01_06.numbers(3));
        assertEquals("0,1,1,2,3,", _01_01_06.numbers(4));
        assertEquals("0,1,1,2,3,5,", _01_01_06.numbers(5));
        assertEquals("0,1,1,2,3,5,8,", _01_01_06.numbers(6));
        assertEquals("0,1,1,2,3,5,8,13,", _01_01_06.numbers(7));
        assertEquals("0,1,1,2,3,5,8,13,21,", _01_01_06.numbers(8));
        assertEquals("0,1,1,2,3,5,8,13,21,34,", _01_01_06.numbers(9));
        assertEquals("0,1,1,2,3,5,8,13,21,34,55,", _01_01_06.numbers(10));
        assertEquals("0,1,1,2,3,5,8,13,21,34,55,89,", _01_01_06.numbers(11));
        assertEquals("0,1,1,2,3,5,8,13,21,34,55,89,144,", _01_01_06.numbers(12));
        assertEquals("0,1,1,2,3,5,8,13,21,34,55,89,144,233,", _01_01_06.numbers(13));
        assertEquals("0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,", _01_01_06.numbers(14));
        assertEquals("0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,", _01_01_06.numbers(15));
    }

    @Test
    public void _01_01_07() throws Exception {
        assertEquals("3.00009\n", _01_01_07.a(9.0)); // square root, Newton's method
        assertEquals("499500", _01_01_07.b(1000)); // arithmetic series
        assertEquals("1023", _01_01_07.c(1000)); // geometric progression: 2^10 - 1
    }

    @Test
    public void _01_01_08() throws Exception {
        assertTrue('b' == 'b');
        assertTrue(197 == 'b' + 'c'); // http://stackoverflow.com/questions/8688668/in-java-is-the-result-of-the-addition-of-two-chars-an-int-or-a-char
        assertTrue('e' == 'a' + 4);
        assertTrue(101 == 'a' + 4);
    }

    

    private void assertDoubleEquals(double expected, double actual) {
        assertEquals(expected, actual, DELTA);
    }

}