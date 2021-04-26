package com.michaelszymczak.training.grokalgo.chapter02;

import com.michaelszymczak.training.grokalgo.Properties;
import com.michaelszymczak.training.grokalgo.Fixtures;
import com.michaelszymczak.training.grokalgo.TimeComplexityTracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NaiveSortPropertyTest
{
    private final TimeComplexityTracker timeComplexityTracker = new TimeComplexityTracker();
    private final NaiveSort sort = new NaiveSort(timeComplexityTracker);

    @Test
    void shouldReturnMonotonicallyIncreasingArray()
    {
        final int[] input = Fixtures.generate(1000);
        final int[] inputCopy = Fixtures.copy(input);

        // When
        timeComplexityTracker.reset();
        int[] result = sort.sort(input);

        // Then
        assertThat(result.length).isEqualTo(input.length).describedAs("property: length is the same as the input");
        assertThat(input).isEqualTo(inputCopy).describedAs("property: input array is not modified");
        Properties.assertMonotonicallyIncreasing(result);
        Properties.assertValuesAddUp(input, result);
        assertThat(timeComplexityTracker.probablyLogN(input.length)).isFalse();
        assertThat(timeComplexityTracker.probablyN(input.length)).isFalse();
        assertThat(timeComplexityTracker.probablyN2(input.length)).isTrue();
    }
}
