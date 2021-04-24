package com.michaelszymczak.training.grokalgo.chapter02;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NaiveSortTest
{

    private final NaiveSort sort = new NaiveSort();

    @Test
    void shouldResultInEmptyArrayWhenNoItems()
    {
        int[] result = sort.sort(new int[0]);

        assertThat(result).isEmpty();
    }

    @Test
    void shouldReturnTheOnlyElement()
    {
        int[] result = this.sort.sort(new int[]{3});

        assertThat(result).isEqualTo(new int[]{3});
    }

    private static final class NaiveSort
    {
        public int[] sort(final int[] input)
        {
            final int[] result = new int[input.length];
            if (input.length != 0)
            {
                result[0] = input[0];
            }
            return result;
        }
    }
}
