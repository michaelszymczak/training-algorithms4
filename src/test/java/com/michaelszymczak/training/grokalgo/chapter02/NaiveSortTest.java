package com.michaelszymczak.training.grokalgo.chapter02;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class NaiveSortTest
{
    private final NaiveSort sort = new NaiveSort();

    @Test
    void shouldResultInEmptyArrayWhenNoItems()
    {

        assertThat(sort.sorted(new int[0])).isEmpty();
    }

    @Test
    void shouldReturnTheOnlyElement()
    {

        assertThat(sort.sorted(new int[]{3})).isEqualTo(new int[]{3});
    }

    @Test
    void shouldHandleAlreadySortedInput()
    {
        assertThat(sort.sorted(new int[]{-1, 2, 3})).isEqualTo(new int[]{-1, 2, 3});
    }

    @Test
    void shouldPrioritizeLowerValues()
    {
        assertThat(sort.sorted(new int[]{2, 1})).isEqualTo(new int[]{1, 2});
    }

    @Test
    void shouldKeepTheSameValueTogether()
    {
        assertThat(sort.sorted(new int[]{5, 5, 3, 5, 3})).isEqualTo(new int[]{3, 3, 5, 5, 5});
    }

    @Test
    void shouldHandleBoundaryValues()
    {
        assertThat(sort.sorted(new int[]{MAX_VALUE, 1, -1, 0, MIN_VALUE, MAX_VALUE, MIN_VALUE})).isEqualTo(new int[]{MIN_VALUE, MIN_VALUE, -1, 0, 1, MAX_VALUE, MAX_VALUE});
    }
}
