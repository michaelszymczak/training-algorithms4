package com.michaelszymczak.training.grokalgo.chapter03;

import static java.lang.System.arraycopy;

public class QuickSort
{
    public int[] sort(final int[] input)
    {
        final int[] result = new int[input.length];
        arraycopy(input, 0, result, 0, input.length);
        if (result.length == 2 && result[0] > result[1])
        {
            int tmp = result[0];
            result[0] = result[1];
            result[1] = tmp;
        }
        return result;
    }
}
