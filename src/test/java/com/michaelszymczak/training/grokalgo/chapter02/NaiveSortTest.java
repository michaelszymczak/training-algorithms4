package com.michaelszymczak.training.grokalgo.chapter02;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NaiveSortTest
{

    private static final int SENTINEL = Integer.MAX_VALUE;
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
        assertThat(this.sort.sort(new int[]{-1, 2, 3})).isEqualTo(new int[]{-1, 2, 3});
    }

    @Test
    void shouldPrioritizeLowerValues()
    {
        assertThat(this.sort.sort(new int[]{2, 1})).isEqualTo(new int[]{1, 2});
    }

    @Test
    void shouldNotAllowSentinelValueUntilTested()
    {
        assertThatThrownBy(() -> sort.sort(new int[]{Integer.MAX_VALUE})).isInstanceOf(IllegalArgumentException.class);
    }

    private static final class NaiveSort
    {
        public int[] sort(final int[] input)
        {
            for (int i = 0; i < input.length; i++)
            {
                if (input[i] == SENTINEL)
                {
                    throw new IllegalArgumentException(SENTINEL + " value not supported");
                }
            }
            final int[] inputCopy = new int[input.length];
            final int[] result = new int[input.length];
            System.arraycopy(input, 0, inputCopy, 0, input.length);
            for (int i = 0; i < input.length; i++)
            {
                int minValueFoundSoFar = SENTINEL;
                int minIndexFoundSoFar = 0;
                for (int j = 0; j < inputCopy.length; j++)
                {
                    int candidate = inputCopy[j];
                    if (candidate <= minValueFoundSoFar)
                    {
                        minValueFoundSoFar = candidate;
                        minIndexFoundSoFar = j;
                    }
                }

                int nextLowestValue = inputCopy[minIndexFoundSoFar];
                inputCopy[minIndexFoundSoFar] = SENTINEL;
                result[i] = nextLowestValue;
            }
            return result;
        }
    }
}
