package com.michaelszymczak.training.grokalgo.chapter03;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSortTest
{

    private final QuickSort sort = new QuickSort();

    @Test
    void shouldReturnEmptyArrayAsIs()
    {
        int[] result = sort.sort(new int[0]);
        assertThat(result).isEqualTo(new int[0]);
    }

    @Test
    void shouldConsiderSingleElementToBeAlreadySorted()
    {
        int[] result = sort.sort(new int[]{4});
        assertThat(result).isEqualTo(new int[]{4});
    }

    @Test
    void shouldSwapTwoElementsToMakeThemSorted()
    {
        int[] result = sort.sort(new int[]{4, 1});
        assertThat(result).isEqualTo(new int[]{1, 4});
    }

    @Test
    void shouldSortFirstTwoElements()
    {
        int[] result = sort.sort(new int[]{-2, -3, -1});
        assertThat(result).isEqualTo(new int[]{-3, -2, -1});
    }

    @Test
    void shouldKeepAlreadySortedBothElements()
    {
        int[] result = sort.sort(new int[]{-3, -2});
        assertThat(result).isEqualTo(new int[]{-3, -2});
    }

    @Test
    void shouldNotMutateTheInput()
    {
        int[] input = {4, 1};
        sort.sort(input);
        assertThat(input).isEqualTo(new int[]{4, 1});
    }
}
