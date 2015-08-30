package com.michaelszymczak.training.algorithms4.chapter01.section01;

public class _01_01_06 {

    public static String numbers(int maxI) {
        String result = "";
        int f = 0;
        int g = 1;
        for (int i = 0; i <= maxI; i++)
        {
            result += f + ",";
            f = f + g;
            g = f - g;
        }

        return result;
    }
}
