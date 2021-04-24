package com.michaelszymczak.training.grokalgo.chapter02;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NaiveSortTest
{
    @Test
    void shouldResultInEmptyArrayWhenNoItems()
    {
        NaiveSort sort = new NaiveSort();
        int[] result = sort.sort(new int[0]);
        assertThat(result).isEmpty();
    }

    private static final class NaiveSort
    {
        public int[] sort(final int[] input)
        {
            return new int[0];
        }
    }
}
