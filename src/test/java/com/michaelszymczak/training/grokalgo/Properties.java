package com.michaelszymczak.training.grokalgo;

import static org.assertj.core.api.Assertions.assertThat;

public class Properties
{
    public static void assertValuesAddUp(final int[] input, final int[] result)
    {
        long diff = 0;
        for (int i = 0; i < input.length; i++)
        {
            diff += input[i];
            diff -= result[i];
        }
        assertThat(diff).isEqualTo(0);
    }

    public static void assertMonotonicallyIncreasing(final int[] result)
    {
        int highestValueSoFar = Integer.MIN_VALUE;
        for (final int value : result)
        {
            assertThat(value).isGreaterThanOrEqualTo(highestValueSoFar);
            highestValueSoFar = value;
        }
    }
}
