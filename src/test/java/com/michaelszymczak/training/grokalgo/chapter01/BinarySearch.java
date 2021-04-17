package com.michaelszymczak.training.grokalgo.chapter01;

final class BinarySearch
{
    public static final int NOT_FOUND = -1;

    public int find(final int[] input, final int sought)
    {
        final int lowIndex = 0;
        final int highIndex = input.length - 1;
        if (lowIndex > highIndex)
        {
            return NOT_FOUND;
        }
        int guessIndex = 0;

        return input[guessIndex] == sought ? 0 : NOT_FOUND;
    }
}
