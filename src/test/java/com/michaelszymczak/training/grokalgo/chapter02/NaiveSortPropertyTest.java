package com.michaelszymczak.training.grokalgo.chapter02;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NaiveSortPropertyTest
{
    private final NaiveSort sort = new NaiveSort();
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Test
    void shouldReturnMonotonicallyIncreasingArray()
    {
        final int[] input = generate(100);
        final int[] inputCopy = copy(input);

        // When
        int[] result = this.sort.sort(input);

        // Then
        assertThat(result.length).isEqualTo(input.length).describedAs("property: length is the same as the input");
        assertThat(input).isEqualTo(inputCopy).describedAs("property: input array is not modified");
        assertMonotonicallyIncreasing(result);
        assertValuesAddUp(input, result);
    }

    private void assertMonotonicallyIncreasing(final int[] result)
    {
        int highestValueSoFar = Integer.MIN_VALUE;
        for (final int value : result)
        {
            assertThat(value).isGreaterThanOrEqualTo(highestValueSoFar);
            highestValueSoFar = value;
        }
    }

    private void assertValuesAddUp(final int[] input, final int[] result)
    {
        long diff = 0;
        for (int i = 0; i < input.length; i++)
        {
            diff += input[i];
            diff -= result[i];
        }
        assertThat(diff).isEqualTo(0);
    }

    private int[] copy(final int[] input)
    {
        final int[] inputCopy = new int[input.length];
        System.arraycopy(input, 0, inputCopy, 0, input.length);
        return inputCopy;
    }

    private int[] generate(final int size)
    {
        return IntStream.generate(() -> random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE)).limit(size).toArray();
    }
}
