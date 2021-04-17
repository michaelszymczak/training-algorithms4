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

    @Test
    void shouldFindOnlyElement()
    {
        final int[] input = new int[]{3};
        int result = binarySearch.find(input, 3);
        assertThat(result).isEqualTo(0);
    }
}
