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
            int pivotIndex = from + 2;
            final int pivotValue = input[pivotIndex];
            final int[] result = new int[length];
            int lowIndex = 0;
            int highIndex = length - 1;
            for (int i = from; i < to; i++)
            {
                if (i == pivotIndex)
                {
                    continue;
                }
                int value = input[i];
                if (value < pivotValue)
                {
                    result[lowIndex++] = value;
                }
                else
                {
                    result[highIndex--] = value;
                }
            }
            int[] sortedLow = sorted(result, 0, 2);
            arraycopy(sortedLow, 0, result, 0, 2);
            result[2] = pivotValue;
            if (length > 3)
            {
                int[] sortedHigh = sorted(result, 3, 5);
                arraycopy(sortedHigh, 0, result, 3, 2);
            }
            return result;
        }
    }
}
