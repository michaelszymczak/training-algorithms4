package com.michaelszymczak.training.algorithms4;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void welcomes_you() throws Exception {
        App app = new App();

        String message = app.getGreetings();

        assertEquals("Algorithms 4th Edition, Welcome!", message);
    }

}