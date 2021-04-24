package com.michaelszymczak.training.grokalgo.chapter02;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NaiveSortTest
{

    private final NaiveSort sort = new NaiveSort();

    @Test
    void shouldResultInEmptyArrayWhenNoItems()
    {

        assertThat(sort.sort(new int[0])).isEmpty();
    }

    @Test
    void shouldReturnTheOnlyElement()
    {

        assertThat(this.sort.sort(new int[]{3})).isEqualTo(new int[]{3});
    }

    @Test
    void shouldHandleAlreadySortedInput()
    {
        assertThat(this.sort.sort(new int[]{-1,2,3})).isEqualTo(new int[]{-1,2,3});
    }

    private static final class NaiveSort
    {
        public int[] sort(final int[] input)
        {
            final int[] inputCopy = new int[input.length];
            final int[] result = new int[input.length];
            System.arraycopy(input, 0, inputCopy, 0, input.length);
            for (int i = 0; i < input.length; i++)
            {
                result[i] = nextElement(inputCopy);
            }
            return result;
        }

        private static final int SENTINEL = Integer.MAX_VALUE;

        private int nextElement(final int[] inputCopy)
        {
            for (int i = 0; i < inputCopy.length; i++)
            {
                if (inputCopy[i] != SENTINEL)
                {
                    int result = inputCopy[i];
                    inputCopy[i] = SENTINEL;
                    return result;
                }
            }
            return SENTINEL;
        }
    }
}
