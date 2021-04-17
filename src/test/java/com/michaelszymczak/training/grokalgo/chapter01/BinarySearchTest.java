package com.michaelszymczak.training.grokalgo.chapter01;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTest
{

    private final BinarySearch binarySearch = new BinarySearch();

    @Test
    void shouldNotFindAnythingInAnEmptyArray()
    {
        final int[] input = new int[0];
        int result = binarySearch.find(input, 3);
        assertThat(result).isEqualTo(BinarySearch.NOT_FOUND);
    }

    private static final class BinarySearch
    {
        public static final int NOT_FOUND = -1;

        public int find(final int[] input, final int sought)
        {
            return NOT_FOUND;
        }
    }
}
