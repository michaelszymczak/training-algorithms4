package com.michaelszymczak.training.grokalgo.chapter03;

import static java.lang.System.arraycopy;

public class QuickSort
{

    private static final int[] EMPTY_ARRAY = new int[0];

    public int[] sort(final int[] input)
    {
        return sorted(input, 0, input.length);
    }

    private int[] sorted(final int[] input, final int startIndex, final int to)
    {
        int length = to - startIndex;
        if (length == 0)
        {
            return EMPTY_ARRAY;
        }
        else if (length == 1)
        {
            return new int[]{input[startIndex]};
        }
        else if (length == 2)
        {
            int[] result = new int[2];
            if (input[startIndex] > input[startIndex + 1])
            {
                result[0] = input[startIndex + 1];
                result[1] = input[startIndex];
            }
            else
            {
                result[0] = input[startIndex];
                result[1] = input[startIndex + 1];
            }
            return result;
        }
        else
        {
            int pivotIndex = startIndex + 2;
            final int pivotValue = input[pivotIndex];
            final int[] result = new int[length];
            int lowIndex = 0;
            int highIndex = length - 1;
            for (int i = startIndex; i < startIndex + length; i++)
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
            result[lowIndex] = pivotValue;
            int[] sortedLow = sorted(result, 0, lowIndex);
            arraycopy(sortedLow, 0, result, 0, lowIndex);
            int[] sortedHigh = sorted(result, highIndex, length);
            arraycopy(sortedHigh, 0, result, highIndex, length - highIndex);

            return result;
        }
    }
}
