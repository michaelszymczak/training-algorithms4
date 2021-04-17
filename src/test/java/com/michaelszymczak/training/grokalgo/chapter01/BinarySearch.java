package com.michaelszymczak.training.grokalgo.chapter01;

final class BinarySearch
{
    public static final int NOT_FOUND = -1;

    public int find(final int[] input, final int sought)
    {
        int lowIndex = 0;
        int highIndex = input.length - 1;
        while (lowIndex <= highIndex)
        {
            int mid = (lowIndex + highIndex) / 2;
            int guess = input[mid];
            if (guess == sought)
            {
                return mid;
            }
            lowIndex = mid + 1;
        }
        return NOT_FOUND;
    }
}