package com.michaelszymczak.training.algorithms4.chapter01.section01;

import static java.lang.String.format;

public class _01_01_07 {

    public static String a(double t) {
        // looks like a square root, Newton's method
        while (Math.abs(t - 9.0/t) > .001)
            t = (9.0/t + t) / 2.0;

        return format("%.5f\n", t);
    }

    public static String b(int max) {
        // The result seems to be an arithmetic series (sum) of an
        // arithmetic progression with a1 = 1, d = 1 and n = max - 1
        // sum = n(a1 + an)/2 = (max - 1)(1 + max -1)/2 = (max^2 - max)/2
        int sum = 0;
        for (int i = 1; i < max; i++)
            for (int j = 0; j < i; j++)
                sum++;

        return format("%d", sum);
    }

    public static String c(int max) {
        // The result seems to be a geometric series (sum) of
        // geometric progression with a = 1, r = 2 and
        // am < limit, am = a*r^(m-1) => 1*2^(m-1) < max => (m-1) < log2max => m < log2max + 1
        // sum = a(1 - r^m) / ( 1 - r) => sum = (1 - 2^m) / -1 => sum = 2^m - 1
        int sum = 0;
        for (int i = 1; i < max; i *= 2)
            for (int j = 0; j < i; j++)
                sum++;

        return format("%d", sum);
    }
}
