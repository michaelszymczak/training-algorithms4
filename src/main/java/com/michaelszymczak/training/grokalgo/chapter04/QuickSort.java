package com.michaelszymczak.training.grokalgo.chapter04;

import java.util.concurrent.ThreadLocalRandom;


import static java.lang.System.arraycopy;

class QuickSort
{
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    public int[] sorted(final int[] input)
    {
        final int[] result = new int[input.length];
        arraycopy(input, 0, result, 0, input.length);
        return sort(result, 0, result.length - 1);
    }

    private int[] sort(final int[] input, final int startIndex, final int endIndex)
    {
        if (endIndex - startIndex < 1)
        {
            return input;
        }

        int pivotIndex = group(input, startIndex, endIndex);
        sort(input, startIndex, pivotIndex - 1);
        sort(input, pivotIndex + 1, endIndex);

        return input;
    }

    private int group(final int[] input, final int startIndex, final int endIndex)
    {
        int pivotIndex = random.nextInt(startIndex, endIndex + 1);
        int pivot = input[pivotIndex];
        input[pivotIndex] = input[endIndex];

        int lowSectionIndex = startIndex;
        for (int i = startIndex; i < endIndex; i++)
        {
            if (input[i] < pivot)
            {
                int tmp = input[lowSectionIndex];
                input[lowSectionIndex] = input[i];
                input[i] = tmp;
                lowSectionIndex++;
            }
        }
        input[endIndex] = input[lowSectionIndex];
        input[lowSectionIndex] = pivot;
        return lowSectionIndex;
    }
}