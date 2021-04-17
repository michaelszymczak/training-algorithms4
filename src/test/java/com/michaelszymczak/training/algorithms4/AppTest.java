package com.michaelszymczak.training.algorithms4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest
{

    @Test
    public void welcomes_you() throws Exception
    {
        App app = new App();

        String message = app.getGreetings();

        assertEquals("Algorithms 4th Edition, Welcome!", message);
    }

}