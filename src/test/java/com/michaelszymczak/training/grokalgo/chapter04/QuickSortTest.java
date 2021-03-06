package com.michaelszymczak.training.grokalgo.chapter04;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSortTest
{

    private final QuickSort sort = new QuickSort();

    @Test
    void shouldReturnEmptyArrayAsIs()
    {
        int[] result = sort.sorted(new int[0]);
        assertThat(result).isEqualTo(new int[0]);
    }

    @Test
    void shouldConsiderSingleElementToBeAlreadySorted()
    {
        int[] result = sort.sorted(new int[]{4});
        assertThat(result).isEqualTo(new int[]{4});
    }

    @Test
    void shouldSwapTwoElementsToMakeThemSorted()
    {
        int[] result = sort.sorted(new int[]{4, 1});
        assertThat(result).isEqualTo(new int[]{1, 4});
    }

    @Test
    void shouldSortFirstTwoElements()
    {
        int[] result = sort.sorted(new int[]{-2, -3, -1});
        assertThat(result).isEqualTo(new int[]{-3, -2, -1});
    }

    @Test
    void shouldSortLastTwoElements()
    {
        int[] result = sort.sorted(new int[]{-3, -1, -2});
        assertThat(result).isEqualTo(new int[]{-3, -2, -1});
    }

    @Test
    void shouldSortFirstAndLastTwoElements()
    {
        int[] result = sort.sorted(new int[]{-1, -2, 0, 2, 1});
        assertThat(result).isEqualTo(new int[]{-2, -1, 0, 1, 2});
    }

    @Test
    void shouldKeepAlreadySortedBothElements()
    {
        int[] result = sort.sorted(new int[]{-3, -2});
        assertThat(result).isEqualTo(new int[]{-3, -2});
    }

    @Test
    void shouldSortWhenPivotElementInTheMiddle()
    {
        int[] result = sort.sorted(new int[]{2, 1, 0, -1, -2});
        assertThat(result).isEqualTo(new int[]{-2, -1, 0, 1, 2});
    }

    @Test
    void shouldSortSevenElements()
    {
        int[] result = sort.sorted(new int[]{6, 5, 4, 3, 2, 1, 0});
        assertThat(result).isEqualTo(new int[]{0, 1, 2, 3, 4, 5, 6});
    }

    @Test
    void shouldMaintainTheSameIdenticalElements()
    {
        int[] result = sort.sorted(new int[]{2, 2, 2});
        assertThat(result).isEqualTo(new int[]{2, 2, 2});
    }

    @Test
    void shouldNotMutateTheInput()
    {
        int[] input = {4, 1};
        sort.sorted(input);
        assertThat(input).isEqualTo(new int[]{4, 1});
    }
}
