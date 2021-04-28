package com.michaelszymczak.training.grokalgo.chapter03;

import java.util.concurrent.ThreadLocalRandom;


import static java.lang.System.arraycopy;

class QuickSort
{
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    public int[] sorted(final int[] input)
    {
        final int[] copy = new int[input.length];
        arraycopy(input, 0, copy, 0, input.length);
        sort(copy, 0, copy.length);
        return copy;
    }

    private void sort(final int[] input, final int offset, final int length)
    {
        if (length < 2)
        {
            return;
        }

        int lowValuesLength = group(input, offset, length);
        sort(input, offset, lowValuesLength);
        sort(input, offset + lowValuesLength + 1, length - lowValuesLength - 1);
    }

    private int group(final int[] input, final int offset, final int length)
    {
        final int pivotIndex = offset + random.nextInt(0, length);
        final int endIndex = offset + length - 1;

        final int pivot = input[pivotIndex];
        input[pivotIndex] = input[endIndex];

        int lowValuesFrontIndex = offset;
        for (int groupedValuesFrontIndex = offset; groupedValuesFrontIndex < endIndex; groupedValuesFrontIndex++)
        {
            int value = input[groupedValuesFrontIndex];
            if (value < pivot)
            {
                if (groupedValuesFrontIndex > lowValuesFrontIndex)
                {
                    int evictedHighValue = input[lowValuesFrontIndex];
                    input[lowValuesFrontIndex] = value;
                    input[groupedValuesFrontIndex] = evictedHighValue;
                }
                lowValuesFrontIndex++;
            }
        }

        input[endIndex] = input[lowValuesFrontIndex];
        input[lowValuesFrontIndex] = pivot;

        return lowValuesFrontIndex - offset;
    }
}