package com.michaelszymczak.training.grokalgo.chapter01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest
{
    @Test
    void shouldNotFindAnythingInAnEmptyArray()
    {
        final BinarySearch binarySearch = new BinarySearch();
        final int[] input = new int[0];

        Assertions.assertThat(binarySearch.find(input, 3)).isEqualTo(-1);

    }

    private static final class BinarySearch
    {
        public int find(final int[] input, final int sought)
        {
            return -1;
        }
    }
}
