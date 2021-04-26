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
        if (length == 0)
        {
            return new int[0];
        }
        else if (length == 1)
        {
            return new int[]{input[from]};
        }
        else if (length == 2)
        {
            int[] result = new int[2];
            if (input[from] > input[from + 1])
            {
                result[0] = input[from + 1];
                result[1] = input[from];
            }
            else
            {
                result[0] = input[from];
                result[1] = input[from + 1];
            }
            return result;
        }
        else
        {
            final int[] result = new int[length];
            int[] sortedLow = sorted(input, 0, 2);
            arraycopy(sortedLow, 0, result, 0, 2);
            result[2] = input[from+2];
            if (length > 3)
            {
                int[] sortedHigh = sorted(input, 3, 5);
                arraycopy(sortedHigh, 0, result, 3, 2);
            }
            return result;
        }
    }
}
