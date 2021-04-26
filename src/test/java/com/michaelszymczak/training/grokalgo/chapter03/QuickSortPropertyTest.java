package com.michaelszymczak.training.grokalgo.chapter03;

import com.michaelszymczak.training.grokalgo.Fixtures;
import com.michaelszymczak.training.grokalgo.Properties;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSortPropertyTest
{
    private final QuickSort sort = new QuickSort();

    @Test
    void shouldReturnMonotonicallyIncreasingArray()
    {
        final int[] input = Fixtures.generate(1000);
        final int[] inputCopy = Fixtures.copy(input);

        // When
        int[] result = sort.sort(input);

        // Then
        assertThat(result.length).isEqualTo(input.length).describedAs("property: length is the same as the input");
        assertThat(input).isEqualTo(inputCopy).describedAs("property: input array is not modified");
        Properties.assertMonotonicallyIncreasing(result);
        Properties.assertValuesAddUp(input, result);
    }
}
