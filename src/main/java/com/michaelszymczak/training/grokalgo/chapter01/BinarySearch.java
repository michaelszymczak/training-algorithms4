package com.michaelszymczak.training.grokalgo.chapter01;

import com.michaelszymczak.training.grokalgo.TimeComplexity;

final class BinarySearch
{
    public static final int NOT_FOUND = -1;
    private final TimeComplexity timeComplexity;

    public BinarySearch()
    {
        this(TimeComplexity.IGNORE_TIME_COMPLEXITY);
    }

    public BinarySearch(final TimeComplexity timeComplexity)
    {
        this.timeComplexity = timeComplexity;
    }

    public int find(final int[] input, final int sought)
    {
        int lowIndex = 0;
        int highIndex = input.length - 1;
        while (lowIndex <= highIndex)
        {
            timeComplexity.onOperation();
            int mid = (lowIndex + highIndex) / 2;
            int guess = input[mid];
            if (guess == sought)
            {
                return mid;
            }
            else if (guess < sought)
            {
                lowIndex = mid + 1;
            }
            else
            {
                highIndex = mid - 1;
            }
        }
        return NOT_FOUND;
    }
}