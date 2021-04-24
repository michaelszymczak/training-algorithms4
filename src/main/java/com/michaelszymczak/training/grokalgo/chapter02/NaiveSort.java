package com.michaelszymczak.training.grokalgo.chapter02;

import com.michaelszymczak.training.grokalgo.TimeComplexity;

final class NaiveSort
{
    private static final int SENTINEL = Integer.MAX_VALUE;
    private final TimeComplexity timeComplexity;

    public NaiveSort()
    {
        this(TimeComplexity.IGNORE_TIME_COMPLEXITY);
    }

    public NaiveSort(final TimeComplexity timeComplexity)
    {
        this.timeComplexity = timeComplexity;
    }

    public int[] sort(final int[] input)
    {
        final int[] inputCopy = new int[input.length];
        final int[] result = new int[input.length];
        System.arraycopy(input, 0, inputCopy, 0, input.length);
        for (int i = 0; i < input.length; i++)
        {
            int minValueFoundSoFar = SENTINEL;
            int minIndexFoundSoFar = 0;
            for (int j = 0; j < inputCopy.length; j++)
            {
                timeComplexity.onOperation();
                int candidate = inputCopy[j];
                if (candidate <= minValueFoundSoFar)
                {
                    minValueFoundSoFar = candidate;
                    minIndexFoundSoFar = j;
                }
            }

            int nextLowestValue = inputCopy[minIndexFoundSoFar];
            inputCopy[minIndexFoundSoFar] = SENTINEL;
            result[i] = nextLowestValue;
        }
        return result;
    }
}
