package com.michaelszymczak.training.algorithms4.chapter01.section01;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
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

    private void assertDoubleEquals(double expected, double actual) {
        assertEquals(expected, actual, DELTA);
    }

}