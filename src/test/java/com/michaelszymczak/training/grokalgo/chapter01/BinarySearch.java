package com.michaelszymczak.training.grokalgo.chapter01;

final class BinarySearch
{
    public static final int NOT_FOUND = -1;

    public int find(final int[] input, final int sought)
    {
        if (input.length == 0)
        {
            return NOT_FOUND;
        }
        return input[0] == sought ? 0 : NOT_FOUND;
    }
}
