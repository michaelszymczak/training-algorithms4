package com.michaelszymczak.training.grokalgo.chapter03;

import static java.lang.System.arraycopy;

public class QuickSort
{
    public int[] sort(final int[] input)
    {
        return sorted(input, 0, input.length);
    }

    private int[] sorted(final int[] input, final int from, final int to)
    {
        int length = to - from;
        final int[] result = new int[length];
        arraycopy(input, from, result, 0, length);
        if (length == 2)
        {
            if (result[0] > result[1])
            {
                int tmp = result[0];
                result[0] = result[1];
                result[1] = tmp;
            }
            return result;
        }
        else if (length < 2)
        {
            return result;
        }

        int[] sortedLow = sorted(result, 0, 2);
        arraycopy(sortedLow, 0, result, 0, 2);
        if (length > 3)
        {
            int[] sortedHigh = sorted(result, 3, 5);
            arraycopy(sortedHigh, 0, result, 3, 2);
        }
        return result;
    }
}
