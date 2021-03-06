package com.michaelszymczak.training.grokalgo.chapter01;

import java.util.stream.IntStream;

import com.michaelszymczak.training.grokalgo.TimeComplexityTracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


import static com.michaelszymczak.training.grokalgo.chapter01.BinarySearch.NOT_FOUND;

public class BinarySearchTest
{
    private final TimeComplexityTracker timeComplexityTracker = new TimeComplexityTracker();
    private final BinarySearch binarySearch = new BinarySearch(timeComplexityTracker);

    @Test
    void shouldNotFindAnythingInAnEmptyArray()
    {
        final int[] input = new int[0];
        int result = binarySearch.find(input, 3);
        assertThat(result).isEqualTo(NOT_FOUND);
    }

    @Test
    void shouldFindOnlyElement()
    {
        final int[] input = new int[]{3};
        int result = binarySearch.find(input, 3);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void shouldIgnoreNotMatchingOnlyElement()
    {
        final int[] input = new int[]{3};
        int result = binarySearch.find(input, 4);
        assertThat(result).isEqualTo(NOT_FOUND);
    }

    @Test
    void shouldFindMatchingElementOnRightSideOfTheMid()
    {
        assertThat(binarySearch.find(new int[]{3, 9}, 9)).isEqualTo(1);
        assertThat(binarySearch.find(new int[]{3, 9, 10}, 10)).isEqualTo(2);
        assertThat(binarySearch.find(new int[]{0, 1, 2, 3, 4}, 3)).isEqualTo(3);
    }

    @Test
    void shouldFindMatchingElementOnLeftSideOfTheMid()
    {
        assertThat(binarySearch.find(new int[]{3, 9, 10}, 3)).isEqualTo(0);
        assertThat(binarySearch.find(new int[]{0, 1, 2, 3, 4}, 1)).isEqualTo(1);
    }

    @Test
    void soakTestForValuePresent()
    {
        final int[] range = IntStream.range(0, 1000).toArray();
        for (int soughtValueMatchingIndex = 0; soughtValueMatchingIndex < range.length - 1; soughtValueMatchingIndex++)
        {
            int index = binarySearch.find(range, soughtValueMatchingIndex);
            assertThat(index).isEqualTo(soughtValueMatchingIndex);
        }
    }

    @Test
    void soakTestForValueAbsent()
    {
        final int inputSize = 1000;
        final int[] range = IntStream.range(0, inputSize).toArray();
        for (int soughtValueMatchingIndex = 0; soughtValueMatchingIndex < range.length - 1; soughtValueMatchingIndex++)
        {
            int absentValue = -soughtValueMatchingIndex - 1;
            timeComplexityTracker.reset();
            int index = binarySearch.find(range, absentValue);
            assertThat(index).isEqualTo(NOT_FOUND);
            assertThat(timeComplexityTracker.probablyLogN(inputSize)).isTrue();
        }
    }
}
